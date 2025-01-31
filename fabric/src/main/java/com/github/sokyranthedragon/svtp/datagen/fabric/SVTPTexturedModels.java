package com.github.sokyranthedragon.svtp.datagen.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;

@Environment(EnvType.CLIENT)
class SVTPTexturedModels
{
    public static final TexturedModel.Provider CUBE_TRANSPARENT = TexturedModel.createDefault(TextureMapping::cube, SVTPModelTemplates.CUBE_ALL_TRANSPARENT);
    public static final TexturedModel.Provider CUBE_TRANSLUCENT = TexturedModel.createDefault(TextureMapping::cube, SVTPModelTemplates.CUBE_ALL_TRANSLUCENT);

    private SVTPTexturedModels()
    {
        // No initialization
    }
}
