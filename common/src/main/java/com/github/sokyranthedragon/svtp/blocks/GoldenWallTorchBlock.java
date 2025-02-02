package com.github.sokyranthedragon.svtp.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

@MethodsReturnNonnullByDefault
public class GoldenWallTorchBlock extends WallTorchBlock
{
    // Slightly higher than vanilla
    public static final Map<Direction, VoxelShape> AABBS_GOLDEN_TORCH = Maps.newEnumMap(ImmutableMap.of(
        Direction.NORTH, Block.box(4.5, 3.0, 9.0, 11.5, 14.0, 16.0),
        Direction.SOUTH, Block.box(4.5, 3.0, 0.0, 11.5, 14.0, 7.0),
        Direction.WEST, Block.box(9.0, 3.0, 4.5, 16.0, 14.0, 11.5),
        Direction.EAST, Block.box(0.0, 3.0, 4.5, 7.0, 14.0, 11.5)
    ));

    public GoldenWallTorchBlock(SimpleParticleType simpleParticleType, Properties properties)
    {
        super(simpleParticleType, properties);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource)
    {
        var direction = blockState.getValue(FACING).getOpposite();

        var x = ((double)blockPos.getX() + 0.5) + (0.27 * direction.getStepX());
        // 1.2 blocks above the highest point of the model, just like vanilla
        var y = (double)blockPos.getY() + (12.2 / 16.0) + 0.22;
        var z = ((double)blockPos.getZ() + 0.5) + (0.27 * direction.getStepZ());

        level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
        level.addParticle(flameParticle, x, y, z, 0.0, 0.0, 0.0);
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext)
    {
        return AABBS_GOLDEN_TORCH.get(blockState.getValue(FACING));
    }
}