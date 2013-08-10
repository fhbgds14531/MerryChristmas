package merrychristmas.mod.fhbgds.item;

import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.lib.ContentLoader;
import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpikeGem extends Item {

	public ItemSpikeGem(int par1) {
		super(par1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
