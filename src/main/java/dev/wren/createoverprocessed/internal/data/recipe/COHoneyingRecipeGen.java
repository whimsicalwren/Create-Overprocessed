package dev.wren.createoverprocessed.internal.data.recipe;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.content.recipes.HoneyingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class COHoneyingRecipeGen extends FanRecipeGenHelper<HoneyingRecipe> {
    public COHoneyingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    GeneratedRecipe
        HONEYED_APPLE = convert("honeyed_apple", Items.APPLE, AllItems.HONEYED_APPLE),
        SWEET_ROLL = convert("sweet_roll", Items.BREAD, AllItems.SWEET_ROLL)
    ;

    @Override
    protected @NotNull CORecipeTypes getRecipeType() {
        return CORecipeTypes.HONEYING;
    }
}
