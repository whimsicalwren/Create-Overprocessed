package dev.wren.exampleaddon.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class AddonServer extends ConfigBase {

    public final ConfigGroup server = group(0, "server", Comments.server);

    public final AddonStress stressValues = nested(1, AddonStress::new, Comments.stress);


    private static class Comments {
        public static final String server = "Serverside config.";
        public static final String stress = "Stress values.";
    }

    @Override
    public @NotNull String getName() {
        return "server";
    }

}
