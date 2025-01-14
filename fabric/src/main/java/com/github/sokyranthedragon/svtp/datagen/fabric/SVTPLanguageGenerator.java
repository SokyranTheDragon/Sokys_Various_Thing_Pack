package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import com.github.sokyranthedragon.svtp.tags.SVTPConventionalItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

class SVTPLanguageGenerator extends FabricLanguageProvider
{
    protected SVTPLanguageGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder)
    {
        // Blocks
        builder.add(SVTPItems.STONE_DOOR.get(), "Stone Door");
        builder.add(SVTPItems.ARMORED_GLASS.get(), "Armored Glass");
        builder.add(SVTPItems.ARMORED_GLASS_PANE.get(), "Armored Glass Pane");
        builder.add(SVTPItems.GOLDEN_TORCH_0.get(), "Golden Torch");
        builder.add(SVTPItems.PAPER_BUNDLE_0.get(), "Paper Bundle");
        builder.add(SVTPItems.REDSTONE_LANTERN.get(), "Redstone Lantern");
        builder.add(SVTPItems.DEAD_FLOWER.get(), "Dead Flower");
        builder.add(SVTPBlocks.POTTED_DEAD_FLOWER.get(), "Potted Dead Flower");

        // Tags
        builder.add(SVTPConventionalItemTags.STORAGE_BLOCKS_PAPER, "Paper Storage Blocks");
    }
}