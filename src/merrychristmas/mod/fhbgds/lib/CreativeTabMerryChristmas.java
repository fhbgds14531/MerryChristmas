package merrychristmas.mod.fhbgds.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabMerryChristmas extends CreativeTabs{

	public CreativeTabMerryChristmas(String tabName) {
		super(tabName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack(){
		return new ItemStack(ContentLoader.plate);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return Reference.MOD_NAME;
	}
}
