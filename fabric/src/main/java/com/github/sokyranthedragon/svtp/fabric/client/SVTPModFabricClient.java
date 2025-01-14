package com.github.sokyranthedragon.svtp.fabric.client;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public final class SVTPModFabricClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderType.cutout(),
            SVTPBlocks.ARMORED_GLASS.get(),
            SVTPBlocks.ARMORED_GLASS_PANE.get(),
            SVTPBlocks.STONE_DOOR.get(),
            SVTPBlocks.GOLDEN_TORCH_0.get(),
            SVTPBlocks.GOLDEN_TORCH_1.get(),
            SVTPBlocks.WALL_GOLDEN_TORCH_0.get(),
            SVTPBlocks.WALL_GOLDEN_TORCH_1.get(),
            SVTPBlocks.DEAD_FLOWER.get(),
            SVTPBlocks.POTTED_DEAD_FLOWER.get()
        );
    }
}
