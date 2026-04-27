package dev.wren.createoverprocessed.internal.data.recipe.helper;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

import java.util.concurrent.CompletableFuture;

public abstract class FanRecipeGenHelper<T extends StandardProcessingRecipe<?>> extends StandardProcessingRecipeGen<T> {

    private final CORecipeTypes recipeType;

    public FanRecipeGenHelper(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, CORecipeTypes recipeType) {
        super(output, registries, COverprocessed.MODID);
        this.recipeType = recipeType;
    }

    protected GeneratedRecipe tagToItemConvert(String name, TagKey<Item> itemTag, ItemLike output) {
        return create(name, b -> b.require(itemTag).output(output));
    }

    protected GeneratedRecipe convert(String name, ItemLike input, ItemLike output) {
        return create(name, b -> b.require(input).output(output));
    }

    protected GeneratedRecipe convert(String name, Ingredient input, ItemLike output) {
        return create(name, b -> b.require(input).output(output));
    }

    protected GeneratedRecipe convert(String name, ItemLike input, ItemLike output, float chance) {
        return create(name, b -> b.require(input).output(chance, output));
    }

    protected GeneratedRecipe extraWithChance(String name, ItemLike input, ItemLike output, float secondChance) {
        return create(name, b -> b.require(input).output(output).output(secondChance, output));
    }

    protected static Ingredient waterBottle() {
        return DataComponentIngredient.of(false, DataComponentMap.builder().set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER)).build(), Items.POTION);
    }

    @Override
    public final CORecipeTypes getRecipeType() {
        return recipeType;
    }
}
