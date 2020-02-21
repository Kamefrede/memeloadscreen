package com.kamefrede.memeloadscreen.asm;

import net.minecraft.client.gui.ResourceLoadProgressGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.kamefrede.memeloadscreen.asm.MemeLoadscreen.MOD_ID;

@Mod(MOD_ID)
public class MemeLoadscreen {
	/*
		I have used ASM, but y tho
	 */

	public static final String MOD_ID = "memeloadscreen";
	public static final Logger logger = LogManager.getLogger(MOD_ID);

	public static MemeLoadscreen instance;

	public MemeLoadscreen() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> {
			ResourceLoadProgressGui.MOJANG_LOGO_TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/title/mojang.png");
			return null;
		});
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		logger.log(Level.ALL, "omae wa mou shindeiru");
	}

}
