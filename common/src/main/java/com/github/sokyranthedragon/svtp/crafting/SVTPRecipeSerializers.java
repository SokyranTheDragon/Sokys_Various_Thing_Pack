package com.github.sokyranthedragon.svtp.crafting;

import com.github.sokyranthedragon.svtp.SVTPMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class SVTPRecipeSerializers
{
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(SVTPMod.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static final RegistrySupplier<RecipeSerializer<SVTPSuspiciousStewRecipe>> SVTP_SUSPICIOUS_STEW = RECIPE_SERIALIZERS.register("suspicious_stew",
        () -> new SimpleCraftingRecipeSerializer<>(SVTPSuspiciousStewRecipe::new));

    public static void init()
    {
        RECIPE_SERIALIZERS.register();
    }
}