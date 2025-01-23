package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.RedstoneLanternBlock;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

class SVTPModelGenerator extends FabricModelProvider
{
    public SVTPModelGenerator(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator)
    {
        // Other
        createDoor(generator, SVTPBlocks.STONE_DOOR);
        createRedstoneLantern(generator, SVTPBlocks.REDSTONE_LANTERN);
        createPlantWithDefaultItem(generator, SVTPBlocks.DEAD_FLOWER, SVTPBlocks.POTTED_DEAD_FLOWER);

        // Torches
        createSvtpTorch(generator, SVTPBlocks.GOLDEN_TORCH_0, SVTPBlocks.WALL_GOLDEN_TORCH_0);
        createSvtpTorch(generator, SVTPBlocks.GOLDEN_TORCH_1, SVTPBlocks.WALL_GOLDEN_TORCH_1);
        createSvtpTorch(generator, SVTPBlocks.GOLDEN_SOUL_TORCH_0, SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_0);
        createSvtpTorch(generator, SVTPBlocks.GOLDEN_SOUL_TORCH_1, SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_1);

        // Paper
        PaperModelGenerator.create(generator, SVTPBlocks.PAPER_BUNDLE_0)
            .createModel();
        PaperModelGenerator.create(generator, SVTPBlocks.PAPER_BUNDLE_1)
            .createModel();
        PaperModelGenerator.create(generator, SVTPBlocks.PAPER_BUNDLE_2)
            .setAll(SVTPBlocks.PAPER_BUNDLE_0)
            .setBottom(SVTPBlocks.PAPER_BUNDLE_2)
            .createModel();
        PaperModelGenerator.create(generator, SVTPBlocks.PAPER_BUNDLE_3)
            .setTop(SVTPBlocks.PAPER_BUNDLE_0)
            .createModel();

        // Glass
        createArmoredGlassBlocks(generator, SVTPBlocks.ARMORED_GLASS, SVTPBlocks.ARMORED_GLASS_PANE);
        generator.createTrivialBlock(SVTPBlocks.ARMORED_TINTED_GLASS.get(), SVTPTexturedModels.CUBE_TRANSLUCENT);

        var stainedGlassBlocks = SVTPBlocks.getStainedGlassBlocks();
        var stainedGlassPaneBlocks = SVTPBlocks.getStainedGlassPaneBlocks();
        for (var i = 0; i < stainedGlassBlocks.length; i++)
            createStainedArmoredGlassBlock(generator, stainedGlassBlocks[i], stainedGlassPaneBlocks[i]);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator)
    {
    }

    private static void createArmoredGlassBlocks(BlockModelGenerators generator, RegistrySupplier<Block> blockSupplier, RegistrySupplier<Block> paneSupplier)
    {
        var block = blockSupplier.get();
        var pane = paneSupplier.get();

        // Generate the basic glass block
        generator.createTrivialBlock(block, SVTPTexturedModels.CUBE_TRANSPARENT);

        // Model with texture for each possible pane state
        var textureMapping = SVTPTextureMappings.armoredPane(block);
        var post = SVTPModelTemplates.STAINED_GLASS_PANE_POST_TRANSPARENT.create(pane, textureMapping, generator.modelOutput);
        var side = SVTPModelTemplates.STAINED_GLASS_PANE_SIDE_TRANSPARENT.create(pane, textureMapping, generator.modelOutput);
        var sideAlt = SVTPModelTemplates.STAINED_GLASS_PANE_SIDE_ALT_TRANSPARENT.create(pane, textureMapping, generator.modelOutput);
        var noSide = SVTPModelTemplates.STAINED_GLASS_PANE_NOSIDE_TRANSPARENT.create(pane, textureMapping, generator.modelOutput);
        var noSideAlt = SVTPModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT_TRANSPARENT.create(pane, textureMapping, generator.modelOutput);

        // Generate pane item model
        var item = pane.asItem();
        generator.registerSimpleItemModel(item, generator.createFlatItemModelWithBlockTexture(item, block));

        generateArmoredGlassBlock(generator, block, pane, post, side, sideAlt, noSide, noSideAlt);
    }

