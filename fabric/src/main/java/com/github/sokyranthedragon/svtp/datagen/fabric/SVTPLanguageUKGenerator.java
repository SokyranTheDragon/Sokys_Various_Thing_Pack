package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import com.github.sokyranthedragon.svtp.items.SVTPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.StainedGlassBlock;

import java.util.concurrent.CompletableFuture;

public class SVTPLanguageUKGenerator extends FabricLanguageProvider
{
    protected SVTPLanguageUKGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup)
    {
        super(dataOutput, "en_gb", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder)
    {
        builder.add(SVTPItems.ARMORED_GLASS.get(), "Armoured Glass");
        builder.add(SVTPItems.ARMORED_GLASS_PANE.get(), "Armoured Glass Pane");
        builder.add(SVTPItems.ARMORED_TINTED_GLASS.get(), "Armoured Tinted Glass");

        var stainedGlassBlocks = SVTPBlocks.getStainedGlassBlocks();
        var stainedGlassPaneBlocks = SVTPBlocks.getStainedGlassPaneBlocks();
        for (var i = 0; i < stainedGlassBlocks.length; i++)
        {
            var colorId = ((StainedGlassBlock)stainedGlassBlocks[i]).getColor().getName();
            var colorName = switch (colorId)
            {
                //@formatter:off
                case "gray" -> "Grey";
                case "light_gray" -> "Light Grey";
                default -> I18n.get("color.minecraft." + colorId);
                //@formatter:on
            };

            builder.add(stainedGlassBlocks[i], "Armoured " + colorName + " Stained Glass");
            builder.add(stainedGlassPaneBlocks[i], "Armoured " + colorName + " Stained Glass Pane");
        }
    }
}
