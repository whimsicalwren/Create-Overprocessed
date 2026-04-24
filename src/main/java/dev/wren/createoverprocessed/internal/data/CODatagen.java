package dev.wren.createoverprocessed.internal.data;

import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.internal.data.recipe.CORecipeProvider;
import dev.wren.createoverprocessed.internal.data.tag.COBlockTagProvider;
import dev.wren.createoverprocessed.internal.data.tag.COFluidTagProvider;
import dev.wren.createoverprocessed.internal.data.tag.COItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class CODatagen {
    public static void gatherData(GatherDataEvent event) {
        if (!event.getMods().contains(COverprocessed.MODID)) return;
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeServer()) CORecipeProvider.registerFanRecipes(generator, output, lookupProvider);
        generator.addProvider(event.includeServer(), new COBlockTagProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new COFluidTagProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new COItemTagProvider(output, lookupProvider, existingFileHelper));
    }
}
