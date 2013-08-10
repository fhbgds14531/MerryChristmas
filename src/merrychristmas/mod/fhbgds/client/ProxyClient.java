package merrychristmas.mod.fhbgds.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import merrychristmas.mod.fhbgds.common.ProxyCommon;
import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.render.RenderKevin;

public class ProxyClient extends ProxyCommon {

	@Override
	public void addRenderer(){
		RenderingRegistry.registerEntityRenderingHandler(EntityKevin.class, new RenderKevin());
	}
	
}
