package dev.wren.createoverprocessed.internal.data.recipe;

import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CORecipeProvider extends RecipeProvider {

    static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();

    public CORecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void registerFanRecipes(DataGenerator generator, PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        GENERATORS.add(new CODragonBreathingRecipeGen(output, registries));
        GENERATORS.add(new COFreezingRecipeGen(output, registries));
        GENERATORS.add(new COHoneyingRecipeGen(output, registries));
        GENERATORS.add(new COSandingRecipeGen(output, registries));
        GENERATORS.add(new COSeethingRecipeGen(output, registries));
        GENERATORS.add(new COStickyingRecipeGen(output, registries));
        GENERATORS.add(new COWitheringRecipeGen(output, registries));

        generator.addProvider(true, new DataProvider() {

            @Override
            public @NotNull String getName() {
                return "Overprocessed";
            }

            @Override
            public @NotNull CompletableFuture<?> run(CachedOutput cachedOutput) {
                return CompletableFuture.allOf(GENERATORS
                        .stream()
                        .map(gen -> gen.run(cachedOutput))
                        .toArray(CompletableFuture[]::new)
                );
            }
        });

    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {}
}
