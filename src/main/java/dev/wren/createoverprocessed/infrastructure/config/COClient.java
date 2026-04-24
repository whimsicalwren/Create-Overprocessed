package dev.wren.createoverprocessed.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class COClient extends ConfigBase {

    public final ConfigGroup client = group(0, "client", Comments.client);

    private static class Comments {
        public static final String client = "Clientside config.";
    }

    @Override
    public @NotNull String getName() {
        return "client";
    }
}
