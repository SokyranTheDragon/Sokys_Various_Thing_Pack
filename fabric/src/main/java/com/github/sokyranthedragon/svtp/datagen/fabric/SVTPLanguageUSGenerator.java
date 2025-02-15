package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import com.github.sokyranthedragon.svtp.tags.SVTPBlockTags;
import com.github.sokyranthedragon.svtp.tags.SVTPConventionalItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.StainedGlassBlock;

import java.util.concurrent.CompletableFuture;

class SVTPLanguageUSGenerator extends FabricLanguageProvider
{
    protected SVTPLanguageUSGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder)
    {
        // Blocks
        // Other
        builder.add(SVTPItems.STONE_DOOR.get(), "Stone Door");
        builder.add(SVTPItems.REDSTONE_LANTERN.get(), "Redstone Lantern");

        // Dead flower
        builder.add(SVTPItems.DEAD_FLOWER.get(), "Dead Flower");
        builder.add(SVTPBlocks.POTTED_DEAD_FLOWER.get(), "Potted Dead Flower");

        // Golden torch
        builder.add(SVTPItems.GOLDEN_TORCH_0.get(), "Golden Torch");
        builder.add(SVTPItems.GOLDEN_SOUL_TORCH_0.get(), "Golden Soul Torch");
        builder.add(SVTPItems.GOLDEN_TORCH_1.get(), "Annealed Golden Torch");
        builder.add(SVTPItems.GOLDEN_SOUL_TORCH_1.get(), "Annealed Golden Soul Torch");

        // Paper bundles
        builder.add(SVTPItems.PAPER_BUNDLE_0.get(), "Paper Bundle");
        builder.add(SVTPItems.PAPER_BUNDLE_1.get(), "Paper Bundle on a Pallet");
        builder.add(SVTPItems.PAPER_BUNDLE_2.get(), "Paper Bundle on a Pallet with Warning Sign");
        builder.add(SVTPItems.PAPER_BUNDLE_3.get(), "Yellowed Paper Bundle");
        builder.add(SVTPItems.PAPER_BUNDLE_4.get(), "Yellowed Paper Bundle on a Pallet");
        builder.add(SVTPItems.PAPER_BUNDLE_5.get(), "Yellowed Paper Bundle on a Pallet with Warning Sign");

        // Armored glass blocks
        builder.add(SVTPItems.ARMORED_GLASS.get(), "Armored Glass");
        builder.add(SVTPItems.ARMORED_GLASS_PANE.get(), "Armored Glass Pane");
        builder.add(SVTPItems.ARMORED_TINTED_GLASS.get(), "Armored Tinted Glass");

        var stainedGlassBlocks = SVTPBlocks.getStainedGlassBlocks();
        var stainedGlassPaneBlocks = SVTPBlocks.getStainedGlassPaneBlocks();
        for (var i = 0; i < stainedGlassBlocks.length; i++)
        {
            var colorName = I18n.get("color.minecraft." + ((StainedGlassBlock)stainedGlassBlocks[i]).getColor().getName());
            builder.add(stainedGlassBlocks[i], "Armored " + colorName + " Stained Glass");
            builder.add(stainedGlassPaneBlocks[i], "Armored " + colorName + " Stained Glass Pane");
        }

        // Tags
        builder.add(SVTPConventionalItemTags.STORAGE_BLOCKS_PAPER, "Paper Storage Blocks");
        builder.add(SVTPBlockTags.PAPER_BUNDLES, "Paper Bundles");
    }
}