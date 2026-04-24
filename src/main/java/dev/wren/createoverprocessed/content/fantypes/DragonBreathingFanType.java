package dev.wren.createoverprocessed.content.fantypes;

import dev.wren.createoverprocessed.content.fantypes.helper.IProcessItemsInFrontOfAFan;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.index.COTags;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;

public class DragonBreathingFanType implements IProcessItemsInFrontOfAFan {

    @Override
    public COTags.CatalystTags getCatalystTag() {
        return COTags.CatalystTags.DRAGON_BREATHING;
    }

    @Override
    public CORecipeTypes getRecipeType() {
        return CORecipeTypes.DRAGON_BREATHING;
    }

    @Override
    public int getPriority() {
        return 1300;
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(8) != 0) return;
        level.addParticle(ParticleTypes.DRAGON_BREATH,
                pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f,
                pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        particleAccess.setColor(Color.mixColors(0xD36FD9, 0xC21BF5, random.nextFloat()));
        particleAccess.setAlpha(1f);
        if (random.nextFloat() < 1 / 128f) particleAccess.spawnExtraParticle(ParticleTypes.DRAGON_BREATH, .125f);
        if (random.nextFloat() < 1 / 32f) particleAccess.spawnExtraParticle(ParticleTypes.WITCH, .125f);

    }

    @Override
    public void affectEntity(Entity entity, Level level) { // kinda same logic as chorus fruit
        if (level.isClientSide) return;
        if (!(entity instanceof LivingEntity livingEntity)) return;

        for (int i = 0; i < 16; i++) {
            double d0 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;

            double d1 = Mth.clamp(
                    livingEntity.getY() + (double)(livingEntity.getRandom().nextInt(16) - 8),
                    level.getMinBuildHeight(),
                    (level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1)
            );

            double d2 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;

            if (livingEntity.isPassenger()) {
                livingEntity.stopRiding();
            }

            Vec3 vec3 = livingEntity.position();

            EntityTeleportEvent.ChorusFruit event = EventHooks.onChorusFruitTeleport(livingEntity, d0, d1, d2);
            if (event.isCanceled()) return;

            if (livingEntity.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(livingEntity));

                if (!livingEntity.isSilent()) {
                    level.playSound(null, livingEntity.xo, livingEntity.yo, livingEntity.zo, SoundEvents.ENDERMAN_TELEPORT, livingEntity.getSoundSource(), 1.0F, 1.0F);
                    livingEntity.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }

                livingEntity.resetFallDistance();
                break;
            }
        }
    }
}
