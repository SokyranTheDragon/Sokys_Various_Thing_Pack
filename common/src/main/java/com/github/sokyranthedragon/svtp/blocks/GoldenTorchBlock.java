package com.github.sokyranthedragon.svtp.blocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
public class GoldenTorchBlock extends TorchBlock
{
    // Slightly higher than vanilla
    public static final VoxelShape AABB_GOLDEN_TORCH = Block.box(6.0, 0.0, 6.0, 10.0, 11.0, 10.0);

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

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext)
    {
        return AABB_GOLDEN_TORCH;
    }
}