package merrychristmas.mod.fhbgds.client;

import merrychristmas.mod.fhbgds.common.ProxyCommon;
import merrychristmas.mod.fhbgds.entity.EntityKevin;
import merrychristmas.mod.fhbgds.render.RenderKevin;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon {

	@Override
	public void addRenderer(){
		RenderingRegistry.registerEntityRenderingHandler(EntityKevin.class, new RenderKevin(new ModelKevin(), 0.5F));
	}
	
}
