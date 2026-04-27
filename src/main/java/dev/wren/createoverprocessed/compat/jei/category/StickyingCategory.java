package dev.wren.createoverprocessed.compat.jei.category;

import dev.wren.createoverprocessed.compat.jei.category.helper.FanCategoryHelper;
import dev.wren.createoverprocessed.content.recipes.StickyingRecipe;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class StickyingCategory extends FanCategoryHelper<StickyingRecipe> {
    public StickyingCategory(Info<StickyingRecipe> info) {
        super(info, false);
    }

    @Override
    protected GuiGameElement.@NotNull GuiRenderBuilder getBaseBuilder() {
        return GuiGameElement.of(Blocks.SLIME_BLOCK.defaultBlockState());
    }
}
