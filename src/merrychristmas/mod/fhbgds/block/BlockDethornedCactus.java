package merrychristmas.mod.fhbgds.block;

import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDethornedCactus extends BlockCactus {

	public Icon topIcon;
	
	public BlockDethornedCactus(int par1) {
		super(par1);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z){
        if (world.getBlockMaterial(x - 1, y, z).isSolid()){
            return false;
        }else if (world.getBlockMaterial(x + 1, y, z).isSolid()){
            return false;
        }else if (world.getBlockMaterial(x, y, z - 1).isSolid()){
            return false;
        }else if (world.getBlockMaterial(x, y, z + 1).isSolid()){
            return false;
        }else{
            int l = world.getBlockId(x, y - 1, z);

            if(l == Block.sand.blockID || l == this.blockID){
            	return true;
            }else{
            	return false;
            }
        }
    }

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
//        EntityPlayer player = world.getClosestPlayer(x, y, z, 1);
//        if (player != null && entity instanceof EntityPlayer){
//        	player.addPotionEffect(new PotionEffect(10, 10, 0, false));
//        	player.addPotionEffect(new PotionEffect(11, 10, 0, false));
//        }
    }
	
	@Override
	public Icon getIcon(int side, int metadata){
		if(side == 0){
			return Block.cactus.getBlockTextureFromSide(0);
		}else if(side == 1){
			return this.topIcon;
		}else{
			return this.blockIcon;
		}
	}
	
	@Override
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_SIDE");
		this.topIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_TOP");
	}
	
}
