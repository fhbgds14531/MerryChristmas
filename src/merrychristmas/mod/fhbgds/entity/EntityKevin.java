package merrychristmas.mod.fhbgds.entity;

import merrychristmas.mod.fhbgds.lib.ContentLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityKevin extends EntityMob{

	int xPos;
	int yPos;
	int zPos;
	
	public EntityKevin(World world) {
		super(world);
		this.setEntityHealth(getMaxHealth());
		this.setSize(0.9F, 3.0F);
		this.tasks.addTask(2, new EntityAIWander(this, 6.0F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
	}
	
	@Override
	public void entityInit(){
		super.entityInit();
	}
	
	@Override
	public void collideWithEntity(Entity entity){
		super.collideWithEntity(entity);
	}
	
	public float getMaxHealth(){
		return 20.0f;
	}
	
	@Override
	public void onEntityUpdate(){
		
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
	}

	public void setPos(int x, int y, int z){
		this.posX = (double) x + 0.5;
		this.posY = (double) y - 1.95;
		this.posZ = (double) z + 0.5;
		this.rotationPitch = 0;
		this.rotationYaw = 0;
		this.boundingBox.setBounds(x, y, z, x + 1, y + 3, z + 1);
	}
	
	@Override
	protected void fall(float par1) {
		super.fall(par1);
	}

	@Override
    protected String getLivingSound(){
        return "none";
    }

	@Override
    protected String getHurtSound(){
        return "none";
    }

	@Override
    protected String getDeathSound(){
        return "none";
    }

	@Override
    protected boolean canDespawn(){
        return false;
    }
	
	@Override
	protected int getDropItemId(){
        return ContentLoader.dethornedCactus.blockID;
    }
	
	@Override
	protected void dropFewItems(boolean par1, int par2){
		super.dropFewItems(par1, par2);
	}
}