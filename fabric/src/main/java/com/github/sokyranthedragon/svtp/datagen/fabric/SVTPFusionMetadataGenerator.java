package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.supermartijn642.fusion.api.provider.FusionTextureMetadataProvider;
import com.supermartijn642.fusion.api.texture.DefaultTextureTypes;
import com.supermartijn642.fusion.api.texture.data.BaseTextureData;
import com.supermartijn642.fusion.api.texture.data.ConnectingTextureData;
import com.supermartijn642.fusion.api.texture.data.ConnectingTextureLayout;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.level.block.Block;

public class SVTPFusionMetadataGenerator extends FusionTextureMetadataProvider
{
    public SVTPFusionMetadataGenerator(FabricDataOutput output)
    {
        super(SVTPMod.MOD_ID, output);
    }

    @Override
    protected void generate()
    {
        generateGlassTextureData(SVTPBlocks.ARMORED_GLASS, BaseTextureData.RenderType.CUTOUT);
        generateGlassTextureData(SVTPBlocks.ARMORED_TINTED_GLASS, BaseTextureData.RenderType.TRANSLUCENT);
        for (var glassBlock : SVTPBlocks.getStainedGlassBlockProviders())
            generateGlassTextureData(glassBlock, BaseTextureData.RenderType.TRANSLUCENT);
    }

    private void generateGlassTextureData(RegistrySupplier<Block> block, BaseTextureData.RenderType renderType)
    {
        addTextureMetadata(
            SVTPMod.resourceLocation("block/" + block.getId().getPath()),
            DefaultTextureTypes.CONNECTING,
            ConnectingTextureData.builder()
                .layout(ConnectingTextureLayout.SIMPLE)
                .renderType(renderType)
                .build()
        );
    }
}