package merrychristmas.mod.fhbgds.lib;

import merrychristmas.mod.fhbgds.item.ItemCactusArmor;
import merrychristmas.mod.fhbgds.item.ItemSpikeGem;
import merrychristmas.mod.fhbgds.item.ItemSpikeShard;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ContentLoader {

	public CreativeTabMerryChristmas tab = new CreativeTabMerryChristmas(Reference.MOD_NAME);
	
	public static ItemCactusArmor helmet;
	public static ItemCactusArmor plate;
	public static ItemCactusArmor leggings;
	public static ItemCactusArmor boots;
	public static Item spikeGem;
	public static Item spikeShard;
	public static final EnumArmorMaterial CACTUS = EnumHelper.addArmorMaterial("CACTUS", 50, new int[] {3, 8, 6, 3}, 15);
	
	public void initObjects(){
		helmet = (ItemCactusArmor) new ItemCactusArmor(512, 0, CACTUS).setUnlocalizedName("cactusHelmet")
				.setCreativeTab(tab);
		
		plate = (ItemCactusArmor) new ItemCactusArmor(513, 1, CACTUS).setUnlocalizedName("cactusPlate")
				.setCreativeTab(tab);
		
		leggings = (ItemCactusArmor) new ItemCactusArmor(514, 2, CACTUS).setUnlocalizedName("cactusLeggings")
				.setCreativeTab(tab);
		
		boots = (ItemCactusArmor) new ItemCactusArmor(515, 3, CACTUS).setUnlocalizedName("cactusBoots")
				.setCreativeTab(tab);
		
		spikeGem = new ItemSpikeGem(516).setUnlocalizedName("spikeGem").setCreativeTab(tab);
		
		spikeShard = new ItemSpikeShard(517).setUnlocalizedName("spikeShard").setCreativeTab(tab);
	}
	
	public void addNames(){
		LanguageRegistry.instance().addStringLocalization("item.cactusHelmet.name", "en_US", "Girrenian Cactus Helmet");
		LanguageRegistry.instance().addStringLocalization("item.cactusPlate.name", "en_US", "Girrenian Cactus Chestplate");
		LanguageRegistry.instance().addStringLocalization("item.cactusLeggings.name", "en_US", "Girrenian Cactus Leggings");
		LanguageRegistry.instance().addStringLocalization("item.cactusBoots.name", "en_US", "Girrenian Cactus Boots");
		LanguageRegistry.instance().addStringLocalization("item.spikeShard.name", "en_US", "Girrenian Spike Shard");
		LanguageRegistry.instance().addStringLocalization("item.spikeGem.name", "en_US", "Girrenian Spike Gem");
	}
	
	public void recipies(String type) throws Exception{
		boolean finishedRegisterSmelting = false;
		boolean finishedRegisterCrafting = false;
		
		if (type.toLowerCase().contains("smelt") && !finishedRegisterSmelting){
			GameRegistry.addSmelting(spikeGem.itemID, new ItemStack(spikeShard), 1.5F);
			finishedRegisterSmelting = true;
		}else if(!finishedRegisterCrafting){
			GameRegistry.addRecipe(new ItemStack(spikeGem), new Object[] {"###", "#D#", "###",
				'#', Block.cactus, 'D', Item.diamond});
			GameRegistry.addRecipe(new ItemStack(helmet), new Object[] {"###", "# #", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(plate), new Object[] {"# #", "###", "###", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(leggings), new Object[] {"###", "# #", "# #", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(boots), new Object[] {"# #", "# #", '#', spikeShard});
			finishedRegisterCrafting = true;
		}else if(finishedRegisterCrafting){
			throw new Exception("Already Finished!");
		}else if(finishedRegisterSmelting){
			throw new Exception("Already Finished!");
		}
	}
}	
