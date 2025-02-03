package com.github.sokyranthedragon.svtp.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SVTPItemTags
{
    public static TagKey<Item> PAPER_BUNDLES = register("paper_bundles");

    private static TagKey<Item> register(String tagId)
    {
        return SVTPTags.register(Registries.ITEM, tagId);
    }
}
