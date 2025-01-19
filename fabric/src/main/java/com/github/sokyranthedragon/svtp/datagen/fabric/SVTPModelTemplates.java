package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;

import java.util.Optional;

class SVTPModelTemplates
{
    // Flat item
    public static final ModelTemplate FLAT_ITEM_TRANSLUCENT = createItem("generated",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.LAYER0);

    // Cube
    public static final ModelTemplate CUBE_ALL_TRANSPARENT = createBlock("cube_all",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.ALL);
    public static final ModelTemplate CUBE_ALL_TRANSLUCENT = createBlock("cube_all",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.ALL);

    // Pane
    public static final ModelTemplate STAINED_GLASS_PANE_NOSIDE_TRANSPARENT = createBlock("template_glass_pane_noside", "_noside",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE);
    public static final ModelTemplate STAINED_GLASS_PANE_NOSIDE_ALT_TRANSPARENT = createBlock("template_glass_pane_noside_alt", "_noside_alt",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE);
    public static final ModelTemplate STAINED_GLASS_PANE_POST_TRANSPARENT = createBlock("template_glass_pane_post", "_post",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_SIDE_TRANSPARENT = createBlock("template_glass_pane_side", "_side",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_SIDE_ALT_TRANSPARENT = createBlock("template_glass_pane_side_alt", "_side_alt",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_NOSIDE_TRANSLUCENT = createBlock("template_glass_pane_noside", "_noside",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.PANE);
    public static final ModelTemplate STAINED_GLASS_PANE_NOSIDE_ALT_TRANSLUCENT = createBlock("template_glass_pane_noside_alt", "_noside_alt",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.PANE);
    public static final ModelTemplate STAINED_GLASS_PANE_POST_TRANSLUCENT = createBlock("template_glass_pane_post", "_post",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_SIDE_TRANSLUCENT = createBlock("template_glass_pane_side", "_side",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.PANE, TextureSlot.EDGE);
    public static final ModelTemplate STAINED_GLASS_PANE_SIDE_ALT_TRANSLUCENT = createBlock("template_glass_pane_side_alt", "_side_alt",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_TRANSLUCENT, TextureSlot.PANE, TextureSlot.EDGE);

    // Door
    public static final ModelTemplate DOOR_BOTTOM_LEFT_TRANSPARENT = createBlock("door_bottom_left", "_bottom_left",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_BOTTOM_LEFT_OPEN_TRANSPARENT = createBlock("door_bottom_left_open", "_bottom_left_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_BOTTOM_RIGHT_TRANSPARENT = createBlock("door_bottom_right", "_bottom_right",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_BOTTOM_RIGHT_OPEN_TRANSPARENT = createBlock("door_bottom_right_open", "_bottom_right_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_LEFT_TRANSPARENT = createBlock("door_top_left", "_top_left",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_LEFT_OPEN_TRANSPARENT = createBlock("door_top_left_open", "_top_left_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_RIGHT_TRANSPARENT = createBlock("door_top_right", "_top_right",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);
    public static final ModelTemplate DOOR_TOP_RIGHT_OPEN_TRANSPARENT = createBlock("door_top_right_open", "_top_right_open",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TOP, TextureSlot.BOTTOM);

    // Torch
    public static final ModelTemplate SVTP_TORCH_0_TRANSPARENT = createModdedBlock("template_svtp_torch_0",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TORCH);
    public static final ModelTemplate SVTP_TORCH_WALL_0_TRANSPARENT = createModdedBlock("template_svtp_torch_wall_0",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TORCH);
    public static final ModelTemplate SVTP_TORCH_1_TRANSPARENT = createModdedBlock("template_svtp_torch_1",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TORCH);
    public static final ModelTemplate SVTP_TORCH_WALL_1_TRANSPARENT = createModdedBlock("template_svtp_torch_wall_1",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.TORCH);

    // Flowers
    public static final ModelTemplate CROSS_TRANSPARENT = createBlock("cross",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.CROSS);
    public static final ModelTemplate FLOWER_POT_CROSS_TRANSPARENT = createBlock("flower_pot_cross",
        SVTPNeoForgeModelTemplate.RENDER_TYPE_CUTOUT, TextureSlot.PLANT);

    private static ModelTemplate createItem(String id, String renderType, TextureSlot... textureSlots)
    {
        return createItem(id, null, renderType, textureSlots);
    }

    private static ModelTemplate createBlock(String id, String renderType, TextureSlot... textureSlots)
    {
        return createBlock(id, null, renderType, textureSlots);
    }

    private static ModelTemplate createModdedBlock(String id, String renderType, TextureSlot... textureSlots)
    {
        Optional<ResourceLocation> resource;
        if (id == null)
            resource = Optional.empty();
        else
            resource = Optional.of(SVTPMod.resourceLocation("block/" + id));

        return create(resource, null, renderType, textureSlots);
    }

    private static ModelTemplate createItem(String id, String suffix, String renderType, TextureSlot... textureSlots)
    {
        Optional<ResourceLocation> resource;
        if (id == null)
            resource = Optional.empty();
        else
            resource = Optional.of(ResourceLocation.withDefaultNamespace("item/" + id));

        return create(resource, suffix, renderType, textureSlots);
    }

    private static ModelTemplate createBlock(String id, String suffix, String renderType, TextureSlot... textureSlots)
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
