package merrychristmas.mod.fhbgds.item;

import merrychristmas.mod.fhbgds.lib.ContentLoader;
import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCactusArmor extends ItemArmor {
	
	public ItemCactusArmor(int id, int armorType, EnumArmorMaterial material) {
		super(id, material, 3, armorType);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(itemID == ContentLoader.helmet.itemID || itemID == ContentLoader.plate.itemID || itemID == ContentLoader.boots.itemID){
			return "merrychristmas:textures/models/armor/CACTUS_layer_1.png";
			}
		if(itemID == ContentLoader.leggings.itemID)
			{
			return "merrychristmas:textures/models/armor/CACTUS_layer_2.png";
			}
		else return null;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		ContentLoader.helmet.itemIcon = r.registerIcon(Reference.MOD_ID + ":cactusHelmet");
		ContentLoader.plate.itemIcon = r.registerIcon(Reference.MOD_ID + ":cactuschestPlate");
		ContentLoader.leggings.itemIcon = r.registerIcon(Reference.MOD_ID + ":cactusLeggings");
		ContentLoader.boots.itemIcon = r.registerIcon(Reference.MOD_ID + ":cactusBoots");
	}
}