    private static void createStainedArmoredGlassBlock(BlockModelGenerators generator, Block block, Block pane)
    {
        // Generate the basic glass block
        generator.createTrivialBlock(block, SVTPTexturedModels.CUBE_TRANSLUCENT);

        // Model with texture for each possible pane state
        var textureMapping = SVTPTextureMappings.armoredPane(block);
        var post = SVTPModelTemplates.STAINED_GLASS_PANE_POST_TRANSLUCENT.create(pane, textureMapping, generator.modelOutput);
        var side = SVTPModelTemplates.STAINED_GLASS_PANE_SIDE_TRANSLUCENT.create(pane, textureMapping, generator.modelOutput);
        var sideAlt = SVTPModelTemplates.STAINED_GLASS_PANE_SIDE_ALT_TRANSLUCENT.create(pane, textureMapping, generator.modelOutput);
        var noSide = SVTPModelTemplates.STAINED_GLASS_PANE_NOSIDE_TRANSLUCENT.create(pane, textureMapping, generator.modelOutput);
        var noSideAlt = SVTPModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT_TRANSLUCENT.create(pane, textureMapping, generator.modelOutput);

        // Generate pane item model
        var item = pane.asItem();
        var flatModel = SVTPModelTemplates.FLAT_ITEM_TRANSLUCENT.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(block), generator.modelOutput);
        generator.registerSimpleItemModel(item, flatModel);

