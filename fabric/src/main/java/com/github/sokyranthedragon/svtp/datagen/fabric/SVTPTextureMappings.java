package com.github.sokyranthedragon.svtp.datagen.fabric;

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

    private SVTPTextureMappings()
    {
        // No initialization
    }
}