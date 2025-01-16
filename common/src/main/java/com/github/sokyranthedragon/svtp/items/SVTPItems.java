package com.github.sokyranthedragon.svtp.items;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.BiFunction;

@SuppressWarnings({"UnstableApiUsage"})
@MethodsReturnNonnullByDefault
public class SVTPItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SVTPMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> ARMORED_GLASS = registerBlock(SVTPBlocks.ARMORED_GLASS, CreativeModeTabs.COLORED_BLOCKS);

    public static final RegistrySupplier<Item> ARMORED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);

    public static final RegistrySupplier<Item> STONE_DOOR = registerBlock(SVTPBlocks.STONE_DOOR, DoubleHighBlockItem::new, CreativeModeTabs.REDSTONE_BLOCKS);

    public static final RegistrySupplier<Item> GOLDEN_TORCH_0 = registerBlock(SVTPBlocks.GOLDEN_TORCH_0,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_TORCH_0.get(), Direction.DOWN, properties),
        CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> GOLDEN_TORCH_1 = registerBlock(SVTPBlocks.GOLDEN_TORCH_1,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_TORCH_1.get(), Direction.DOWN, properties),
        CreativeModeTabs.BUILDING_BLOCKS, SVTPBlocks.GOLDEN_TORCH_0);

    public static final RegistrySupplier<Item> GOLDEN_SOUL_TORCH_0 = registerBlock(SVTPBlocks.GOLDEN_SOUL_TORCH_0,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_0.get(), Direction.DOWN, properties),
        CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> GOLDEN_SOUL_TORCH_1 = registerBlock(SVTPBlocks.GOLDEN_SOUL_TORCH_1,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_1.get(), Direction.DOWN, properties),
        CreativeModeTabs.BUILDING_BLOCKS, SVTPBlocks.GOLDEN_SOUL_TORCH_0);

    public static final RegistrySupplier<Item> PAPER_BUNDLE_0 = registerBlock(SVTPBlocks.PAPER_BUNDLE_0, CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_1 = registerBlock(SVTPBlocks.PAPER_BUNDLE_1, CreativeModeTabs.BUILDING_BLOCKS, SVTPBlocks.PAPER_BUNDLE_0);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_2 = registerBlock(SVTPBlocks.PAPER_BUNDLE_2, CreativeModeTabs.BUILDING_BLOCKS, SVTPBlocks.PAPER_BUNDLE_0);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_3 = registerBlock(SVTPBlocks.PAPER_BUNDLE_3, CreativeModeTabs.BUILDING_BLOCKS, SVTPBlocks.PAPER_BUNDLE_0);

    public static final RegistrySupplier<Item> REDSTONE_LANTERN = registerBlock(SVTPBlocks.REDSTONE_LANTERN, CreativeModeTabs.REDSTONE_BLOCKS);

    public static final RegistrySupplier<Item> DEAD_FLOWER = registerBlock(SVTPBlocks.DEAD_FLOWER, CreativeModeTabs.NATURAL_BLOCKS);

    public static void init()
    {
        ITEMS.register();
    }

    private static ResourceKey<Item> blockIdToItemId(ResourceLocation resourceLocation)
    {
        return ResourceKey.create(Registries.ITEM, resourceLocation);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry)
    {
        return registerBlock(registry, BlockItem::new, new Item.Properties());
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, ResourceKey<CreativeModeTab> tab)
    {
        return registerBlock(registry, BlockItem::new, new Item.Properties().arch$tab(tab));
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, Item.Properties properties)
    {
        return registerBlock(registry, BlockItem::new, properties);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function)
    {
        return registerBlock(registry, function, new Item.Properties());
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, ResourceKey<CreativeModeTab> tab, RegistrySupplier<Block> descriptionIdBlock)
    {
        return registerBlock(registry, BlockItem::new, new Item.Properties().arch$tab(tab), descriptionIdBlock);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function, ResourceKey<CreativeModeTab> tab)
    {
        return registerBlock(registry, function, new Item.Properties().arch$tab(tab));
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function, Item.Properties properties)
    {
        return registerBlock(registry, function, properties, null);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function, ResourceKey<CreativeModeTab> tab, RegistrySupplier<Block> descriptionIdBlock)
    {
        return registerBlock(registry, function, new Item.Properties().arch$tab(tab), descriptionIdBlock);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function, Item.Properties properties, RegistrySupplier<Block> descriptionIdBlock)
    {
        return ITEMS.register(registry.getId().getPath(), () ->
        {
            var block = registry.get();
            var resourceKey = blockIdToItemId(block.arch$registryName());
            if (descriptionIdBlock == null)
                properties.useBlockDescriptionPrefix();
            else
                properties.overrideDescription(descriptionIdBlock.get().getDescriptionId());

            return function.apply(block, properties.setId(resourceKey));
        });
    }
}