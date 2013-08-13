package merrychristmas.mod.fhbgds.render;

import merrychristmas.mod.fhbgds.client.ModelKevin;
import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderKevin extends RenderLiving {
	private static final ResourceLocation field_110833_a = new ResourceLocation(Reference.MOD_ID, "textures/entity/kevin.png");

	public RenderKevin(ModelBase model, float par2){
		super(model, par2);
	}
	
	protected ResourceLocation func_110832_a(EntityLiving entity){
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity entity){
        return this.func_110832_a((EntityLiving)entity);
    }
}
