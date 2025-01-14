package com.github.sokyranthedragon.svtp;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
public final class SVTPMod
{
    public static final String MOD_ID = "sokys_various_things_pack";

    public static void init()
    {
        SVTPBlocks.init();
        SVTPItems.init();
    }

    public static ResourceLocation resourceLocation(String id)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}
