package dev.wren.createoverprocessed.internal.data.recipe;

import com.simibubi.create.AllItems;
import dev.wren.createoverprocessed.content.recipes.StickyingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class COStickyingRecipeGen extends FanRecipeGenHelper<StickyingRecipe> {
    public COStickyingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CORecipeTypes.STICKYING);
    }

    GeneratedRecipe
            SLIME_BALL = convert("slime_ball", AllItems.DOUGH, Items.SLIME_BALL)
    ;

}
