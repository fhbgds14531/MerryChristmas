package merrychristmas.mod.fhbgds.block;

import java.util.Random;

import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockDethornedCactus extends Block implements IPlantable{

	public Icon topIcon;
	
	public BlockDethornedCactus(int par1) {
		super(par1, Material.cactus);
		this.setTickRandomly(true);
	}
	
	
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		if(world.getBlockId(x, y - 1, z) == this.blockID && world.getBlockId(x, y - 2, z) == this.blockID){
			world.setBlockToAir(x, y, z);
			world.setBlockToAir(x, y - 1, z);
			world.setBlockToAir(x, y - 2, z);
			EntityKevin kevin = new EntityKevin(world);
			kevin.setPos(x, y, z);
			world.spawnEntityInWorld(kevin);
			world.notifyBlockChange(x, y, z, 0);
            world.notifyBlockChange(x, y - 1, z, 0);
            world.notifyBlockChange(x, y - 2, z, 0);
		}
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
	
	public void updateTick(World world, int x, int y, int z, Random random){
        if (world.isAirBlock(x, y + 1, z)){
            int l;

            for (l = 1; world.getBlockId(x, y - l, z) == this.blockID; ++l){;}

            if (l < 3){
                int data = world.getBlockMetadata(x, y, z);

                if (data == 1){
                    world.setBlock(x, y + 1, z, this.blockID);
                    world.setBlockMetadataWithNotify(x, y, z, 0, 4);
                    this.onNeighborBlockChange(world, x, y + 1, z, this.blockID);
                }else{
                    world.setBlockMetadataWithNotify(x, y, z, data + 1, 4);
                }
            }
        }
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
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        float f = 0.0625F;
        return AxisAlignedBB.getAABBPool().getAABB((double)((float)x + f), (double)y, (double)((float)z + f), 
        		(double)((float)(x + 1) - f), (double)((float)(y + 1) - f), (double)((float)(z + 1) - f));
    }
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
        float f = 0.0625F;
        return AxisAlignedBB.getAABBPool().getAABB((double)((float)x + f), (double)y, (double)((float)z + f), 
        		(double)((float)(x + 1) - f), (double)(y + 1), (double)((float)(z + 1) - f));
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5){
        if (!this.canBlockStay(world, x, y, z)){
            world.destroyBlock(x, y, z, true);
        }
    }
	
	@Override
    public EnumPlantType getPlantType(World world, int x, int y, int z){
        return EnumPlantType.Crop;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z){
        return this.blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z){
        return -1;
    }
	
	@Override
	public int getRenderType(){
		return 13;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
}
