package dev.wren.createoverprocessed.compat.jei.category;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import dev.wren.createoverprocessed.compat.jei.category.helper.FanCategoryHelper;
import dev.wren.createoverprocessed.content.recipes.SeethingRecipe;
import net.createmod.catnip.gui.element.GuiGameElement;
import org.jetbrains.annotations.NotNull;

public class SeethingCategory extends FanCategoryHelper<SeethingRecipe> {
    public SeethingCategory(Info<SeethingRecipe> info) {
        super(info, true);
    }

    @Override
    protected GuiGameElement.@NotNull GuiRenderBuilder getBaseBuilder() {
        return GuiGameElement.of(AllBlocks.BLAZE_BURNER.getDefaultState().setValue(BlazeBurnerBlock.HEAT_LEVEL, BlazeBurnerBlock.HeatLevel.SEETHING));
    }
}
