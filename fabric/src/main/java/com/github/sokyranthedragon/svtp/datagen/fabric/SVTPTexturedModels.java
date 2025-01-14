package com.github.sokyranthedragon.svtp.datagen.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;

@Environment(EnvType.CLIENT)
class SVTPTexturedModels
{
    public static final TexturedModel.Provider CUBE_TRANSPARENT = TexturedModel.createDefault(TextureMapping::cube, SVTPModelTemplates.CUBE_ALL_TRANSPARENT);

    private SVTPTexturedModels()
    {
        // No initialization
    }
}
