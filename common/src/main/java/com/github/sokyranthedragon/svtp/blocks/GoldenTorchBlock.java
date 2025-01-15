package com.github.sokyranthedragon.svtp.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenTorchBlock extends TorchBlock
{
    public GoldenTorchBlock(SimpleParticleType simpleParticleType, Properties properties)
    {
        super(simpleParticleType, properties);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource)
    {
        var x = (double)blockPos.getX() + 0.5;
        // 1.2 blocks above the highest point of the model, just like vanilla
        var y = (double)blockPos.getY() + (12.2 / 16.0);
        var z = (double)blockPos.getZ() + 0.5;

        level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
        level.addParticle(this.flameParticle, x, y, z, 0.0, 0.0, 0.0);
    }
}
