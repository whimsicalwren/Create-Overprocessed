package dev.wren.createoverprocessed.internal.data.recipe;

import dev.wren.createoverprocessed.content.recipes.WitheringRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class COWitheringRecipeGen extends FanRecipeGenHelper<WitheringRecipe> {
    public COWitheringRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CORecipeTypes.WITHERING);
    }

    GeneratedRecipe
            WITHER_ROSE = tagToItemConvert("wither_rose", ItemTags.SMALL_FLOWERS, Items.WITHER_ROSE),
            WITHER_SKELETON_SKULL = convert("wither_skeleton_skull", Items.SKELETON_SKULL, Items.WITHER_SKELETON_SKULL, .001f)
    ;
}
