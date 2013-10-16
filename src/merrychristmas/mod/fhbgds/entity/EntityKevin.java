package merrychristmas.mod.fhbgds.entity;

import java.util.Random;

import merrychristmas.mod.fhbgds.lib.ContentLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityKevin extends EntityCreature{

	Random random = new Random();
	private PathNavigate myNavigator = this.getNavigator();
	int xPos;
	int yPos;
	int zPos;
	private Attribute jumpHeight;
	
	public EntityKevin(World world) {
		super(world);
		this.myNavigator.setAvoidsWater(true);
		this.myNavigator.setAvoidSun(true);
		this.setHealth(20);
		this.setSize(0.9F, 3.0F);
		this.tasks.addTask(2, new EntityAIWander(this, 0.2F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityCreeper.class, 16.0F, 1.0, 2.0F));
        this.tasks.addTask(5, new EntityAIFleeSun(this, 1.0F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityCreeper.class, 6.0F));
        this.setCustomNameTag("Kevin");
        this.setAlwaysRenderNameTag(true);
	}
	
	@Override
	public void entityInit(){
		super.entityInit();
	}
	
	@Override
	public void collideWithEntity(Entity entity){
		super.collideWithEntity(entity);
	}
	
	@Override
	public void onEntityUpdate(){
		super.onEntityUpdate();
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
		int drop = random.nextInt(4);
		this.dropItem(this.getDropItemId(), drop);
	}
	
	@Override
	public String getEntityName(){
		return "Kevin";
	}
}