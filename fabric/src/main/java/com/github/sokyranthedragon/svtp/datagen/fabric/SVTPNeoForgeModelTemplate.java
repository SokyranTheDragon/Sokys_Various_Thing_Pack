package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.google.gson.JsonObject;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.Optional;

@MethodsReturnNonnullByDefault
@Environment(EnvType.CLIENT)
class SVTPNeoForgeModelTemplate extends ModelTemplate
{
    public static final String RENDER_TYPE_SOLID = "solid";
    public static final String RENDER_TYPE_CUTOUT = "cutout";
    public static final String RENDER_TYPE_CUTOUT_MIPPED = "cutout_mipped";
    public static final String RENDER_TYPE_CUTOUT_MIPPED_ALL = "cutout_mipped_all";
    public static final String RENDER_TYPE_TRANSLUCENT = "translucent";
    public static final String RENDER_TYPE_TRIPWIRE = "tripwire";

    private final Optional<String> renderType;

    public SVTPNeoForgeModelTemplate(Optional<ResourceLocation> model, Optional<String> suffix, Optional<String> renderType, TextureSlot... textureSlots)
    {
        super(model, suffix, textureSlots);

        this.renderType = renderType;
    }

    @Override
    public JsonObject createBaseTemplate(ResourceLocation resourceLocation, Map<TextureSlot, ResourceLocation> map)
    {
        var json = super.createBaseTemplate(resourceLocation, map);
        renderType.ifPresent(type -> json.addProperty("render_type", type));

        return json;
    }
}