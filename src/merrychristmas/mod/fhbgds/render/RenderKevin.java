package merrychristmas.mod.fhbgds.render;

import merrychristmas.mod.fhbgds.client.ModelKevin;
import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.ResourceLocation;

public class RenderKevin extends RenderLiving {
	public static ModelBase modelKevin = new ModelKevin();
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/entity/kevin.png");

	public RenderKevin() {
		super(modelKevin, 0.5F);
        this.setRenderPassModel(this.modelKevin);
}

	protected ResourceLocation getEntityTexture(EntityKevin kevin){
        return texture;
    }

	@Override
    protected void renderEquippedItems(EntityLivingBase entity, float par2){
    }

    @Override
    protected ResourceLocation func_110775_a(Entity kevin){
        return this.getEntityTexture((EntityKevin)kevin);
    }
	
}
