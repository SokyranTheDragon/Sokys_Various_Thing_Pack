package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.crafting.SVTPSuspiciousStewRecipe;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import com.github.sokyranthedragon.svtp.tags.SVTPItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.StainedGlassBlock;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.ShapedRecipeBuilder.*;
import static net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless;
import static net.minecraft.data.recipes.SpecialRecipeBuilder.special;

class SVTPRecipeGenerator extends FabricRecipeProvider
{
    public SVTPRecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput output)
    {
        shaped(RecipeCategory.REDSTONE, SVTPItems.STONE_DOOR.get(), 3)
            .define('s', Items.STONE)
            .pattern("ss")
            .pattern("ss")
            .pattern("ss")
            .unlockedBy(getHasName(Items.STONE), has(MinMaxBounds.Ints.atLeast(6), Items.STONE))
            .save(output);

        shaped(RecipeCategory.REDSTONE, SVTPItems.REDSTONE_LANTERN.get(), 1)
            .define('c', Items.COBBLESTONE)
            .define('r', ConventionalItemTags.REDSTONE_DUSTS)
            .define('g', Items.GLOWSTONE)
            .define('l', Items.LEVER)
            .pattern("crl")
            .pattern("rgr")
            .pattern("crc")
            .unlockedBy(getHasName(Items.GLOWSTONE), has(Items.GLOWSTONE))
            .save(output);

        // Torch recipes
        shaped(RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_TORCH_0.get(), 4)
            .define('c', ItemTags.COALS)
            .define('g', ConventionalItemTags.GOLD_INGOTS)
            .pattern("c")
            .pattern("g")
            .unlockedBy(getHasName(Items.GOLD_INGOT), has(ConventionalItemTags.GOLD_INGOTS))
            .save(output);
        conversionRecipe(output, RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_TORCH_0.get(), SVTPItems.GOLDEN_TORCH_1.get());

        shaped(RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_SOUL_TORCH_0.get(), 4)
            .define('c', ItemTags.COALS)
            .define('g', ConventionalItemTags.GOLD_INGOTS)
            .define('s', ItemTags.SOUL_FIRE_BASE_BLOCKS)
            .pattern("c")
            .pattern("g")
            .pattern("s")
            .unlockedBy(getHasName(Items.SOUL_SAND), has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
            .save(output);
        conversionRecipe(output, RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_SOUL_TORCH_0.get(), SVTPItems.GOLDEN_SOUL_TORCH_1.get());

        // Paper bundle recipes
        nineBlockStorageRecipesWithExtraVariants(output, RecipeCategory.MISC, Items.PAPER, "paper", RecipeCategory.DECORATIONS,
            SVTPItems.PAPER_BUNDLE_0.get(), SVTPItemTags.PAPER_BUNDLES);
        twoByTwoConversionRecipe(output, RecipeCategory.MISC,
            SVTPItems.PAPER_BUNDLE_0.get(), SVTPItems.PAPER_BUNDLE_1.get(), SVTPItems.PAPER_BUNDLE_2.get(),
            SVTPItems.PAPER_BUNDLE_3.get(), SVTPItems.PAPER_BUNDLE_4.get(), SVTPItems.PAPER_BUNDLE_5.get());

        // Suspicious stew
        // Could just add SMALL_FLOWERS tag to the dead flower since it's a SuspiciousEffectHolder, but we don't want this tag there.
        special(SVTPSuspiciousStewRecipe::new).save(output, SVTPMod.resourceLocation("suspicious_stew"));

        // Glass
        armoredGlassAndPaneRecipe(output, Items.GLASS, SVTPItems.ARMORED_GLASS.get(), SVTPItems.ARMORED_GLASS_PANE.get());
        armoredGlassRecipe(output, Items.TINTED_GLASS, SVTPItems.ARMORED_TINTED_GLASS.get());

        var stainedGlassBlocks = SVTPBlocks.getStainedGlassBlocks();
        var stainedGlassPanes = SVTPBlocks.getStainedGlassPaneBlocks();
        for (var i = 0; i < stainedGlassBlocks.length; i++)
        {
            var targetColor = ((StainedGlassBlock)stainedGlassBlocks[i]).getColor();
            var targetBlock = BuiltInRegistries.BLOCK.entrySet().stream().filter((set) ->
                set.getKey().location().getNamespace().equals("minecraft") &&
                    set.getValue() instanceof StainedGlassBlock glass &&
                    glass.getColor() == targetColor)
                .findFirst().orElseThrow().getValue();
            armoredGlassAndPaneRecipe(output, targetBlock, stainedGlassBlocks[i], stainedGlassPanes[i]);
        }
    }

    private void nineBlockStorageRecipesWithExtraVariants(RecipeOutput output, RecipeCategory unpackingCategory, ItemLike unpackedItem, @Nullable String unpackingGroupName, RecipeCategory packingCategory, ItemLike... packedItems)
    {
        if (packedItems == null || packedItems.length == 0)
            return;

        // nineBlockStorageRecipes() method, but use correct namespace rather than "minecraft".
        // Only the shaped part, as shapeless is handled by the loop.
        shaped(packingCategory, packedItems[0])
            .define('#', unpackedItem)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
            .save(output, SVTPMod.resourceLocation(getSimpleRecipeName(packedItems[0])));

        var unpackingRecipeName = getSimpleRecipeName(unpackedItem) + "_unpacking";

        for (var i = 0; i < packedItems.length; i++)
        {
            shapeless(unpackingCategory, unpackedItem, 9)
                .requires(packedItems[i])
                .group(unpackingGroupName)
                .unlockedBy(getHasName(packedItems[i]), has(packedItems[i]))
                .save(output, SVTPMod.resourceLocation(unpackingRecipeName + "_" + i));
        }
    }

    private void nineBlockStorageRecipesWithExtraVariants(RecipeOutput output, RecipeCategory unpackingCategory, ItemLike unpackedItem, @Nullable String unpackingGroupName, RecipeCategory packingCategory, ItemLike firstPackedItem, TagKey<Item> packedItemsTag)
    {
        // nineBlockStorageRecipes() method, but use correct namespace rather than "minecraft".
        // Only the shaped part, as shapeless is handled by the loop.
        shaped(packingCategory, firstPackedItem)
            .define('#', unpackedItem)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .unlockedBy(getHasName(unpackedItem), has(MinMaxBounds.Ints.atLeast(9), unpackedItem))
            .save(output, SVTPMod.resourceLocation(getSimpleRecipeName(firstPackedItem)));

        shapeless(unpackingCategory, unpackedItem, 9)
            .requires(packedItemsTag)
            .group(unpackingGroupName)
            .unlockedBy(getHasName(firstPackedItem), has(packedItemsTag))
            .save(output, SVTPMod.resourceLocation(getSimpleRecipeName(unpackedItem) + "_unpacking"));
    }

    private void conversionRecipe(RecipeOutput output, RecipeCategory category, ItemLike... items)
    {
        if (items == null || items.length <= 1)
            throw new RuntimeException("Expected items to have at least 2 items, but it " + (items == null ? "is null." : "has only 1 element."));

        var groupName = getItemName(items[0]) + "_conversion";
        for (var current = 0; current < items.length; current++)
        {
            var next = (current + 1) % items.length;

            shapeless(category, items[next])
                .requires(items[current])
                .group(groupName)
                .unlockedBy(getHasName(items[current]), has(items[current]))
                .save(output, SVTPMod.resourceLocation(getSimpleRecipeName(items[next]) + "_convert"));
        }
    }

    private void twoByTwoConversionRecipe(RecipeOutput output, RecipeCategory category, ItemLike... items)
    {
        if (items == null || items.length <= 1)
            throw new RuntimeException("Expected items to have at least 2 items, but it " + (items == null ? "is null." : "has only 1 element."));

        var groupName = getItemName(items[0]) + "_conversion";
        for (var current = 0; current < items.length; current++)
        {
            var next = (current + 1) % items.length;

            shaped(category, items[next], 4)
                .define('#', items[current])
                .pattern("##")
                .pattern("##")
                .group(groupName)
                .unlockedBy(getHasName(items[current]), has(MinMaxBounds.Ints.atLeast(4), items[current]))
                .save(output, SVTPMod.resourceLocation(getSimpleRecipeName(items[next]) + "_convert"));
        }
    }

    private void armoredGlassAndPaneRecipe(RecipeOutput output, ItemLike baseGlass, ItemLike targetGlass, ItemLike targetPane)
    {
        armoredGlassRecipe(output, baseGlass, targetGlass);

        shaped(RecipeCategory.DECORATIONS, targetPane, 16)
            .define('a', targetGlass)
            .pattern("aaa")
            .pattern("aaa")
            .unlockedBy(getHasName(targetGlass), has(MinMaxBounds.Ints.atLeast(6), targetGlass))
            .save(output);
    }

    // Separate recipe for tinted glass, since there's no pane
    private void armoredGlassRecipe(RecipeOutput output, ItemLike baseGlass, ItemLike targetGlass)
    {
        shaped(RecipeCategory.DECORATIONS, targetGlass, 4)
            .define('g', baseGlass)
            .define('o', Items.OBSIDIAN)
            .pattern("ogo")
            .pattern("g g")
            .pattern("ogo")
            .unlockedBy(getHasName(Items.OBSIDIAN), has(MinMaxBounds.Ints.atLeast(4), Items.OBSIDIAN))
            .save(output);
    }
}