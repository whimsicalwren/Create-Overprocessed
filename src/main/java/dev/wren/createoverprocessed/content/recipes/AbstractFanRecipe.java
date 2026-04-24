package dev.wren.createoverprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public abstract class AbstractFanRecipe extends StandardProcessingRecipe<SingleRecipeInput> {
    public AbstractFanRecipe(IRecipeTypeInfo typeInfo, ProcessingRecipeParams params) {
        super(typeInfo, params);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        if (input.isEmpty()) return false;
        return ingredients.getFirst().test(input.getItem(0));
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 12;
    }
}
