package merrychristmas.mod.fhbgds;
import merrychristmas.mod.fhbgds.common.ProxyCommon;
import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.lib.ContentLoader;
import merrychristmas.mod.fhbgds.lib.Reference;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(serverSideRequired = false, clientSideRequired = true)

public class MerryChristmas {

	@SidedProxy(modId = Reference.MOD_ID, serverSide = "merrychristmas.mod.fhbgds.common.ProxyCommon",
			clientSide = "merrychristmas.mod.fhbgds.client.ProxyClient")
		public static ProxyCommon proxy;
	@Instance(Reference.MOD_NAME)
		public static MerryChristmas instance;

	private ContentLoader loader = new ContentLoader();
	
	public MerryChristmas(){
		if(Loader.isModLoaded("MiscTweaks")){
			System.out.println("[MerryChristmas] Oh, hey MiscTweaks!");
			System.out.println("[MiscTweaks] *sigh* Hello MerryChristmas.");
		}else{
			System.out.println("[MerryChristmas] Is this thing on?");
		}
	}
	
@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		loader.initObjects();
		proxy.addRenderer();
	}

@EventHandler
	public void Init(FMLInitializationEvent event){
		loader.registerBlocks();
		loader.addNames();
		loader.recipies("Crafting");
		loader.recipies("Smelting");
	}

@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		EntityRegistry.registerModEntity(EntityKevin.class, "Kevin", 1, this, 32, 5, true);
		//EntityRegistry.registerGlobalEntityID(EntityKevin.class, "Kevin", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
	}
}