        generateArmoredGlassBlock(generator, block, pane, post, side, sideAlt, noSide, noSideAlt);
    }

    private static void generateArmoredGlassBlock(BlockModelGenerators generator, Block block, Block pane, ResourceLocation post, ResourceLocation side, ResourceLocation sideAlt, ResourceLocation noSide, ResourceLocation noSideAlt)
    {
        // Generate the pane model
        generator.blockStateOutput.accept(MultiPartGenerator
            .multiPart(pane)
            .with(Variant.variant().with(VariantProperties.MODEL, post))
            .with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, side))
            .with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, side).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, sideAlt))
            .with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, sideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with(Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, noSide))
            .with(Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt))
            .with(Condition.condition().term(BlockStateProperties.SOUTH, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with(Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, noSide).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
        );
    }

    private static void createDoor(BlockModelGenerators generator, RegistrySupplier<Block> blockSupplier)
    {
        var block = blockSupplier.get();

        // Model with texture for each top/bottom part in each possible state
        var textureMapping = TextureMapping.door(block);
        var bottomLeft = SVTPModelTemplates.DOOR_BOTTOM_LEFT_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var bottomLeftOpen = SVTPModelTemplates.DOOR_BOTTOM_LEFT_OPEN_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var bottomRight = SVTPModelTemplates.DOOR_BOTTOM_RIGHT_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var bottomRightOpen = SVTPModelTemplates.DOOR_BOTTOM_RIGHT_OPEN_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var topLeft = SVTPModelTemplates.DOOR_TOP_LEFT_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var topLeftOpen = SVTPModelTemplates.DOOR_TOP_LEFT_OPEN_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var topRight = SVTPModelTemplates.DOOR_TOP_RIGHT_TRANSPARENT.create(block, textureMapping, generator.modelOutput);
        var topRightOpen = SVTPModelTemplates.DOOR_TOP_RIGHT_OPEN_TRANSPARENT.create(block, textureMapping, generator.modelOutput);

        // Generate door item model
        generator.registerSimpleFlatItemModel(block.asItem());

        // Generate the door model
        generator.blockStateOutput.accept(BlockModelGenerators.createDoor(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen));
    }

    private static void createSvtpTorch(BlockModelGenerators generator, RegistrySupplier<Block> groundTorchSupplier, RegistrySupplier<Block> wallTorchSupplier)
    {
        var groundTorch = groundTorchSupplier.get();
        var wallTorch = wallTorchSupplier.get();

        var textureMapping = TextureMapping.torch(groundTorch);

        // Generate ground torch
        generator.blockStateOutput.accept(BlockModelGenerators
            .createSimpleBlock(groundTorch, SVTPModelTemplates.SVTP_TORCH_TRANSPARENT.create(groundTorch, textureMapping, generator.modelOutput)));
        // Generate wall torch
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(wallTorch,
            Variant.variant().with(VariantProperties.MODEL, SVTPModelTemplates.SVTP_TORCH_WALL_TRANSPARENT.create(wallTorch, textureMapping, generator.modelOutput))
        ).with(BlockModelGenerators.createTorchHorizontalDispatch()));

        // Generate torch item model
        generator.registerSimpleItemModel(groundTorch, generator.createFlatItemModel(groundTorch.asItem()));
    }

    private static void createRedstoneLantern(BlockModelGenerators generator, RegistrySupplier<Block> lanternSupplier)
    {
        var lantern = lanternSupplier.get();

        var unlitResource = ModelTemplates.CUBE.create(lantern, SVTPTextureMappings.redstoneLantern(lantern, "_off"), generator.modelOutput);
        var unlitVariant = Variant.variant().with(VariantProperties.MODEL, unlitResource);

        var litResource = ModelTemplates.CUBE.createWithSuffix(lantern, "_on", SVTPTextureMappings.redstoneLantern(lantern, "_on"), generator.modelOutput);
        var litVariant = Variant.variant().with(VariantProperties.MODEL, litResource);

        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(lantern)
            .with(PropertyDispatch.properties(RedstoneLanternBlock.REDSTONE_STATE, RedstoneLanternBlock.MANUAL_STATE)
                .select(false, false, unlitVariant)
                .select(true, true, unlitVariant)
                .select(true, false, litVariant)
                .select(false, true, litVariant))
            .with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createPlantWithDefaultItem(BlockModelGenerators generator, RegistrySupplier<Block> flowerSupplier, RegistrySupplier<Block> pottedFlowerSupplier)
    {
        var flower = flowerSupplier.get();
        var pottedFlower = pottedFlowerSupplier.get();

        // Plant item model
        generator.registerSimpleItemModel(flower.asItem(), BlockModelGenerators.PlantType.NOT_TINTED.createItemModel(generator, flower));

        // Plant
        var plantMapping = TextureMapping.cross(flower);
        var plantModel = SVTPModelTemplates.CROSS_TRANSPARENT.create(flower, plantMapping, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flower, plantModel));

        // Potted plant
        var pottedPlantMapping = TextureMapping.plant(flower);
        var pottedPlantModel = SVTPModelTemplates.FLOWER_POT_CROSS_TRANSPARENT.create(pottedFlower, pottedPlantMapping, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedFlower, pottedPlantModel));
    }

    private static final class PaperModelGenerator
    {
        private final BlockModelGenerators generator;
        private final RegistrySupplier<Block> target;
        private RegistrySupplier<Block> top;
        private RegistrySupplier<Block> bottom;
        private RegistrySupplier<Block> northWest;
        private RegistrySupplier<Block> southEast;

        private PaperModelGenerator(BlockModelGenerators generator, RegistrySupplier<Block> target, RegistrySupplier<Block> top, RegistrySupplier<Block> bottom, RegistrySupplier<Block> northWest, RegistrySupplier<Block> southEast)
        {
            this.generator = generator;
            this.target = target;
            this.top = top;
            this.bottom = bottom;
            this.northWest = northWest;
            this.southEast = southEast;
        }

        public static PaperModelGenerator create(BlockModelGenerators generator, RegistrySupplier<Block> target)
        {
            return new PaperModelGenerator(generator, target, target, target, target, target);
        }

        public void createModel()
        {
            var textureMapping = SVTPTextureMappings.orientableCubeSameNorthWestAndSouthEast(top.get(), bottom.get(), northWest.get(), southEast.get());
            var model = ModelTemplates.CUBE.create(target.get(), textureMapping, generator.modelOutput);

            generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(
                    target.get(), Variant.variant().with(VariantProperties.MODEL, model)
                ).with(BlockModelGenerators.createHorizontalFacingDispatch())
            );
        }

        public PaperModelGenerator setAll(RegistrySupplier<Block> block)
        {
            top = block;
            bottom = block;
            northWest = block;
            southEast = block;
            return this;
        }

        public PaperModelGenerator setTop(RegistrySupplier<Block> top)
        {
            this.top = top;
            return this;
        }

        public PaperModelGenerator setBottom(RegistrySupplier<Block> bottom)
        {
            this.bottom = bottom;
            return this;
        }

        public PaperModelGenerator setNorthWest(RegistrySupplier<Block> northWest)
        {
            this.northWest = northWest;
            return this;
        }

        public PaperModelGenerator setSouthEast(RegistrySupplier<Block> southEast)
        {
            this.southEast = southEast;
            return this;
        }
    }
}