package dev.wren.createoverprocessed.compat.jei.category.helper;

import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public abstract class FanCategoryHelper<T extends StandardProcessingRecipe<?>> extends ProcessingViaFanCategory.MultiOutput<T> {

    private final boolean light;

    public FanCategoryHelper(Info<T> info, boolean light) {
        super(info);
        this.light = light;
    }

    @Override
    protected AllGuiTextures getBlockShadow() {
        return light ? AllGuiTextures.JEI_LIGHT : AllGuiTextures.JEI_SHADOW;
    }

    protected final void defaultRender(GuiGameElement.GuiRenderBuilder renderBuilder, GuiGraphics graphics) {
        renderBuilder.scale(SCALE).atLocal(0, 0, 2).lighting(AnimatedKinetics.DEFAULT_LIGHTING).render(graphics);
    }

    protected abstract @NotNull GuiGameElement.GuiRenderBuilder getBaseBuilder();


    @Override
    protected final void renderAttachedBlock(GuiGraphics graphics) {
       defaultRender(getBaseBuilder(), graphics);
    }
}
