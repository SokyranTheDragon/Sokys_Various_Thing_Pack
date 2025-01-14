package com.github.sokyranthedragon.svtp.blocks.fabric;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SVTPBlocksImpl
{
    public static FlowerPotBlock getFlowerPotBlock(RegistrySupplier<Block> block, BlockBehaviour.Properties properties)
    {
        return new FlowerPotBlock(block.get(), properties);
    }
}