package dev.wren.createoverprocessed.internal.data.recipe;

import dev.wren.createoverprocessed.content.recipes.DragonBreathingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.index.COTags;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

import java.util.concurrent.CompletableFuture;

public class CODragonBreathingRecipeGen extends FanRecipeGenHelper<DragonBreathingRecipe> {
    public CODragonBreathingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CORecipeTypes.DRAGON_BREATHING);
    }

    GeneratedRecipe
        END_STONE = tagToItemConvert("end_stone", Tags.Items.COBBLESTONES_NORMAL, Blocks.END_STONE),
        END_STONE_BRICKS = tagToItemConvert("end_stone_bricks", COTags.COItemTags.NORMAL_BRICK_BLOCKS.tag, Blocks.END_STONE_BRICKS),
        END_STONE_BRICK_WALL = tagToItemConvert("end_stone_brick_wall", COTags.COItemTags.NORMAL_BRICK_WALLS.tag, Blocks.END_STONE_BRICKS),
        END_STONE_BRICK_SLAB = tagToItemConvert("end_stone_brick_slab", COTags.COItemTags.NORMAL_BRICK_SLABS.tag, Blocks.END_STONE_BRICK_SLAB),
        END_STONE_BRICK_STAIRS = tagToItemConvert("end_stone_brick_stairs", COTags.COItemTags.NORMAL_BRICK_STAIRS.tag, Blocks.END_STONE_BRICK_STAIRS),
        DRAGON_BREATH = convert("dragon_breath", waterBottle(), Items.DRAGON_BREATH),
        CHORUS_FRUIT = convert("chorus_fruit", Items.APPLE, Items.CHORUS_FRUIT),
        PURPUR_BLOCK = convert("purpur_block", Blocks.QUARTZ_BLOCK, Blocks.PURPUR_BLOCK),
        PURPUR_SLAB = convert("purpur_slab", Blocks.QUARTZ_SLAB, Blocks.PURPUR_SLAB),
        PURPUR_PILLAR = convert("purpur_pillar", Blocks.QUARTZ_PILLAR, Blocks.PURPUR_PILLAR),
        PURPUR_STAIRS = convert("purpur_stairs", Blocks.QUARTZ_STAIRS, Blocks.PURPUR_STAIRS)
    ;
}
