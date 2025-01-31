package com.github.sokyranthedragon.svtp.crafting;

import com.github.sokyranthedragon.svtp.blocks.SVTPBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

@MethodsReturnNonnullByDefault
public class SVTPSuspiciousStewRecipe extends SuspiciousStewRecipe
{
    public SVTPSuspiciousStewRecipe(CraftingBookCategory craftingBookCategory)
    {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level)
    {
        var brownMushroom = false;
        var redMushroom = false;
        var bowl = false;
        var flower = false;

        for (var i = 0; i < craftingInput.size(); i++)
        {
            var stack = craftingInput.getItem(i);
            if (stack.isEmpty())
                continue;

            if (!brownMushroom && stack.is(Blocks.BROWN_MUSHROOM.asItem()))
                brownMushroom = true;
            else if (!redMushroom && stack.is(Blocks.RED_MUSHROOM.asItem()))
                redMushroom = true;
            else if (!bowl && stack.is(Items.BOWL))
                bowl = true;
            // Since we only have 1 supported item, may as well do it like this.
            // If we end up adding more in the future, may need as well change this.
            else if (!flower && stack.is(SVTPBlocks.DEAD_FLOWER.get().asItem()))
                flower = true;
            else
                return false;
        }

        return redMushroom && brownMushroom && bowl && flower;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return SVTPRecipeSerializers.SVTP_SUSPICIOUS_STEW.get();
    }
}
