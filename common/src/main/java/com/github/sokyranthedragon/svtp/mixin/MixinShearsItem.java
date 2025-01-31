package com.github.sokyranthedragon.svtp.mixin;

import com.github.sokyranthedragon.svtp.tags.SVTPBlockTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ShearsItem.class)
public class MixinShearsItem
{
    @ModifyReturnValue(method = "createToolProperties", at = @At("RETURN"))
    private static Tool modifyShearProperties(Tool original)
    {
        // Get a copy of the original rules list
        var originalList = new ArrayList<>(original.rules());
        // Insert our own rule
        originalList.add(Tool.Rule.overrideSpeed(SVTPBlockTags.PAPER_BUNDLES, 5f));
        // Make a new immutable list
        var newList = List.copyOf(originalList);

        // Return a new tool with identical damage per block and mine speed, but our extra rules list
        return new Tool(newList, original.defaultMiningSpeed(), original.damagePerBlock());
    }

    @Inject(method = "mineBlock", at = @At(value = "RETURN"), cancellable = true)
    private void injectMineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir)
    {
        if (!cir.getReturnValueZ() && blockState.is(SVTPBlockTags.PAPER_BUNDLES))
            cir.setReturnValue(true);
    }
}