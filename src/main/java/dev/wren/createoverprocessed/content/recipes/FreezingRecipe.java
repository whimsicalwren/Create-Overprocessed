package dev.wren.createoverprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import dev.wren.createoverprocessed.index.CORecipeTypes;

public class FreezingRecipe extends AbstractFanRecipe {
    public FreezingRecipe(ProcessingRecipeParams params) {
        super(CORecipeTypes.FREEZING, params);
    }
}
