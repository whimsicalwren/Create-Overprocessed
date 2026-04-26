package dev.wren.createoverprocessed.internal.data.recipe;

import dev.wren.createoverprocessed.content.recipes.SeethingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class COSeethingRecipeGen extends FanRecipeGenHelper<SeethingRecipe> {
    public COSeethingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    GeneratedRecipe
            NETHERITE_SCRAP = extraWithChance("netherite_scrap", Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP, .15f)
    ;

    @Override
    protected @NotNull CORecipeTypes getRecipeType() {
        return CORecipeTypes.SEETHING;
    }
}
