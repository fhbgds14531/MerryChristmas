package merrychristmas.mod.fhbgds.lib;

import merrychristmas.mod.fhbgds.block.BlockDethornedCactus;
import merrychristmas.mod.fhbgds.item.ItemCactusArmor;
import merrychristmas.mod.fhbgds.item.ItemCactusPick;
import merrychristmas.mod.fhbgds.item.ItemGauntlet;
import merrychristmas.mod.fhbgds.item.ItemSpikeGem;
import merrychristmas.mod.fhbgds.item.ItemSpikeShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
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
	public static Block dethornedCactus;
	public static final EnumToolMaterial CACTUS = EnumHelper.addToolMaterial("CACTUS", 3, 1800, 10.0F, 6.0F, 15);
	public static final EnumArmorMaterial CACTUS_SHARD = EnumHelper.addArmorMaterial("CACTUS", 60, new int[] {5, 10, 8, 5}, 20);
	
	public void initObjects(){
		helmet = (ItemCactusArmor) new ItemCactusArmor(512, 0, CACTUS_SHARD).setUnlocalizedName("cactusHelmet")
				.setCreativeTab(tab);
		
		plate = (ItemCactusArmor) new ItemCactusArmor(513, 1, CACTUS_SHARD).setUnlocalizedName("cactusPlate")
				.setCreativeTab(tab);
		
		leggings = (ItemCactusArmor) new ItemCactusArmor(514, 2, CACTUS_SHARD).setUnlocalizedName("cactusLeggings")
				.setCreativeTab(tab);
		
		boots = (ItemCactusArmor) new ItemCactusArmor(515, 3, CACTUS_SHARD).setUnlocalizedName("cactusBoots")
				.setCreativeTab(tab);
		
		spikeGem = new ItemSpikeGem(516).setUnlocalizedName("spikeGem").setCreativeTab(tab);
		
		spikeShard = new ItemSpikeShard(517).setUnlocalizedName("spikeShard").setCreativeTab(tab);
		
		dethornedCactus = new BlockDethornedCactus(580).setUnlocalizedName("dethornedCactus").setCreativeTab(tab);
		
	}
	
	public void addNames(){
		LanguageRegistry.instance().addStringLocalization("item.cactusHelmet.name", "en_US", "Girrenian Cactus Helmet");
		LanguageRegistry.instance().addStringLocalization("item.cactusPlate.name", "en_US", "Girrenian Cactus Chestplate");
		LanguageRegistry.instance().addStringLocalization("item.cactusLeggings.name", "en_US", "Girrenian Cactus Leggings");
		LanguageRegistry.instance().addStringLocalization("item.cactusBoots.name", "en_US", "Girrenian Cactus Boots");
		LanguageRegistry.instance().addStringLocalization("item.spikeShard.name", "en_US", "Girrenian Cactus Ingot");
		LanguageRegistry.instance().addStringLocalization("item.spikeGem.name", "en_US", "Girrenian Cactus Gem");
		LanguageRegistry.instance().addStringLocalization("item.cactusPick.name", "en_US", "Girrenian Cactus Pickaxe");
		LanguageRegistry.instance().addStringLocalization("tile.dethornedCactus.name", "en_US", "Dethorned Cactus");
		LanguageRegistry.instance().addStringLocalization("item.gauntlet.name", "en_US", "Girrenian Cactus Gauntlet");
	}
	
	public void recipies(String type){
		if (type.toLowerCase().contains("smelt")){
			GameRegistry.addSmelting(spikeGem.itemID, new ItemStack(spikeShard), 1.5F);
		}else if(type.toLowerCase().contains("craft")){
			GameRegistry.addRecipe(new ItemStack(spikeGem), new Object[] {"#D#", "D#D", "#D#",
				'#', new ItemStack(Item.dyePowder, 1, 2), 'D', Item.diamond});
			GameRegistry.addRecipe(new ItemStack(helmet), new Object[] {"###", "# #", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(plate), new Object[] {"# #", "###", "###", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(leggings), new Object[] {"###", "# #", "# #", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(boots), new Object[] {"# #", "# #", '#', spikeShard});
			GameRegistry.addRecipe(new ItemStack(dethornedCactus), new Object[] {"#", '#', Block.cactus});
		}
	}

	public void registerBlocks() {
		GameRegistry.registerBlock(dethornedCactus, Reference.MOD_ID + dethornedCactus.getUnlocalizedName());
	}
}	
