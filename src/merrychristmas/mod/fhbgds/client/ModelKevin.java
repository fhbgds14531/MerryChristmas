package merrychristmas.mod.fhbgds.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKevin extends ModelBase{
	
	
    //fields
    //ModelRenderer body;
	ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
  
  public ModelKevin()
  {
//    textureWidth = 128;
//    textureHeight = 64;
//    
//      body = new ModelRenderer(this, 0, 0);
//      body.addBox(-7F, -12F, -7F, 14, 48, 14);
//      body.setRotationPoint(0F, -12F, 0F);
//      body.setTextureSize(textureWidth, textureHeight);
//      body.mirror = true;
//      this.setRotation(body, 0F, 0F, 0F);
	  
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      Body1 = new ModelRenderer(this, 0, 0);
	      Body1.addBox(-7F, 0F, -7F, 14, 16, 14);
	      Body1.setRotationPoint(0F, 8F, 0F);
	      Body1.setTextureSize(textureWidth, textureHeight);
	      Body1.mirror = true;
	      setRotation(Body1, 0F, 45F, 0F);
	      Body2 = new ModelRenderer(this, 0, 0);
	      Body2.addBox(-7F, -16F, -7F, 14, 16, 14);
	      Body2.setRotationPoint(0F, 8F, 0F);
	      Body2.setTextureSize(textureWidth, textureHeight);
	      Body2.mirror = true;
	      setRotation(Body2, 0F, 0F, 0F);
	      Body3 = new ModelRenderer(this, 0, 0);
	      Body3.addBox(-7F, -16F, -7F, 14, 16, 14);
	      Body3.setRotationPoint(0F, -8F, 0F);
	      Body3.setTextureSize(textureWidth, textureHeight);
	      Body3.mirror = true;
	      setRotation(Body3, 0F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body1.render(f5);
    Body2.render(f5);
    Body3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
