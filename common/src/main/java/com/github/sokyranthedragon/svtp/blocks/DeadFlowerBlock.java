package com.github.sokyranthedragon.svtp.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DeadFlowerBlock extends FlowerBlock
{
    public DeadFlowerBlock(Holder<MobEffect> holder, float f, Properties properties)
    {
        super(holder, f, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos)
    {
        return blockState.is(BlockTags.DEAD_BUSH_MAY_PLACE_ON);
    }
}
