package dev.wren.createoverprocessed.internal.data.tag;

import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.index.COTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class COItemTagProvider extends TagsProvider<Item> {

    public COItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, Registries.ITEM, lookupProvider, COverprocessed.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(COTags.COItemTags.NORMAL_BRICK_BLOCKS.tag).addAll(keys(Items.STONE_BRICKS, Items.DEEPSLATE_BRICKS,
                Items.POLISHED_BLACKSTONE_BRICKS, Items.TUFF_BRICKS, Items.MOSSY_STONE_BRICKS, Items.MUD_BRICKS));

        tag(COTags.COItemTags.NORMAL_BRICK_WALLS.tag).addAll(keys(Items.STONE_BRICK_WALL, Items.DEEPSLATE_BRICK_WALL,
                Items.POLISHED_BLACKSTONE_BRICK_WALL, Items.TUFF_BRICK_WALL, Items.MOSSY_STONE_BRICK_WALL, Items.MUD_BRICK_WALL));

        tag(COTags.COItemTags.NORMAL_BRICK_SLABS.tag).addAll(keys(Items.STONE_BRICK_SLAB, Items.DEEPSLATE_BRICK_SLAB,
                Items.POLISHED_BLACKSTONE_BRICK_SLAB, Items.TUFF_BRICK_SLAB, Items.MOSSY_STONE_BRICK_SLAB, Items.MUD_BRICK_SLAB));

        tag(COTags.COItemTags.NORMAL_BRICK_STAIRS.tag).addAll(keys(Items.STONE_BRICK_STAIRS, Items.DEEPSLATE_BRICK_STAIRS,
                Items.POLISHED_BLACKSTONE_BRICK_STAIRS, Items.TUFF_BRICK_STAIRS, Items.MOSSY_STONE_BRICK_STAIRS, Items.MUD_BRICK_STAIRS));
    }

    @SuppressWarnings("deprecation")
    public List<ResourceKey<Item>> keys(Item... items) {
        return Arrays.stream(items).map(item -> item.builtInRegistryHolder().key()).toList();
    }
}
