package dev.wren.createoverprocessed.index;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.content.fantypes.*;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.minecraft.core.Registry;
import org.jetbrains.annotations.ApiStatus;

public class COFanTypes {

    public static final DragonBreathingFanType DRAGON_BREATHING = fanType("dragon_breathing", new DragonBreathingFanType());
    public static final FreezingFanType FREEZING = fanType("freezing", new FreezingFanType());
    public static final HoneyingFanType HONEYING = fanType("honeying", new HoneyingFanType());
    public static final SandingFanType SANDING = fanType("sanding", new SandingFanType());
    public static final SeethingFanType SEETHING = fanType("seething", new SeethingFanType());
    public static final StickyingFanType STICKYING = fanType("stickying", new StickyingFanType());
    public static final WitheringFanType WITHERING = fanType("withering", new WitheringFanType());

    private static <T extends FanProcessingType> T fanType(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, COverprocessed.asResource(name), type);
    }

    static {
        Object2ReferenceOpenHashMap<String, FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("DRAGON_BREATHING", DRAGON_BREATHING);
        map.put("FREEZING", FREEZING);
        map.put("HONEYING", HONEYING);
        map.put("SANDING", SANDING);
        map.put("SEETHING", SEETHING);
        map.put("STICKYING", STICKYING);
        map.put("WITHERING", WITHERING);
        map.trim();
    }

    @ApiStatus.Internal
    public static void register() {}

}
