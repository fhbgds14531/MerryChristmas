package merrychristmas.mod.fhbgds.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKevin extends ModelBase{
	
	
    //fields
    //ModelRenderer body;
	ModelRenderer leg;
    ModelRenderer body;
    ModelRenderer head;
  
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
	    
	      leg = new ModelRenderer(this, 0, 0);
	      leg.addBox(-7F, 0F, -7F, 14, 16, 14);
	      leg.setRotationPoint(0F, 8F, 0F);
	      leg.setTextureSize(textureWidth, textureHeight);
	      leg.mirror = true;
	      setRotation(leg, 0F, 0F, 0F);
	      body = new ModelRenderer(this, 0, 0);
	      body.addBox(-7F, -16F, -7F, 14, 16, 14);
	      body.setRotationPoint(0F, 8F, 0F);
	      body.setTextureSize(textureWidth, textureHeight);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      head = new ModelRenderer(this, 0, 0);
	      head.addBox(-7F, -16F, -7F, 14, 16, 14);
	      head.setRotationPoint(0F, -8F, 0F);
	      head.setTextureSize(textureWidth, textureHeight);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    leg.render(f5);
    body.render(f5);
    head.render(f5);
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
