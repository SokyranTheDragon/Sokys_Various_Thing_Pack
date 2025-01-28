package com.github.sokyranthedragon.svtp.datagen.fabric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class SVTPDatagen implements DataGeneratorEntrypoint
{
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator)
    {
        var pack = generator.createPack();

        pack.addProvider(SVTPLanguageUSGenerator::new);
        pack.addProvider(SVTPLanguageUKGenerator::new);
        pack.addProvider(SVTPModelGenerator::new);
        pack.addProvider(SVTPRecipeGenerator.SVTPRecipeRunner::new);
        var blockTags = pack.addProvider(SVTPBlockTagGenerator::new);
        pack.addProvider(((output, future) -> new SVTPItemTagGenerator(output, future, blockTags)));
        pack.addProvider(SVTPBlockLootTableGenerator::new);

        // Fusion, with a workaround to generate in custom path
        var fusionPath = getFabricDataOutput(generator, pack).resolve("fusion");
        //noinspection UnstableApiUsage
        var fusionOutput = new FabricDataOutput(generator.getModContainer(), fusionPath, generator.isStrictValidationEnabled());
        pack.addProvider((output, future) -> new SVTPFusionModelGenerator(fusionOutput));
        pack.addProvider((output, future) -> new SVTPFusionMetadataGenerator(fusionOutput));
    }

    @NotNull
    private static Path getFabricDataOutput(FabricDataGenerator generator, FabricDataGenerator.Pack pack)
    {
        try
        {
            var field = DataGenerator.PackGenerator.class.getDeclaredField("output");
            field.setAccessible(true);
            return ((PackOutput)field.get(pack)).getOutputFolder();
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }
}