package dev.wren.createoverprocessed.content.fantypes.helper;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.index.COTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import javax.annotation.Nullable;
import java.util.List;

public interface IProcessItemsInFrontOfAFan extends FanProcessingType {

    @Override
    default boolean isValidAt(Level level, BlockPos pos) {
        FluidState fluidState = level.getFluidState(pos);
        if (getCatalystTag().fluid.matches(fluidState)) return true;
        BlockState blockState = level.getBlockState(pos);
        return getCatalystTag().block.matches(blockState);
    }

    @Override
    default boolean canProcess(ItemStack stack, Level level) {
        return getRecipeType().find(new SingleRecipeInput(stack), level).isPresent();
    }

    @Override
    default @Nullable List<ItemStack> process(ItemStack stack, Level level) {
        return getRecipeType().find(new SingleRecipeInput(stack), level)
                .map(RecipeHolder::value)
                .map(r -> RecipeApplier.applyRecipeOn(level, stack, r, true))
                .orElse(null);
    }


    COTags.CatalystTags getCatalystTag();
    CORecipeTypes getRecipeType();
}
