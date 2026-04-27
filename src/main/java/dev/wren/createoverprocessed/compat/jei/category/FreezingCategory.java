package dev.wren.createoverprocessed.compat.jei.category;

import dev.wren.createoverprocessed.compat.jei.category.helper.FanCategoryHelper;
import dev.wren.createoverprocessed.content.recipes.FreezingRecipe;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class FreezingCategory extends FanCategoryHelper<FreezingRecipe> {
    public FreezingCategory(Info<FreezingRecipe> info) {
        super(info, false);
    }

    @Override
    protected GuiGameElement.@NotNull GuiRenderBuilder getBaseBuilder() {
        return GuiGameElement.of(Blocks.POWDER_SNOW.defaultBlockState());
    }
}
