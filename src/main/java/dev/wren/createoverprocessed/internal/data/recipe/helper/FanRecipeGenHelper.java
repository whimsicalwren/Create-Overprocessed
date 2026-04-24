package dev.wren.createoverprocessed.internal.data.recipe.helper;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import dev.wren.createoverprocessed.content.recipes.DragonBreathingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public abstract class FanRecipeGenHelper<T extends StandardProcessingRecipe<?>> extends StandardProcessingRecipeGen<T> {
    public FanRecipeGenHelper(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String defaultNamespace) {
        super(output, registries, defaultNamespace);
    }

    protected GeneratedRecipe tagToItemConvert(String name, TagKey<Item> itemTag, ItemLike output) {
        return create(name, b -> b.require(itemTag).output(output));
    }
}
