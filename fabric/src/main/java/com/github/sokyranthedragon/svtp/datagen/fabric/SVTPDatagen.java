package com.github.sokyranthedragon.svtp.datagen.fabric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SVTPDatagen implements DataGeneratorEntrypoint
{
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator)
    {
        var pack = generator.createPack();

        pack.addProvider(SVTPLanguageGenerator::new);
        pack.addProvider(SVTPModelGenerator::new);
        pack.addProvider(SVTPRecipeGenerator.SVTPRecipeRunner::new);
        var blockTags = pack.addProvider(SVTPBlockTagGenerator::new);
        pack.addProvider(((output, future) -> new SVTPItemTagGenerator(output, future, blockTags)));
        pack.addProvider(SVTPBlockLootTableGenerator::new);
    }
}
