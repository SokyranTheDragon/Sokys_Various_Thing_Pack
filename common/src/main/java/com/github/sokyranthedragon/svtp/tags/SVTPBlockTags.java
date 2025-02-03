package com.github.sokyranthedragon.svtp.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SVTPBlockTags
{
    public static TagKey<Block> PAPER_BUNDLES = register("paper_bundles");

    private static TagKey<Block> register(String tagId)
    {
        return SVTPTags.register(Registries.BLOCK, tagId);
    }
}