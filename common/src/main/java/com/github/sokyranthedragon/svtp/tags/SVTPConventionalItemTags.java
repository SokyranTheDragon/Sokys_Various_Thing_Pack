package com.github.sokyranthedragon.svtp.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SVTPConventionalItemTags
{
    public static final TagKey<Item> STORAGE_BLOCKS_PAPER = register("storage_blocks/paper");

    private static TagKey<Item> register(String tagId)
    {
        return SVTPTags.register(Registries.ITEM, "c", tagId);
    }
}
