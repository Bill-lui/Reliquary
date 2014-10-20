package xreliquary.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCaster extends ModelBase
{
  //fields
    ModelRenderer feedingthing1;
    ModelRenderer GearR;
    ModelRenderer trigger3;
    ModelRenderer handle;
    ModelRenderer GearL;
    ModelRenderer HandleL;
    ModelRenderer HandleR;
    ModelRenderer Barreltip;
    ModelRenderer Base;
    ModelRenderer Barrel1;
    ModelRenderer Barrel3;
    ModelRenderer Barrel5;
    ModelRenderer Barrel4;
    ModelRenderer Misc1;
    ModelRenderer misc2;
    ModelRenderer misc3;
    ModelRenderer misc4;
    ModelRenderer misc5;
    ModelRenderer misc6;
    ModelRenderer Barrel2;
    ModelRenderer misc7;
    ModelRenderer misc8;
    ModelRenderer piston2;
    ModelRenderer misc9;
    ModelRenderer misc10;
    ModelRenderer misc11;
    ModelRenderer misc12;
    ModelRenderer BaseBack;
    ModelRenderer Piston1;
    ModelRenderer Grip;
    ModelRenderer trigger1;
    ModelRenderer trigger2;
  
  public ModelCaster()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      feedingthing1 = new ModelRenderer(this, 0, 4);
      feedingthing1.addBox(-2.5F, 1.5F, -5F, 5, 1, 5);
      feedingthing1.setRotationPoint(0F, 0F, 0F);
      feedingthing1.setTextureSize(textureWidth, textureHeight);
      feedingthing1.mirror = true;
      setRotation(feedingthing1, 0F, 0F, 0F);
      GearR = new ModelRenderer(this, 52, 32);
      GearR.addBox(-3.5F, -2.5F, -3F, 1, 5, 5);
      GearR.setRotationPoint(0F, 0F, -3F);
      GearR.setTextureSize(textureWidth, textureHeight);
      GearR.mirror = true;
      setRotation(GearR, 0F, 0F, 0F);
      trigger3 = new ModelRenderer(this, textureHeight, 42);
      trigger3.addBox(-0.5F, 8.5F, -8F, 1, 1, 2);
      trigger3.setRotationPoint(0F, 0F, 0F);
      trigger3.setTextureSize(textureWidth, textureHeight);
      trigger3.mirror = true;
      setRotation(trigger3, 0F, 0F, 0F);
      handle = new ModelRenderer(this, 84, 40);
      handle.addBox(-3F, -0.5F, 8.5F, 6, 1, 1);
      handle.setRotationPoint(0F, 0F, -3F);
      handle.setTextureSize(textureWidth, textureHeight);
      handle.mirror = true;
      setRotation(handle, 0F, 0F, 0F);
      GearL.mirror = true;
      GearL = new ModelRenderer(this, 52, 32);
      GearL.addBox(2.5F, -2.5F, -3F, 1, 5, 5);
      GearL.setRotationPoint(0F, 0F, -3F);
      GearL.setTextureSize(textureWidth, textureHeight);
      GearL.mirror = true;
      setRotation(GearL, 0F, 0F, 0F);
      GearL.mirror = false;
      HandleL = new ModelRenderer(this, textureHeight, 31);
      HandleL.addBox(3F, -1F, 1F, 1, 2, 9);
      HandleL.setRotationPoint(0F, 0F, -3F);
      HandleL.setTextureSize(textureWidth, textureHeight);
      HandleL.mirror = true;
      setRotation(HandleL, 0F, 0F, 0F);
      HandleR = new ModelRenderer(this, textureHeight, 31);
      HandleR.addBox(-4F, -1F, 1F, 1, 2, 9);
      HandleR.setRotationPoint(0F, 0F, -3F);
      HandleR.setTextureSize(textureWidth, textureHeight);
      HandleR.mirror = true;
      setRotation(HandleR, 0F, 0F, 0F);
      Barreltip = new ModelRenderer(this, 26, 1);
      Barreltip.addBox(-2F, -2F, -32F, 4, 4, 1);
      Barreltip.setRotationPoint(0F, 0F, 0F);
      Barreltip.setTextureSize(textureWidth, textureHeight);
      Barreltip.mirror = true;
      setRotation(Barreltip, 0F, 0F, 0F);
      Base = new ModelRenderer(this, 0, 19);
      Base.addBox(-3F, -3F, -7F, 6, 6, 7);
      Base.setRotationPoint(0F, 0F, 0F);
      Base.setTextureSize(textureWidth, textureHeight);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Barrel1 = new ModelRenderer(this, 32, 32);
      Barrel1.addBox(-2.5F, -2.5F, -12F, 5, 5, 5);
      Barrel1.setRotationPoint(0F, 0F, 0F);
      Barrel1.setTextureSize(textureWidth, textureHeight);
      Barrel1.mirror = true;
      setRotation(Barrel1, 0F, 0F, 0F);
      Barrel3 = new ModelRenderer(this, 18, 32);
      Barrel3.addBox(-2.5F, -2.5F, -23F, 5, 5, 2);
      Barrel3.setRotationPoint(0F, 0F, 0F);
      Barrel3.setTextureSize(textureWidth, textureHeight);
      Barrel3.mirror = true;
      setRotation(Barrel3, 0F, 0F, 0F);
      Barrel5 = new ModelRenderer(this, 0, 32);
      Barrel5.addBox(-2.5F, -2.5F, -31F, 5, 5, 1);
      Barrel5.setRotationPoint(0F, 0F, 0F);
      Barrel5.setTextureSize(textureWidth, textureHeight);
      Barrel5.mirror = true;
      setRotation(Barrel5, 0F, 0F, 0F);
      Barrel4 = new ModelRenderer(this, 26, 19);
      Barrel4.addBox(-3F, -3F, -30F, 6, 6, 7);
      Barrel4.setRotationPoint(0F, 0F, 0F);
      Barrel4.setTextureSize(textureWidth, textureHeight);
      Barrel4.mirror = true;
      setRotation(Barrel4, 0F, 0F, 0F);
      Misc1 = new ModelRenderer(this, 0, 32);
      Misc1.addBox(-1F, -3.5F, -3.5F, 2, 1, 3);
      Misc1.setRotationPoint(0F, 0F, 0F);
      Misc1.setTextureSize(textureWidth, textureHeight);
      Misc1.mirror = true;
      setRotation(Misc1, 0F, 0F, 0F);
      misc2 = new ModelRenderer(this, 0, 32);
      misc2.addBox(-0.5F, -4F, -3F, 1, 1, 7);
      misc2.setRotationPoint(0F, 0F, 0F);
      misc2.setTextureSize(textureWidth, textureHeight);
      misc2.mirror = true;
      setRotation(misc2, 0F, 0F, 0F);
      misc3 = new ModelRenderer(this, textureHeight, 42);
      misc3.addBox(-2.5F, 5.5F, -10.5F, 5, 1, 1);
      misc3.setRotationPoint(0F, 0F, 0F);
      misc3.setTextureSize(textureWidth, textureHeight);
      misc3.mirror = true;
      setRotation(misc3, 0F, 0F, 0F);
      misc4 = new ModelRenderer(this, textureHeight, 42);
      misc4.addBox(-2.5F, 3.5F, -15.5F, 5, 1, 1);
      misc4.setRotationPoint(0F, 0F, 0F);
      misc4.setTextureSize(textureWidth, textureHeight);
      misc4.mirror = true;
      setRotation(misc4, 0F, 0F, 0F);
      misc5 = new ModelRenderer(this, 0, 32);
      misc5.addBox(-1F, -4F, -29F, 2, 1, 3);
      misc5.setRotationPoint(0F, 0F, 0F);
      misc5.setTextureSize(textureWidth, textureHeight);
      misc5.mirror = true;
      setRotation(misc5, 0F, 0F, 0F);
      misc6 = new ModelRenderer(this, 0, 32);
      misc6.addBox(-0.5F, -4.5F, -34F, 1, 1, 7);
      misc6.setRotationPoint(0F, 0F, 0F);
      misc6.setTextureSize(textureWidth, textureHeight);
      misc6.mirror = true;
      setRotation(misc6, 0F, 0F, 0F);
      Barrel2 = new ModelRenderer(this, 26, 42);
      Barrel2.addBox(-3F, -3F, -21F, 6, 6, 9);
      Barrel2.setRotationPoint(0F, 0F, 0F);
      Barrel2.setTextureSize(textureWidth, textureHeight);
      Barrel2.mirror = true;
      setRotation(Barrel2, 0F, 0F, 0F);
      misc7 = new ModelRenderer(this, 0, 32);
      misc7.addBox(-2F, 5F, -10F, 1, 2, 2);
      misc7.setRotationPoint(0F, 0F, 0F);
      misc7.setTextureSize(textureWidth, textureHeight);
      misc7.mirror = true;
      setRotation(misc7, 0F, 0F, 0F);
      misc8 = new ModelRenderer(this, 0, 32);
      misc8.addBox(1F, 5F, -11F, 1, 2, 2);
      misc8.setRotationPoint(0F, 0F, 0F);
      misc8.setTextureSize(textureWidth, textureHeight);
      misc8.mirror = true;
      setRotation(misc8, 0F, 0F, 0F);
      piston2 = new ModelRenderer(this, textureHeight, 42);
      piston2.addBox(-0.5F, 4.5F, -15F, 1, 1, 3);
      piston2.setRotationPoint(0F, 0F, 0F);
      piston2.setTextureSize(textureWidth, textureHeight);
      piston2.mirror = true;
      setRotation(piston2, -0.0698132F, 0F, 0F);
      misc9 = new ModelRenderer(this, 0, 32);
      misc9.addBox(-2F, 3F, -16F, 1, 2, 2);
      misc9.setRotationPoint(0F, 0F, 0F);
      misc9.setTextureSize(textureWidth, textureHeight);
      misc9.mirror = true;
      setRotation(misc9, 0F, 0F, 0F);
      misc10 = new ModelRenderer(this, 0, 32);
      misc10.addBox(1F, 3F, -16F, 1, 2, 2);
      misc10.setRotationPoint(0F, 0F, 0F);
      misc10.setTextureSize(textureWidth, textureHeight);
      misc10.mirror = true;
      setRotation(misc10, 0F, 0F, 0F);
      misc11 = new ModelRenderer(this, 0, 31);
      misc11.addBox(1F, 3F, -11F, 1, 2, 5);
      misc11.setRotationPoint(0F, 0F, 0F);
      misc11.setTextureSize(textureWidth, textureHeight);
      misc11.mirror = true;
      setRotation(misc11, 0F, 0F, 0F);
      misc12 = new ModelRenderer(this, 0, 31);
      misc12.addBox(-2F, 3F, -11F, 1, 2, 5);
      misc12.setRotationPoint(0F, 0F, 0F);
      misc12.setTextureSize(textureWidth, textureHeight);
      misc12.mirror = true;
      setRotation(misc12, 0F, 0F, 0F);
      BaseBack = new ModelRenderer(this, 0, 10);
      BaseBack.addBox(-2.5F, -2.5F, 0F, 5, 5, 4);
      BaseBack.setRotationPoint(0F, 0F, 0F);
      BaseBack.setTextureSize(textureWidth, textureHeight);
      BaseBack.mirror = true;
      setRotation(BaseBack, 0F, 0F, 0F);
      Piston1 = new ModelRenderer(this, 0, 40);
      Piston1.addBox(-1F, 4F, -12F, 2, 2, 5);
      Piston1.setRotationPoint(0F, 0F, 0F);
      Piston1.setTextureSize(textureWidth, textureHeight);
      Piston1.mirror = true;
      setRotation(Piston1, -0.0698132F, 0F, 0F);
      Grip = new ModelRenderer(this, 0, 47);
      Grip.addBox(-2F, 1F, -7F, 4, 11, 6);
      Grip.setRotationPoint(0F, 0F, 0F);
      Grip.setTextureSize(textureWidth, textureHeight);
      Grip.mirror = true;
      setRotation(Grip, 0.2443461F, 0F, 0F);
      trigger1 = new ModelRenderer(this, textureHeight, 42);
      trigger1.addBox(-0.5F, 6.5F, -7F, 1, 2, 2);
      trigger1.setRotationPoint(0F, 0F, 0F);
      trigger1.setTextureSize(textureWidth, textureHeight);
      trigger1.mirror = true;
      setRotation(trigger1, 0F, 0F, 0F);
      trigger2 = new ModelRenderer(this, textureHeight, 42);
      trigger2.addBox(-0.5F, 5.5F, -8F, 1, 1, 2);
      trigger2.setRotationPoint(0F, 0F, 0F);
      trigger2.setTextureSize(textureWidth, textureHeight);
      trigger2.mirror = true;
      setRotation(trigger2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    feedingthing1.render(f5);
    GearR.render(f5);
    trigger3.render(f5);
    handle.render(f5);
    GearL.render(f5);
    HandleL.render(f5);
    HandleR.render(f5);
    Barreltip.render(f5);
    Base.render(f5);
    Barrel1.render(f5);
    Barrel3.render(f5);
    Barrel5.render(f5);
    Barrel4.render(f5);
    Misc1.render(f5);
    misc2.render(f5);
    misc3.render(f5);
    misc4.render(f5);
    misc5.render(f5);
    misc6.render(f5);
    Barrel2.render(f5);
    misc7.render(f5);
    misc8.render(f5);
    piston2.render(f5);
    misc9.render(f5);
    misc10.render(f5);
    misc11.render(f5);
    misc12.render(f5);
    BaseBack.render(f5);
    Piston1.render(f5);
    Grip.render(f5);
    trigger1.render(f5);
    trigger2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
    }

}
