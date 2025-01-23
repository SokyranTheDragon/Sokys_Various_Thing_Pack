package com.github.sokyranthedragon.svtp.tags;

import com.github.sokyranthedragon.svtp.SVTPMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

class SVTPTags
{
    public static <T> TagKey<T> register(ResourceKey<? extends Registry<T>> registry, String tagId)
    {
        return register(registry, tagId, SVTPMod.MOD_ID);
    }

    public static <T> TagKey<T> register(ResourceKey<? extends Registry<T>> registry, String tagId, String tagNamespace)
    {
        return TagKey.create(registry, ResourceLocation.fromNamespaceAndPath(tagId, tagNamespace));
    }
}