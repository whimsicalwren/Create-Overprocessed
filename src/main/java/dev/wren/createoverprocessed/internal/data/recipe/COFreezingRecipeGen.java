package dev.wren.createoverprocessed.internal.data.recipe;

import dev.wren.createoverprocessed.content.recipes.FreezingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class COFreezingRecipeGen extends FanRecipeGenHelper<FreezingRecipe> {
    public COFreezingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CORecipeTypes.FREEZING);
    }

    GeneratedRecipe
        PACKED_ICE = convert("packed_ice", Blocks.ICE, Blocks.PACKED_ICE),
        BLUE_ICE = convert("blue_ice", Blocks.PACKED_ICE, Blocks.BLUE_ICE),
        SNOW = convert("snow", Items.SNOWBALL, Blocks.SNOW_BLOCK),
        BREEZE_ROD = convert("breeze_rod", Items.BLAZE_ROD, Items.BREEZE_ROD, .6f)
            ;
}
