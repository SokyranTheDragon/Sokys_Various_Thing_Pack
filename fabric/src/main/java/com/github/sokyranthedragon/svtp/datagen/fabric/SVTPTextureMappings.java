package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Contract;

@Environment(EnvType.CLIENT)
class SVTPTextureMappings
{
    @Contract(pure = true)
    public static TextureMapping orientableCubeSameNorthWestAndSouthEast(Block top, Block bottom, Block northWest, Block southEast)
    {
        return new TextureMapping()
            .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(top, "_top"))
            .put(TextureSlot.UP, TextureMapping.getBlockTexture(top, "_top"))
            .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(bottom, "_bottom"))
            .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(northWest, "_north_west"))
            .put(TextureSlot.WEST, TextureMapping.getBlockTexture(northWest, "_north_west"))
            .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(southEast, "_south_east"))
            .put(TextureSlot.EAST, TextureMapping.getBlockTexture(southEast, "_south_east"));
    }

    public static TextureMapping redstoneLantern(Block block, String suffix)
    {
        return new TextureMapping()
            .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_default"))
            .put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_default"))
            .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_default"))
            .put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_default"))
            .put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, suffix + "_side"))
            .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, suffix + "_front"))
            .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, suffix + "_back"));
    }

    public static TextureMapping armoredPane(Block block)
    {
        // Normal pane mapping, but since all will use the same edge texture we use the base pane rather than current one.
        return new TextureMapping()
            .put(TextureSlot.PANE, TextureMapping.getBlockTexture(block))
            .put(TextureSlot.EDGE, TextureMapping.getBlockTexture(SVTPBlocks.ARMORED_GLASS_PANE.get(), "_top"));
    }

    private SVTPTextureMappings()
    {
        // No initialization
    }
}