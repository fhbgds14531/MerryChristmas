package merrychristmas.mod.fhbgds.render;

import merrychristmas.mod.fhbgds.client.ModelKevin;
import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderKevin extends RenderLiving {
	public static ModelBase modelKevin = new ModelKevin();
	private static final ResourceLocation field_110833_a = new ResourceLocation(Reference.MOD_ID + ":textures.entity.kevin.png");

	public RenderKevin(ModelBase model, float par2){
		super(model, par2);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entity, float par2){
		super.preRenderCallback(entity, par2);
	}
	
	protected ResourceLocation func_110832_a(EntityLiving kevin){
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity entity){
        return this.func_110832_a((EntityLiving)entity);
    }


	public void doRenderKevin(EntityKevin entity, double par2, double par4, double par6, float par8, float par9){
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	@Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
        this.doRenderKevin((EntityKevin)par1EntityLiving, par2, par4, par6, par8, par9);
    }
}
