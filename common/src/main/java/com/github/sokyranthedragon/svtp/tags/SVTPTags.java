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
        return register(registry, SVTPMod.MOD_ID, tagId);
    }

    public static <T> TagKey<T> register(ResourceKey<? extends Registry<T>> registry, String tagNamespace, String tagId)
    {
        return TagKey.create(registry, ResourceLocation.fromNamespaceAndPath(tagNamespace, tagId));
    }
}