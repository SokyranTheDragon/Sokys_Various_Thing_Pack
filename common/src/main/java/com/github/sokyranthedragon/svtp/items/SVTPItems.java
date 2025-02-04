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
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Contract;

import java.util.function.BiFunction;
import java.util.function.Supplier;

@SuppressWarnings({"UnstableApiUsage"})
@MethodsReturnNonnullByDefault
public class SVTPItems
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SVTPMod.MOD_ID, Registries.ITEM);

    // Normal and pane
    public static final RegistrySupplier<Item> ARMORED_GLASS = registerBlock(SVTPBlocks.ARMORED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    // Tinted
    public static final RegistrySupplier<Item> ARMORED_TINTED_GLASS = registerBlock(SVTPBlocks.ARMORED_TINTED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    // Stained
    public static final RegistrySupplier<Item> ARMORED_WHITE_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_WHITE_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_ORANGE_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_ORANGE_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_MAGENTA_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_MAGENTA_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_LIGHT_BLUE_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_LIGHT_BLUE_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_YELLOW_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_YELLOW_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_LIME_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_LIME_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_PINK_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_PINK_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_GRAY_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_GRAY_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_LIGHT_GRAY_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_LIGHT_GRAY_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_CYAN_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_CYAN_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_PURPLE_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_PURPLE_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_BLUE_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_BLUE_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_BROWN_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_BROWN_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_GREEN_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_GREEN_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_RED_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_RED_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_BLACK_STAINED_GLASS = registerBlock(SVTPBlocks.ARMORED_BLACK_STAINED_GLASS, CreativeModeTabs.COLORED_BLOCKS);
    // Stained pane
    public static final RegistrySupplier<Item> ARMORED_WHITE_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_WHITE_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_ORANGE_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_ORANGE_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_MAGENTA_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_MAGENTA_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_LIGHT_BLUE_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_LIGHT_BLUE_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_YELLOW_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_YELLOW_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_LIME_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_LIME_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_PINK_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_PINK_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_GRAY_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_GRAY_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_LIGHT_GRAY_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_LIGHT_GRAY_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_CYAN_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_CYAN_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_PURPLE_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_PURPLE_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_BLUE_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_BLUE_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_BROWN_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_BROWN_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_GREEN_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_GREEN_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_RED_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_RED_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);
    public static final RegistrySupplier<Item> ARMORED_BLACK_STAINED_GLASS_PANE = registerBlock(SVTPBlocks.ARMORED_BLACK_STAINED_GLASS_PANE, CreativeModeTabs.COLORED_BLOCKS);

    public static final RegistrySupplier<Item> STONE_DOOR = registerBlock(SVTPBlocks.STONE_DOOR, DoubleHighBlockItem::new, CreativeModeTabs.BUILDING_BLOCKS);

    public static final RegistrySupplier<Item> GOLDEN_TORCH_0 = registerBlock(SVTPBlocks.GOLDEN_TORCH_0,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_TORCH_0.get(), Direction.DOWN, properties),
        CreativeModeTabs.FUNCTIONAL_BLOCKS);
    public static final RegistrySupplier<Item> GOLDEN_TORCH_1 = registerBlock(SVTPBlocks.GOLDEN_TORCH_1,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_TORCH_1.get(), Direction.DOWN, properties),
        CreativeModeTabs.FUNCTIONAL_BLOCKS);

    public static final RegistrySupplier<Item> GOLDEN_SOUL_TORCH_0 = registerBlock(SVTPBlocks.GOLDEN_SOUL_TORCH_0,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_0.get(), Direction.DOWN, properties),
        CreativeModeTabs.FUNCTIONAL_BLOCKS);
    public static final RegistrySupplier<Item> GOLDEN_SOUL_TORCH_1 = registerBlock(SVTPBlocks.GOLDEN_SOUL_TORCH_1,
        (block, properties) -> new StandingAndWallBlockItem(block, SVTPBlocks.WALL_GOLDEN_SOUL_TORCH_1.get(), Direction.DOWN, properties),
        CreativeModeTabs.FUNCTIONAL_BLOCKS);

    public static final RegistrySupplier<Item> PAPER_BUNDLE_0 = registerBlock(SVTPBlocks.PAPER_BUNDLE_0, CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_1 = registerBlock(SVTPBlocks.PAPER_BUNDLE_1, CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_2 = registerBlock(SVTPBlocks.PAPER_BUNDLE_2, CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_3 = registerBlock(SVTPBlocks.PAPER_BUNDLE_3, CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_4 = registerBlock(SVTPBlocks.PAPER_BUNDLE_4, CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistrySupplier<Item> PAPER_BUNDLE_5 = registerBlock(SVTPBlocks.PAPER_BUNDLE_5, CreativeModeTabs.BUILDING_BLOCKS);

    public static final RegistrySupplier<Item> REDSTONE_LANTERN = registerBlock(SVTPBlocks.REDSTONE_LANTERN, CreativeModeTabs.FUNCTIONAL_BLOCKS);

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
        return registerBlock(registry, BlockItem::new, Item.Properties::new);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, ResourceKey<CreativeModeTab> tab)
    {
        return registerBlock(registry, BlockItem::new, tab);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, Supplier<Item.Properties> properties)
    {
        return registerBlock(registry, BlockItem::new, properties);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function)
    {
        return registerBlock(registry, function, Item.Properties::new);
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function, ResourceKey<CreativeModeTab> tab)
    {
        return registerBlock(registry, function, () -> new Item.Properties().arch$tab(tab));
    }

    private static RegistrySupplier<Item> registerBlock(RegistrySupplier<Block> registry, BiFunction<Block, Item.Properties, Item> function, Supplier<Item.Properties> properties)
    {
        return ITEMS.register(registry.getId().getPath(),
            () -> function.apply(registry.get(), properties.get().setId(blockIdToItemId(registry.getId())).useBlockDescriptionPrefix()));
    }

    @Contract(pure = true)
    public static Item[] getStainedGlassItems()
    {
        return new Item[]
            {
                ARMORED_WHITE_STAINED_GLASS.get(),
                ARMORED_ORANGE_STAINED_GLASS.get(),
                ARMORED_MAGENTA_STAINED_GLASS.get(),
                ARMORED_LIGHT_BLUE_STAINED_GLASS.get(),
                ARMORED_YELLOW_STAINED_GLASS.get(),
                ARMORED_LIME_STAINED_GLASS.get(),
                ARMORED_PINK_STAINED_GLASS.get(),
                ARMORED_GRAY_STAINED_GLASS.get(),
                ARMORED_LIGHT_GRAY_STAINED_GLASS.get(),
                ARMORED_CYAN_STAINED_GLASS.get(),
                ARMORED_PURPLE_STAINED_GLASS.get(),
                ARMORED_BLUE_STAINED_GLASS.get(),
                ARMORED_BROWN_STAINED_GLASS.get(),
                ARMORED_GREEN_STAINED_GLASS.get(),
                ARMORED_RED_STAINED_GLASS.get(),
                ARMORED_BLACK_STAINED_GLASS.get(),
            };
    }

    @Contract(pure = true)
    public static Item[] getStainedGlassPaneItems()
    {
        return new Item[]
            {
                ARMORED_WHITE_STAINED_GLASS_PANE.get(),
                ARMORED_ORANGE_STAINED_GLASS_PANE.get(),
                ARMORED_MAGENTA_STAINED_GLASS_PANE.get(),
                ARMORED_LIGHT_BLUE_STAINED_GLASS_PANE.get(),
                ARMORED_YELLOW_STAINED_GLASS_PANE.get(),
                ARMORED_LIME_STAINED_GLASS_PANE.get(),
                ARMORED_PINK_STAINED_GLASS_PANE.get(),
                ARMORED_GRAY_STAINED_GLASS_PANE.get(),
                ARMORED_LIGHT_GRAY_STAINED_GLASS_PANE.get(),
                ARMORED_CYAN_STAINED_GLASS_PANE.get(),
                ARMORED_PURPLE_STAINED_GLASS_PANE.get(),
                ARMORED_BLUE_STAINED_GLASS_PANE.get(),
                ARMORED_BROWN_STAINED_GLASS_PANE.get(),
                ARMORED_GREEN_STAINED_GLASS_PANE.get(),
                ARMORED_RED_STAINED_GLASS_PANE.get(),
                ARMORED_BLACK_STAINED_GLASS_PANE.get(),
            };
    }
}