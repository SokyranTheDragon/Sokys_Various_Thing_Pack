package com.github.sokyranthedragon.svtp.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SVTPConventionalBlockTags
{
    public static final TagKey<Block> STORAGE_BLOCKS_PAPER = register("storage_blocks/paper");

    private static TagKey<Block> register(String tagId)
    {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", tagId));
    }
}