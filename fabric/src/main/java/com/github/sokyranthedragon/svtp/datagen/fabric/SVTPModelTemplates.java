package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;

import java.util.Optional;

class SVTPModelTemplates
{
    // Cube
    public static final ModelTemplate CUBE_ALL_TRANSPARENT = create("cube_all",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.ALL);

    // Pane
    public static final ModelTemplate STAINED_GLASS_PANE_NOSIDE_TRANSPARENT = create("template_glass_pane_noside", "_noside",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE);
    public static final ModelTemplate STAINED_GLASS_PANE_NOSIDE_ALT_TRANSPARENT = create("template_glass_pane_noside_alt", "_noside_alt",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE);
    public static final ModelTemplate STAINED_GLASS_PANE_POST_TRANSPARENT = create("template_glass_pane_post", "_post",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_SIDE_TRANSPARENT = create("template_glass_pane_side", "_side",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_SIDE_ALT_TRANSPARENT = create("template_glass_pane_side_alt", "_side_alt",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE, TextureSlot.EDGE);

    // Door
    public static final ModelTemplate DOOR_BOTTOM_LEFT_TRANSPARENT = create("door_bottom_left", "_bottom_left",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_BOTTOM_LEFT_OPEN_TRANSPARENT = create("door_bottom_left_open", "_bottom_left_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_BOTTOM_RIGHT_TRANSPARENT = create("door_bottom_right", "_bottom_right",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_BOTTOM_RIGHT_OPEN_TRANSPARENT = create("door_bottom_right_open", "_bottom_right_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_LEFT_TRANSPARENT = create("door_top_left", "_top_left",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_LEFT_OPEN_TRANSPARENT = create("door_top_left_open", "_top_left_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_RIGHT_TRANSPARENT = create("door_top_right", "_top_right",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_RIGHT_OPEN_TRANSPARENT = create("door_top_right_open", "_top_right_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);

    // Torch
    public static final ModelTemplate TORCH_WIDE_TRANSPARENT = createModded("template_torch_wide",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TORCH);
    public static final ModelTemplate WALL_TORCH_WIDE_TRANSPARENT = createModded("template_wall_torch_wide",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TORCH);

    // Flowers
    public static final ModelTemplate CROSS_TRANSPARENT = create("cross",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.CROSS);
    public static final ModelTemplate FLOWER_POT_CROSS_TRANSPARENT = create("flower_pot_cross",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PLANT);

    private static ModelTemplate create(String id, String renderType, TextureSlot... textureSlots)
    {
        return create(id, null, renderType, textureSlots);
    }

    private static ModelTemplate createModded(String id, String renderType, TextureSlot... textureSlots)
    {
        Optional<ResourceLocation> resource;
        if (id == null)
            resource = Optional.empty();
        else
            resource = Optional.of(SVTPMod.resourceLocation("block/" + id));

        return create(resource, null, renderType, textureSlots);
    }

    private static ModelTemplate create(String id, String suffix, String renderType, TextureSlot... textureSlots)
    {
        Optional<ResourceLocation> resource;
        if (id == null)
            resource = Optional.empty();
        else
            resource = Optional.of(ResourceLocation.withDefaultNamespace("block/" + id));

        return create(resource, suffix, renderType, textureSlots);
    }

    private static ModelTemplate create(Optional<ResourceLocation> resource, String suffix, String renderType, TextureSlot... textureSlots)
    {
        if (StringUtil.isBlank(renderType))
            return new ModelTemplate(resource, Optional.ofNullable(suffix), textureSlots);
        return new SVTPNeoForgeModelTemplate(resource, Optional.ofNullable(suffix), Optional.of(renderType), textureSlots);
    }

    private SVTPModelTemplates()
    {
        // No initialization
    }
}
