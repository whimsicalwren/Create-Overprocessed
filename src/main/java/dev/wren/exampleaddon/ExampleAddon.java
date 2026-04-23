package dev.wren.exampleaddon;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.wren.exampleaddon.infrastructure.config.ExampleAddonConfigs;
import net.createmod.catnip.lang.FontHelper;
import net.createmod.catnip.lang.LangBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ExampleAddon.MODID)
public class ExampleAddon {

    public static final String MODID = "exampleaddon";
    public static final String NAME = "Example Addon";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public ExampleAddon(IEventBus modEventBus, ModContainer container) {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        REGISTRATE.registerEventListeners(modEventBus);

        ExampleAddonConfigs.register(modLoadingContext, container);

        LOGGER.info("{} ({}) initialized!", NAME, MODID);
    }

    public static LangBuilder lang() {
        return new LangBuilder(MODID);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

}