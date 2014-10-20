package xreliquary.items;

import com.google.common.collect.ImmutableMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.enderwizards.sandstone.init.ContentHandler;
import lib.enderwizards.sandstone.init.ContentInit;
import lib.enderwizards.sandstone.items.ItemToggleable;
import lib.enderwizards.sandstone.util.InventoryHelper;
import lib.enderwizards.sandstone.util.LanguageHelper;
import lib.enderwizards.sandstone.util.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import xreliquary.Reliquary;
import xreliquary.lib.Names;

import java.util.List;

@ContentInit
public class ItemVoidTear extends ItemToggleable {

    public ItemVoidTear() {
        super(Names.void_tear);
        setMaxStackSize(1);
        canRepair = false;
        this.setCreativeTab(null);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        this.formatTooltip(null, stack, list);

        ItemStack contents = this.getContainedItem(stack);

        if(this.isEnabled(stack)) {
            LanguageHelper.formatTooltip("tooltip.absorb_active", ImmutableMap.of("item", EnumChatFormatting.YELLOW + contents.getDisplayName()), stack, list);
            list.add(LanguageHelper.getLocalization("tooltip.absorb_tear"));
        }
        LanguageHelper.formatTooltip("tooltip.tear_quantity", ImmutableMap.of("item", contents.getDisplayName(), "amount", Integer.toString(contents.stackSize)), stack, list);
    }


    @Override
    public ItemStack onItemRightClick(ItemStack ist, World world, EntityPlayer player) {
        if (!world.isRemote) {

            if (player.isSneaking())
                return super.onItemRightClick(ist, world, player);
            if (this.attemptToEmptyIntoInventory(ist, player, player.inventory, player.inventory.mainInventory.length)) {
                player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F * ((player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.7F + 1.2F));
                NBTHelper.removeTag(ist);
                return new ItemStack(ContentHandler.getItem(Names.void_tear_empty), 1, 0);
            }
        }
        //hack. forces the client to re-evaluate the inventory due to the itemstack changing.
        ist.setItemDamage(ist.getItemDamage() == 0 ? 1 : 0);
        return ist;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean f) {
        if (!world.isRemote) {
            if (!this.isEnabled(stack) || !(entity instanceof EntityPlayer))
                return;

            EntityPlayer player = (EntityPlayer) entity;

            ItemStack contents = this.getContainedItem(stack);
            if (contents.stackSize < Reliquary.CONFIG.getInt(Names.void_tear, "item_limit") && InventoryHelper.consumeItem(contents, player, 1)) {
                this.onAbsorb(stack, player);
            }
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack ist, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (world.getTileEntity(x, y, z) instanceof IInventory) {
                IInventory inventory = (IInventory) world.getTileEntity(x, y, z);

                //enabled == drinking mode, we're going to drain the inventory of items.
                if (this.isEnabled(ist)) {
                    this.drainInventory(ist, player, inventory);
                } else {
                    //disabled == placement mode, try and stuff the tear's contents into the inventory
                    if (this.attemptToEmptyIntoInventory(ist, player, inventory, 0)) {
                        NBTHelper.removeTag(ist);
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ContentHandler.getItem(Names.void_tear_empty), 1, 0));
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected void onAbsorb(ItemStack ist, EntityPlayer player) {
        NBTHelper.setInteger("itemQuantity", ist, NBTHelper.getInteger("itemQuantity", ist) + 1);
    }

    protected ItemStack getContainedItem(ItemStack ist) {
        return new ItemStack((Item) Item.itemRegistry.getObject(NBTHelper.getString("itemID", ist)), NBTHelper.getInteger("itemQuantity", ist), NBTHelper.getShort("itemMeta", ist));
    }

    protected boolean attemptToEmptyIntoInventory(ItemStack ist, EntityPlayer player, IInventory inventory, int limit) {
        ItemStack contents = this.getContainedItem(ist);
        contents.stackSize = 1;

        int quantity = NBTHelper.getInteger("itemQuantity", ist);
        int minQuantity = quantity - contents.getMaxStackSize();

        while (quantity > Math.max(0, minQuantity)) {
            if (!tryToAddToInventory(contents, inventory, limit)) {
                break;
            }
            quantity--;
        }

        if (quantity == 0) {
            player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F * ((player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.7F + 1.8F));
            return true;
        } else {
            player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F * ((player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.7F + 1.2F));
            NBTHelper.setInteger("itemQuantity", ist, quantity);
            return false;
        }
    }

    protected void drainInventory(ItemStack ist, EntityPlayer player, IInventory inventory) {
        ItemStack contents = this.getContainedItem(ist);
        int limit = 0;
        int quantity = NBTHelper.getInteger("itemQuantity", ist);

        boolean foundItem = false;
        while (quantity < Reliquary.CONFIG.getInt(Names.void_tear, "item_limit")) {
            if (!tryToRemoveFromInventory(contents, inventory, limit)) {
                break;
            }
            quantity++;
            if (!foundItem) foundItem = true;
        }
        if (foundItem) player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F * ((player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.7F + 1.2F));

        NBTHelper.setInteger("itemQuantity", ist, quantity);
    }

    public boolean tryToAddToInventory(ItemStack contents, IInventory inventory, int limit) {
        for (int slot = 0; slot < Math.min(inventory.getSizeInventory(), (limit > 0 ? limit : inventory.getSizeInventory())); slot++) {
            if (inventory.getStackInSlot(slot) == null) {
                continue;
            }
            if (inventory.getStackInSlot(slot).isItemEqual(contents)) {
                if (inventory.getStackInSlot(slot).stackSize == inventory.getStackInSlot(slot).getMaxStackSize()) {
                    continue;
                }
                inventory.setInventorySlotContents(slot,new ItemStack(contents.getItem(), inventory.getStackInSlot(slot).stackSize + 1, contents.getItemDamage()));
                return true;
            }
        }
        for (int slot = 0; slot < Math.min(inventory.getSizeInventory(), (limit > 0 ? limit : inventory.getSizeInventory())); slot++) {
            if (inventory.getStackInSlot(slot) == null) {
                inventory.setInventorySlotContents(slot, new ItemStack(contents.getItem(), contents.stackSize, contents.getItemDamage()));
                return true;
            }
        }
        return false;
    }

    public boolean tryToRemoveFromInventory(ItemStack contents, IInventory inventory, int limit) {
        for (int slot = 0; slot < Math.min(inventory.getSizeInventory(), (limit > 0 ? limit : inventory.getSizeInventory())); slot++) {
            if (inventory.getStackInSlot(slot) == null) {
                continue;
            }
            if (inventory.getStackInSlot(slot).isItemEqual(contents)) {
                inventory.decrStackSize(slot, 1);
                return true;
            }
        }
        return false;
    }
}
