package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.tags.SVTPBlockTags;
import com.github.sokyranthedragon.svtp.tags.SVTPConventionalBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

class SVTPBlockTagGenerator extends FabricTagProvider.BlockTagProvider
{
    public SVTPBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        // Vanilla tags
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(SVTPBlocks.STONE_DOOR.get())
            .add(SVTPBlocks.ARMORED_GLASS.get())
            .add(SVTPBlocks.ARMORED_GLASS_PANE.get())
            .add(SVTPBlocks.ARMORED_TINTED_GLASS.get())
            .add(SVTPBlocks.getStainedGlassBlocks())
            .add(SVTPBlocks.getStainedGlassPaneBlocks());

        getOrCreateTagBuilder(BlockTags.DOORS)
            .add(SVTPBlocks.STONE_DOOR.get());

        getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
            .add(SVTPBlocks.ARMORED_GLASS.get())
            .add(SVTPBlocks.ARMORED_TINTED_GLASS.get())
            .add(SVTPBlocks.getStainedGlassBlocks());

        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
            .add(SVTPBlocks.DEAD_FLOWER.get());

        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES)
            .add(SVTPBlocks.DEAD_FLOWER.get());

        getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_TRANSMITTER)
            .add(SVTPBlocks.DEAD_FLOWER.get());

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
            .add(SVTPBlocks.POTTED_DEAD_FLOWER.get());

        // Conventional tags
        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_BLOCKS_COLORLESS)
            .add(SVTPBlocks.ARMORED_GLASS.get());

        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_PANES_COLORLESS)
            .add(SVTPBlocks.ARMORED_GLASS_PANE.get());

        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_BLOCKS_TINTED)
            .add(SVTPBlocks.ARMORED_TINTED_GLASS.get());

        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_BLOCKS)
            .add(SVTPBlocks.getStainedGlassBlocks());

        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_PANES)
            .add(SVTPBlocks.getStainedGlassPaneBlocks());

        // SVTP conventional tags
        getOrCreateTagBuilder(SVTPConventionalBlockTags.STORAGE_BLOCKS_PAPER)
            .add(SVTPBlocks.PAPER_BUNDLE_0.get())
            .add(SVTPBlocks.PAPER_BUNDLE_1.get())
            .add(SVTPBlocks.PAPER_BUNDLE_2.get())
            .add(SVTPBlocks.PAPER_BUNDLE_3.get());

        // SVTP Tags
        getOrCreateTagBuilder(SVTPBlockTags.SHEARABLE_PAPER_BLOCKS)
            .add(SVTPBlocks.PAPER_BUNDLE_0.get())
            .add(SVTPBlocks.PAPER_BUNDLE_1.get())
            .add(SVTPBlocks.PAPER_BUNDLE_2.get())
            .add(SVTPBlocks.PAPER_BUNDLE_3.get());
    }
}