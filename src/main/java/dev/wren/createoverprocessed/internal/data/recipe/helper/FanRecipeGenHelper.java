package dev.wren.createoverprocessed.internal.data.recipe.helper;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public abstract class FanRecipeGenHelper<T extends StandardProcessingRecipe<?>> extends StandardProcessingRecipeGen<T> {
    public FanRecipeGenHelper(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, COverprocessed.MODID);
    }

    protected GeneratedRecipe tagToItemConvert(String name, TagKey<Item> itemTag, ItemLike output) {
        return create(name, b -> b.require(itemTag).output(output));
    }

    protected GeneratedRecipe convert(String name, ItemLike input, ItemLike output) {
        return create(name, b -> b.require(input).output(output));
    }

    protected GeneratedRecipe convert(String name, ItemLike input, ItemLike output, float chance) {
        return create(name, b -> b.require(input).output(chance, output));
    }

    protected GeneratedRecipe extraWithChance(String name, ItemLike input, ItemLike output, float secondChance) {
        return create(name, b -> b.require(input).output(output).output(secondChance, output));
    }

    @Override
    protected abstract @NotNull CORecipeTypes getRecipeType();
}
