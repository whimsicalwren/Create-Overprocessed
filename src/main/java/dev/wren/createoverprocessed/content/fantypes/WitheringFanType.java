package dev.wren.createoverprocessed.content.fantypes;

import dev.wren.createoverprocessed.content.fantypes.helper.IProcessItemsInFrontOfAFan;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.index.COTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WitheringFanType implements IProcessItemsInFrontOfAFan {
    @Override
    public COTags.CatalystTags getCatalystTag() {
        return COTags.CatalystTags.WITHERING;
    }

    @Override
    public CORecipeTypes getRecipeType() {
        return CORecipeTypes.WITHERING;
    }

    @Override
    public int getPriority() {
        return 1900;
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {

    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {

    }

    @Override
    public void affectEntity(Entity entity, Level level) {

    }
}
