package dev.wren.createoverprocessed.compat.jei;

import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.compat.jei.category.*;
import dev.wren.createoverprocessed.content.recipes.*;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class COJeiPlugin implements IModPlugin {

    private static final ResourceLocation ID = COverprocessed.asResource("jei_plugin");

    private final List<CreateRecipeCategory<?>> allCategories = new ArrayList<>();

    private void loadCategories() {
        allCategories.clear();

        CreateRecipeCategory<?>

            dragonBreathing = builder(DragonBreathingRecipe.class).easyBuild("dragon_breathing", CORecipeTypes.DRAGON_BREATHING, Items.DRAGON_BREATH, DragonBreathingCategory::new),
            freezing = builder(FreezingRecipe.class).easyBuild("freezing", CORecipeTypes.FREEZING, Items.SNOWBALL, FreezingCategory::new),
            honeying = builder(HoneyingRecipe.class).easyBuild("honeying", CORecipeTypes.HONEYING, Items.HONEY_BOTTLE, HoneyingCategory::new),
            sanding = builder(SandingRecipe.class).easyBuild("sanding", CORecipeTypes.SANDING, Items.SAND, SandingCategory::new),
            seething = builder(SeethingRecipe.class).easyBuild("seething", CORecipeTypes.SEETHING, AllItems.BLAZE_CAKE, SeethingCategory::new),
            stickying = builder(StickyingRecipe.class).easyBuild("stickying", CORecipeTypes.STICKYING, Items.SLIME_BALL, StickyingCategory::new),
            withering = builder(WitheringRecipe.class).easyBuild("withering", CORecipeTypes.WITHERING, Items.WITHER_ROSE, WitheringCategory::new);
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    private <T extends Recipe<? extends RecipeInput>> FanCategoryBuilder<T> builder(Class<T> recipeClass) {
        return new FanCategoryBuilder<>(recipeClass);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        loadCategories();
        registration.addRecipeCategories(allCategories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        allCategories.forEach(c -> c.registerRecipes(registration));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        allCategories.forEach(c -> c.registerCatalysts(registration));
    }

    private class FanCategoryBuilder<T extends Recipe<?>> extends CreateRecipeCategory.Builder<T> {
        public FanCategoryBuilder(Class<? extends T> recipeClass) {
            super(recipeClass);
        }

        public CreateRecipeCategory<T> easyBuild(String name, CORecipeTypes recipeTypes, ItemLike icon, CreateRecipeCategory.Factory<T> factory) {
            return this.addTypedRecipes(recipeTypes)
                    .catalystStack(ProcessingViaFanCategory.getFan("fan_" + name))
                    .doubleItemIcon(AllItems.PROPELLER.get(), icon)
                    .emptyBackground(178, 72)
                    .build("fan_" + name, factory);
        }

        @Override
        public @NotNull CreateRecipeCategory<T> build(ResourceLocation id, CreateRecipeCategory.Factory<T> factory) {
            CreateRecipeCategory<T> category = super.build(id, factory);
            allCategories.add(category);
            return category;
        }
    }
}
