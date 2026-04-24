package dev.wren.createoverprocessed.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class COCommon extends ConfigBase {

    public final ConfigGroup common = group(0, "common", Comments.common);

    private static class Comments {
        public static final String common = "Common config.";
    }

    @Override
    public @NotNull String getName() {
        return "common";
    }
}
