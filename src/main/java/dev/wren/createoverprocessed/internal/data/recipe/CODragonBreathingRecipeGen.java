package dev.wren.createoverprocessed.internal.data.recipe;

import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.content.recipes.DragonBreathingRecipe;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.index.COTags;
import dev.wren.createoverprocessed.internal.data.recipe.helper.FanRecipeGenHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class CODragonBreathingRecipeGen extends FanRecipeGenHelper<DragonBreathingRecipe> {
    public CODragonBreathingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, COverprocessed.MODID);
    }

    GeneratedRecipe
        END_STONE = tagToItemConvert("end_stone", Tags.Items.COBBLESTONES_NORMAL, Blocks.END_STONE),
        END_STONE_BRICKS = tagToItemConvert("end_stone_bricks", COTags.COItemTags.NORMAL_BRICK_BLOCKS.tag, Blocks.END_STONE_BRICKS),
        END_STONE_BRICK_WALL = tagToItemConvert("end_stone_brick_wall", COTags.COItemTags.NORMAL_BRICK_WALLS.tag, Blocks.END_STONE_BRICKS),
        END_STONE_BRICK_SLAB = tagToItemConvert("end_stone_brick_slab", COTags.COItemTags.NORMAL_BRICK_SLABS.tag, Blocks.END_STONE_BRICK_SLAB),
        END_STONE_BRICK_STAIRS = tagToItemConvert("end_stone_brick_stairs", COTags.COItemTags.NORMAL_BRICK_STAIRS.tag, Blocks.END_STONE_BRICK_STAIRS)
    ;

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return CORecipeTypes.DRAGON_BREATHING;
    }
}
