package xyz.kamefrede.memeloadscreen;

import net.minecraft.client.gui.ResourceLoadProgressGui;
import net.minecraft.util.ColorHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import static xyz.kamefrede.memeloadscreen.MemeLoadScreen.MOD_ID;


@Mod(MOD_ID)
public class MemeLoadScreen {
	public static final String MOD_ID = "memeloadscreen";
	public static final String NOT_A_JOJO_REFRENCE = "textures/gui/title/jojo.png";

	public MemeLoadScreen() {
		DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
			ResourceLoadProgressGui.MOJANG_LOGO_TEXTURE = new ResourceLocation(MOD_ID, NOT_A_JOJO_REFRENCE);
			ResourceLoadProgressGui.field_238627_b_ = ColorHelper.PackedColor.packColor(255, 255, 255, 255);
			ResourceLoadProgressGui.field_238628_c_ = ColorHelper.PackedColor.packColor(255, 255, 255, 255);
			return null;
		});
	}
}
