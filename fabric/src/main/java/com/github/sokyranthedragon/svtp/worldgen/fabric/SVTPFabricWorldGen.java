package com.github.sokyranthedragon.svtp.worldgen.fabric;

import com.github.sokyranthedragon.svtp.SVTPMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.function.Predicate;

public class SVTPFabricWorldGen
{
    public static void initWorldGen()
    {
        registerDeadFlowerGeneration(BiomeSelectors.tag(BiomeTags.IS_BADLANDS), "patch_dead_flower_badlands");
        registerDeadFlowerGeneration(BiomeSelectors.includeByKey(Biomes.DESERT), "patch_dead_flower_desert");
        registerDeadFlowerGeneration(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA), "patch_dead_flower_old_growth_taiga");
        registerDeadFlowerGeneration(BiomeSelectors.tag(ConventionalBiomeTags.IS_SWAMP), "patch_dead_flower_swamp");
    }

    private static void registerDeadFlowerGeneration(Predicate<BiomeSelectionContext> biomeSelector, String featureId)
    {
        BiomeModifications.addFeature(biomeSelector, GenerationStep.Decoration.VEGETAL_DECORATION, SVTPMod.resourceKey(Registries.PLACED_FEATURE, featureId));
    }
}
