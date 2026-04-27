package dev.wren.createoverprocessed.internal.data.recipe;

import com.simibubi.create.AllItems;
import dev.wren.createoverprocessed.content.recipes.SandingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class COSandingRecipeGen extends FanRecipeGenHelper<SandingRecipe> {
    public COSandingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CORecipeTypes.SANDING);
    }

    GeneratedRecipe
        POLISHED_ROSE_QUARTZ = convert("polished_rose_quartz", AllItems.ROSE_QUARTZ, AllItems.POLISHED_ROSE_QUARTZ)
    ;
}
