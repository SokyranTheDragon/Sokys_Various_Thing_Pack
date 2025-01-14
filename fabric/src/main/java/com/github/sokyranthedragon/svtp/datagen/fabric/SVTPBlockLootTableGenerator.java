package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

class SVTPBlockLootTableGenerator extends FabricBlockLootTableProvider
{
    protected SVTPBlockLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        createSingleItemTableWithSilkTouch(SVTPBlocks.ARMORED_GLASS.get(), SVTPItems.ARMORED_GLASS.get());
        createSingleItemTableWithSilkTouch(SVTPBlocks.ARMORED_GLASS_PANE.get(), SVTPItems.ARMORED_GLASS_PANE.get());
    }
}
