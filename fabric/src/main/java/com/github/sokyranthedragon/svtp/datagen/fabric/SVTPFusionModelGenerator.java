package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.supermartijn642.fusion.api.model.DefaultModelTypes;
import com.supermartijn642.fusion.api.model.ModelInstance;
import com.supermartijn642.fusion.api.model.data.ConnectingModelData;
import com.supermartijn642.fusion.api.model.data.ConnectingModelDataBuilder;
import com.supermartijn642.fusion.api.predicate.ConnectionDirection;
import com.supermartijn642.fusion.api.predicate.DefaultConnectionPredicates;
import com.supermartijn642.fusion.api.provider.FusionModelProvider;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class SVTPFusionModelGenerator extends FusionModelProvider
{
    public SVTPFusionModelGenerator(FabricDataOutput output)
    {
        super(SVTPMod.MOD_ID, output);
    }

    @Override
    protected void generate()
    {
        generateGlassBlockModel(SVTPBlocks.ARMORED_GLASS);
        generateGlassPaneModel(SVTPBlocks.ARMORED_GLASS_PANE, SVTPBlocks.ARMORED_GLASS);
        generateGlassBlockModel(SVTPBlocks.ARMORED_TINTED_GLASS);

        var glassBlocks = SVTPBlocks.getStainedGlassBlockProviders();
        var glassPanes = SVTPBlocks.getStainedGlassPaneBlockProviders();
        for (var i = 0; i < glassBlocks.length; i++)
        {
            generateGlassBlockModel(glassBlocks[i]);
            generateGlassPaneModel(glassPanes[i], glassBlocks[i]);
        }
    }

    private void generateGlassBlockModel(RegistrySupplier<Block> block)
    {
        var modelInstance = ModelInstance.of(DefaultModelTypes.CONNECTING, getBlockModelDataBuilder(block).build());
        addModel(SVTPMod.resourceLocation("block/" + block.getId().getPath()), modelInstance);
    }

    private void generateGlassPaneModel(RegistrySupplier<Block> paneSupplier, RegistrySupplier<Block> blockSupplier)
    {
        generateGlassPaneModel(paneSupplier, blockSupplier, "_noside", false);
        generateGlassPaneModel(paneSupplier, blockSupplier, "_noside_alt", false);
        generateGlassPaneModel(paneSupplier, blockSupplier, "_side", true);
        generateGlassPaneModel(paneSupplier, blockSupplier, "_side_alt", true);
    }

    private void generateGlassPaneModel(RegistrySupplier<Block> pane, RegistrySupplier<Block> blockSupplier, String side, boolean edge)
    {
        var modelData = edge ? getPaneModelDataBuilderWithEdge(side, blockSupplier) : getPaneModelDataBuilder(side, blockSupplier);
        var modelInstance = ModelInstance.of(DefaultModelTypes.CONNECTING, modelData.build());
        addModel(SVTPMod.resourceLocation("block/" + pane.getId().getPath() + side), modelInstance);
    }

    private ConnectingModelDataBuilder getBaseModelDataBuilder(String parent, RegistrySupplier<Block> blockSupplier)
    {
        return ConnectingModelData.builder()
            .parent(ResourceLocation.withDefaultNamespace("block/" + parent));
    }

    private ConnectingModelDataBuilder getBlockModelDataBuilder(RegistrySupplier<Block> blockSupplier)
    {
        return getBaseModelDataBuilder("cube_all", blockSupplier)
            .connection(DefaultConnectionPredicates.isSameBlock())
            .texture(TextureSlot.ALL.getId(), SVTPMod.resourceLocation("block/" + blockSupplier.getId().getPath()));
    }

    private ConnectingModelDataBuilder getPaneModelDataBuilder(String parent, RegistrySupplier<Block> blockSupplier)
    {
        return getBaseModelDataBuilder("template_glass_pane" + parent, blockSupplier)
            .connection(DefaultConnectionPredicates.and(
                DefaultConnectionPredicates.isSameBlock(),
                DefaultConnectionPredicates.isDirection(ConnectionDirection.LEFT, ConnectionDirection.RIGHT)
            ))
            .texture(TextureSlot.PANE.getId(), SVTPMod.resourceLocation("block/" + blockSupplier.getId().getPath()));
    }

    private ConnectingModelDataBuilder getPaneModelDataBuilderWithEdge(String parent, RegistrySupplier<Block> blockSupplier)
    {
        return getPaneModelDataBuilder(parent, blockSupplier)
            .texture(TextureSlot.EDGE.getId(), SVTPMod.resourceLocation("block/armored_glass_pane_top"));
    }
}