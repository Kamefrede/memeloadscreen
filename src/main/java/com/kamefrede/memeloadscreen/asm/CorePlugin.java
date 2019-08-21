package com.kamefrede.memeloadscreen.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.Name("JoJo Meme Loadscreen Plugin")
@IFMLLoadingPlugin.TransformerExclusions("com.kamefrede.memeloadscreen.asm")
@IFMLLoadingPlugin.SortingIndex(1001)
public class CorePlugin implements IFMLLoadingPlugin {


    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                "com.kamefrede.memeloadscreen.asm.ClassTransformer"
        };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
