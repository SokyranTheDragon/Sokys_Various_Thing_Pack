package com.github.sokyranthedragon.svtp.blocks.neoforge;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SVTPBlocksImpl
{
    public static FlowerPotBlock getFlowerPotBlock(RegistrySupplier<Block> block, BlockBehaviour.Properties properties)
    {
        return new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, block, properties);
    }
}