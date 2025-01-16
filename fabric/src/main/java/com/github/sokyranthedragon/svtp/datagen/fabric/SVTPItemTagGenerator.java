package com.github.sokyranthedragon.svtp.datagen.fabric;

import com.github.sokyranthedragon.svtp.items.SVTPItems;
import com.github.sokyranthedragon.svtp.tags.SVTPConventionalBlockTags;
import com.github.sokyranthedragon.svtp.tags.SVTPConventionalItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SVTPItemTagGenerator extends FabricTagProvider.ItemTagProvider
{
    public SVTPItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable BlockTagProvider blockTagProvider)
    {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        // Vanilla tags
        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
            .add(SVTPItems.GOLDEN_TORCH_0.get())
            .add(SVTPItems.GOLDEN_TORCH_1.get())
            .add(SVTPItems.GOLDEN_SOUL_TORCH_0.get())
            .add(SVTPItems.GOLDEN_SOUL_TORCH_1.get());

        getOrCreateTagBuilder(ItemTags.DOORS)
            .add(SVTPItems.STONE_DOOR.get());

        // Conventional tags
        getOrCreateTagBuilder(ConventionalItemTags.GLASS_BLOCKS_COLORLESS)
            .add(SVTPItems.ARMORED_GLASS.get());

        getOrCreateTagBuilder(ConventionalItemTags.GLASS_PANES_COLORLESS)
            .add(SVTPItems.ARMORED_GLASS_PANE.get());

        // SVTP conventional tags
        copy(SVTPConventionalBlockTags.STORAGE_BLOCKS_PAPER, SVTPConventionalItemTags.STORAGE_BLOCKS_PAPER);
    }
}
