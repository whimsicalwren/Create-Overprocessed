package dev.wren.createoverprocessed.compat.jei.category;

import dev.wren.createoverprocessed.compat.jei.category.helper.FanCategoryHelper;
import dev.wren.createoverprocessed.content.recipes.HoneyingRecipe;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class HoneyingCategory extends FanCategoryHelper<HoneyingRecipe> {
    public HoneyingCategory(Info<HoneyingRecipe> info) {
        super(info, false);
    }

    @Override
    protected GuiGameElement.@NotNull GuiRenderBuilder getBaseBuilder() {
        return GuiGameElement.of(Blocks.HONEY_BLOCK.defaultBlockState());
    }
}
