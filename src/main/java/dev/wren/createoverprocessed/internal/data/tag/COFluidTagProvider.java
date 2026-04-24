package dev.wren.createoverprocessed.internal.data.tag;

import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.index.COTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class COFluidTagProvider extends TagsProvider<Fluid> {
    public COFluidTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, Registries.FLUID, lookupProvider, COverprocessed.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(COTags.COFluidTags.HONEYING_CATALYST.tag).addTag(Tags.Fluids.HONEY);
    }

    @SuppressWarnings("deprecation")
    public List<ResourceKey<Fluid>> keys(Fluid... fluids) {
        return Arrays.stream(fluids).map(fluid -> fluid.builtInRegistryHolder().key()).toList();
    }
}
