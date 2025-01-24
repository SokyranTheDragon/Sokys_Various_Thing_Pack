package com.github.sokyranthedragon.svtp;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import dev.architectury.registry.fuel.FuelRegistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
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

    public static void lateInit()
    {
        FuelRegistry.register(100, SVTPItems.DEAD_FLOWER.get());

        SVTPBlocks.registerFlammableBlocks();
    }

    public static ResourceLocation resourceLocation(String id)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }

    public static <T> ResourceKey<T> resourceKey(ResourceKey<Registry<T>> registry, String id)
    {
        return ResourceKey.create(registry, resourceLocation(id));
    }
}
