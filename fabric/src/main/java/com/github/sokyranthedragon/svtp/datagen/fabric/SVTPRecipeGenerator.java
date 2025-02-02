package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

class SVTPRecipeGenerator extends RecipeProvider
{
    protected SVTPRecipeGenerator(HolderLookup.Provider provider, RecipeOutput recipeOutput)
    {
        super(provider, recipeOutput);
    }

    @Override
    public void buildRecipes()
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
        conversionRecipe(RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_TORCH_0.get(), SVTPItems.GOLDEN_TORCH_1.get());

        shaped(RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_SOUL_TORCH_0.get(), 4)
            .define('c', ItemTags.COALS)
            .define('g', ConventionalItemTags.GOLD_INGOTS)
            .define('s', ItemTags.SOUL_FIRE_BASE_BLOCKS)
            .pattern("c")
            .pattern("g")
            .pattern("s")
            .unlockedBy(getHasName(Items.SOUL_SAND), has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
            .save(output);
        conversionRecipe(RecipeCategory.DECORATIONS, SVTPItems.GOLDEN_SOUL_TORCH_0.get(), SVTPItems.GOLDEN_SOUL_TORCH_1.get());

        // Paper bundle recipes
        nineBlockStorageRecipesWithExtraVariants(RecipeCategory.MISC, Items.PAPER, "paper", RecipeCategory.DECORATIONS,
            SVTPItems.PAPER_BUNDLE_0.get(), SVTPItems.PAPER_BUNDLE_1.get(), SVTPItems.PAPER_BUNDLE_2.get(), SVTPItems.PAPER_BUNDLE_3.get());
        twoByTwoConversionRecipe(RecipeCategory.MISC, SVTPItems.PAPER_BUNDLE_0.get(), SVTPItems.PAPER_BUNDLE_1.get(), SVTPItems.PAPER_BUNDLE_2.get(), SVTPItems.PAPER_BUNDLE_3.get());

        // Suspicious stew
        // Probably an overkill, as there likely won't be more.
        // Still, why not I guess?
        BuiltInRegistries.ITEM.entrySet().forEach((entry) ->
        {
            if (entry.getKey().location().getNamespace().equals(SVTPMod.MOD_ID))
            {
                var item = entry.getValue();

                var suspiciousEffectHolder = SuspiciousEffectHolder.tryGet(item);
                if (suspiciousEffectHolder != null)
                    suspiciousStew(item, suspiciousEffectHolder);
            }
        });

        // Glass
        armoredGlassAndPaneRecipe(Items.GLASS, SVTPItems.ARMORED_GLASS.get(), SVTPItems.ARMORED_GLASS_PANE.get());
        armoredGlassRecipe(Items.TINTED_GLASS, SVTPItems.ARMORED_TINTED_GLASS.get());

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
            armoredGlassAndPaneRecipe(targetBlock, stainedGlassBlocks[i], stainedGlassPanes[i]);
        }
    }

    private void nineBlockStorageRecipesWithExtraVariants(RecipeCategory unpackingCategory, ItemLike unpackedItem, @Nullable String unpackingGroupName, RecipeCategory packingCategory, ItemLike... packedItems)
    {
        if (packedItems == null || packedItems.length == 0)
            return;

        var unpackingRecipeName = getSimpleRecipeName(unpackedItem) + "_unpacking";
        // nineBlockStorageRecipes() method, but use correct namespace rather than "minecraft".
        // Only the shaped part, as shapeless is handled by the loop.
        shaped(packingCategory, packedItems[0])
            .define('#', unpackedItem)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .unlockedBy(getHasName(unpackedItem), has(MinMaxBounds.Ints.atLeast(9), unpackedItem))
            .save(output, ResourceKey.create(Registries.RECIPE, SVTPMod.resourceLocation(getSimpleRecipeName(packedItems[0]))));

        for (var i = 0; i < packedItems.length; i++)
        {
            shapeless(unpackingCategory, unpackedItem, 9)
                .requires(packedItems[i])
                .group(unpackingGroupName)
                .unlockedBy(getHasName(packedItems[i]), has(packedItems[i]))
                .save(output, ResourceKey.create(Registries.RECIPE, SVTPMod.resourceLocation(unpackingRecipeName + "_" + i)));
        }
    }

    private void conversionRecipe(RecipeCategory category, ItemLike... items)
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
                .save(output, ResourceKey.create(Registries.RECIPE, SVTPMod.resourceLocation(getSimpleRecipeName(items[next]) + "_convert")));
        }
    }

    private void twoByTwoConversionRecipe(RecipeCategory category, ItemLike... items)
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
                .save(output, ResourceKey.create(Registries.RECIPE, SVTPMod.resourceLocation(getSimpleRecipeName(items[next]) + "_convert")));
        }
    }

    private void armoredGlassAndPaneRecipe(ItemLike baseGlass, ItemLike targetGlass, ItemLike targetPane)
    {
        armoredGlassRecipe(baseGlass, targetGlass);

        shaped(RecipeCategory.DECORATIONS, targetPane, 16)
            .define('a', targetGlass)
            .pattern("aaa")
            .pattern("aaa")
            .unlockedBy(getHasName(targetGlass), has(MinMaxBounds.Ints.atLeast(6), targetGlass))
            .save(output);
    }

    // Separate recipe for tinted glass, since there's no pane
    private void armoredGlassRecipe(ItemLike baseGlass, ItemLike targetGlass)
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

    @Override
    public void suspiciousStew(Item item, SuspiciousEffectHolder suspiciousEffectHolder)
    {
        // Vanilla method always unlocks recipe with "minecraft" namespace in its recipe advancement

        @SuppressWarnings("deprecation")
        var stewStack = new ItemStack(Items.SUSPICIOUS_STEW.builtInRegistryHolder(), 1, DataComponentPatch.builder().set(DataComponents.SUSPICIOUS_STEW_EFFECTS, suspiciousEffectHolder.getSuspiciousEffects()).build());

        shapeless(RecipeCategory.FOOD, stewStack)
            .requires(Items.BOWL)
            .requires(Items.BROWN_MUSHROOM)
            .requires(Items.RED_MUSHROOM)
            .requires(item)
            .group("suspicious_stew")
            .unlockedBy(getHasName(item), has(item))
            .save(output, SVTPMod.resourceKey(Registries.RECIPE, getItemName(stewStack.getItem()) + "_from_" + getItemName(item)));
    }

    @MethodsReturnNonnullByDefault
    public static class SVTPRecipeRunner extends FabricRecipeProvider
    {
        public SVTPRecipeRunner(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture)
        {
            super(output, registriesFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput)
        {
            return new SVTPRecipeGenerator(provider, recipeOutput);
        }

        @Override
        public String getName()
        {
            return "Recipe Generator";
        }
    }
}
