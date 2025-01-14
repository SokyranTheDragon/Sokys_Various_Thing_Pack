package com.github.sokyranthedragon.svtp.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

@MethodsReturnNonnullByDefault
public class RedstoneLanternBlock extends HorizontalDirectionalBlock
{
    public static final MapCodec<RedstoneLanternBlock> CODEC = simpleCodec(RedstoneLanternBlock::new);
    public static final BooleanProperty REDSTONE_STATE = BooleanProperty.create("redstone_state");
    public static final BooleanProperty MANUAL_STATE = BooleanProperty.create("manual_state");

    public RedstoneLanternBlock(Properties properties)
    {
        super(properties);
        registerDefaultState(defaultBlockState()
            .setValue(FACING, Direction.NORTH)
            .setValue(REDSTONE_STATE, false)
            .setValue(MANUAL_STATE, false));

    }

    @Override
    protected void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource)
    {
        if (blockState.getValue(REDSTONE_STATE) && !serverLevel.hasNeighborSignal(blockPos))
            serverLevel.setBlock(blockPos, blockState.cycle(REDSTONE_STATE), Block.UPDATE_CLIENTS);
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, @Nullable Orientation orientation, boolean bl)
    {
        if (!level.isClientSide)
        {
            var redstoneState = blockState.getValue(REDSTONE_STATE);
            if (redstoneState != level.hasNeighborSignal(blockPos))
            {
                if (redstoneState)
                    level.scheduleTick(blockPos, this, 4);
                else
                    level.setBlock(blockPos, blockState.cycle(REDSTONE_STATE), Block.UPDATE_CLIENTS);
            }
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult)
    {
        if (!level.isClientSide)
        {
            if (player.isShiftKeyDown())
                level.setBlock(pos, state.cycle(FACING), Block.UPDATE_CLIENTS);
            else
                toggleManualState(state, level, pos);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onExplosionHit(BlockState state, ServerLevel level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer)
    {
        if (explosion.canTriggerBlocks())
            toggleManualState(state, level, pos);

        super.onExplosionHit(state, level, pos, explosion, biConsumer);
    }

    public void toggleManualState(BlockState state, Level level, BlockPos pos)
    {
        state = state.cycle(MANUAL_STATE);
        level.setBlock(pos, state, Block.UPDATE_CLIENTS);
        var manualPower = state.getValue(MANUAL_STATE);
        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3f, manualPower ? 0.6f : 0.5f);
        level.gameEvent(null, (manualPower ^ state.getValue(REDSTONE_STATE)) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, REDSTONE_STATE, MANUAL_STATE);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext)
    {
        return defaultBlockState()
            .setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
            .setValue(REDSTONE_STATE, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos()))
            .setValue(MANUAL_STATE, false);
    }
}