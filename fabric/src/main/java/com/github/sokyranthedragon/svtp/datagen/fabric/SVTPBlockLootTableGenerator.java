package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
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
        var handledBlocks = new HashSet<Block>();

        // Glass (minus tinted)
        dropWhenSilkTouch(SVTPBlocks.ARMORED_GLASS, handledBlocks);
        dropWhenSilkTouch(SVTPBlocks.ARMORED_GLASS_PANE, handledBlocks);
        for (var glassBlock : SVTPBlocks.getStainedGlassBlockProviders())
            dropWhenSilkTouch(glassBlock, handledBlocks);
        for (var glassPane : SVTPBlocks.getStainedGlassPaneBlockProviders())
            dropWhenSilkTouch(glassPane, handledBlocks);

        // Potted plant
        dropPottedContents(SVTPBlocks.POTTED_DEAD_FLOWER, handledBlocks);

        // Doors
        createDoorTable(SVTPBlocks.STONE_DOOR, handledBlocks);

        // Exclude wall torches, as they share normal torch loot table
        handledBlocks.add(SVTPBlocks.WALL_GOLDEN_TORCH_0.get());
        handledBlocks.add(SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_0.get());
        handledBlocks.add(SVTPBlocks.WALL_GOLDEN_TORCH_1.get());
        handledBlocks.add(SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_1.get());

        // Other
        // And yeah, would have been much easier to just do the remaining ones manually.
        BuiltInRegistries.BLOCK.entrySet().forEach(entry ->
        {
            if (entry.getKey().location().getNamespace().equals(SVTPMod.MOD_ID))
            {
                var block = entry.getValue();
                if (!handledBlocks.contains(block))
                    dropSelf(block);
            }
        });
    }

    private void dropWhenSilkTouch(RegistrySupplier<Block> blockSupplier, HashSet<Block> handledBlocks)
    {
        var block = blockSupplier.get();
        dropWhenSilkTouch(block);
        handledBlocks.add(block);
    }

    private void dropPottedContents(RegistrySupplier<Block> blockSupplier, HashSet<Block> handledBlocks)
    {
        var block = blockSupplier.get();
        dropPottedContents(block);
        handledBlocks.add(block);
    }

    private void createDoorTable(RegistrySupplier<Block> blockSupplier, HashSet<Block> handledBlocks)
    {
        var block = blockSupplier.get();
        add(block, createDoorTable(block));
        handledBlocks.add(block);
    }
}