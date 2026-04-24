package dev.wren.createoverprocessed;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.wren.createoverprocessed.index.COFanTypes;
import dev.wren.createoverprocessed.index.CORecipeTypes;
import dev.wren.createoverprocessed.index.COTags;
import dev.wren.createoverprocessed.infrastructure.config.COverprocessedConfigs;
import dev.wren.createoverprocessed.internal.data.CODatagen;
import net.createmod.catnip.lang.FontHelper;
import net.createmod.catnip.lang.LangBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

@Mod(COverprocessed.MODID)
public class COverprocessed {

    public static final String MODID = "createoverprocessed";
    public static final String NAME = "Create: Overprocessed";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));

    public COverprocessed(IEventBus modEventBus, ModContainer container) {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        REGISTRATE.registerEventListeners(modEventBus);

        CORecipeTypes.register(modEventBus);

        COverprocessedConfigs.register(modLoadingContext, container); // unused rn but planned


        modEventBus.addListener(COverprocessed::onRegister);
        modEventBus.addListener(EventPriority.LOWEST, CODatagen::gatherData);

        LOGGER.info("{} ({}) initialized!", NAME, MODID);
    }

    public static void onRegister(final RegisterEvent event) {
        COFanTypes.register();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    public static LangBuilder lang() {
        return new LangBuilder(MODID);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

}