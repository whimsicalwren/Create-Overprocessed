package dev.wren.createoverprocessed.index;

import com.simibubi.create.Create;
import dev.wren.createoverprocessed.COverprocessed;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.checkerframework.checker.units.qual.N;

import javax.annotation.Nullable;
import java.util.Locale;

public class COTags {

    public static <T> TagKey<T> optionalTag(Registry<T> registry, ResourceLocation id) {
        return TagKey.create(registry.key(), id);
    }
    public static <T> TagKey<T> commonTag(Registry<T> registry, String path) {
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath("c", path));
    }
    public static <T> TagKey<T> modTag(Registry<T> registry, String path) {
        return optionalTag(registry, COverprocessed.asResource(path));
    }
    public static TagKey<Fluid> commonFluidTag(String path) {
        return commonTag(BuiltInRegistries.FLUID, path);
    }
    public static TagKey<Block> commonBlockTag(String path) {
        return commonTag(BuiltInRegistries.BLOCK, path);
    }
    public static TagKey<Item> commonItemTag(String path) {
        return commonTag(BuiltInRegistries.ITEM, path);
    }
    public static TagKey<Fluid> modFluidTag(String path) {
        return modTag(BuiltInRegistries.FLUID, path);
    }
    public static TagKey<Block> modBlockTag(String path) {
        return modTag(BuiltInRegistries.BLOCK, path);
    }
    public static TagKey<Item> modItemTag(String path) {
        return modTag(BuiltInRegistries.ITEM, path);
    }

    public enum NameSpace {
        MOD(COverprocessed.MODID),
        COMMON("c"),
        CREATE(Create.ID);

        public final String id;

        NameSpace(String id) {
            this.id = id;
        }

        public ResourceLocation id(Enum<?> entry, @Nullable String pathOverride) {
            return this.id(pathOverride != null ? pathOverride : Lang.asId(entry.name()));
        }

        public ResourceLocation id(String path) {
            return ResourceLocation.fromNamespaceAndPath(this.id, path);
        }
    }

    public enum CatalystTags {
        DRAGON_BREATHING(COBlockTags.DRAGON_BREATHING_CATALYST),
        FREEZING(COBlockTags.FREEZING_CATALYST),
        HONEYING(COBlockTags.HONEYING_CATALYST),
        SANDING(COBlockTags.SANDING_CATALYST),
        SEETHING(COBlockTags.SEETHING_CATALYST),
        STICKYING(COBlockTags.STICKYING_CATALYST),
        WITHERING(COBlockTags.WITHERING_CATALYST)
        ;

        public final COBlockTags block;
        public final COFluidTags fluid;

        CatalystTags(COBlockTags blockTag) {
            this(blockTag, COFluidTags.valueOf(blockTag.name()));
        }

        CatalystTags(COBlockTags blockTag, COFluidTags fluidTag) {
            this.block = blockTag;
            this.fluid = fluidTag;
        }
    }

    public enum COItemTags {
        NORMAL_BRICK_BLOCKS(NameSpace.COMMON, "bricks/normal/blocks"),
        NORMAL_BRICK_WALLS(NameSpace.COMMON, "bricks/normal/walls"),
        NORMAL_BRICK_SLABS(NameSpace.COMMON, "bricks/normal/slabs"),
        NORMAL_BRICK_STAIRS(NameSpace.COMMON, "bricks/normal/stairs")
        ;

        public final TagKey<Item> tag;

        COItemTags() {
            this(NameSpace.MOD);
        }

        COItemTags(NameSpace namespace) {
            this(namespace, null);
        }

        COItemTags(NameSpace namespace, @Nullable String pathOverride) {
            this.tag = TagKey.create(Registries.ITEM, namespace.id(this, pathOverride));
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Item item) {
            return item.builtInRegistryHolder()
                    .is(tag);
        }

        public boolean matches(ItemStack stack) {
            return stack.is(tag);
        }
    }

    public enum COBlockTags {
        DRAGON_BREATHING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/dragon_breathing"),
        FREEZING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/freezing"),
        HONEYING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/honeying"),
        SANDING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/sanding"),
        SEETHING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/seething"),
        STICKYING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/stickying"),
        WITHERING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/withering"),
        ;

        public final TagKey<Block> tag;

        COBlockTags() {
            this(NameSpace.MOD);
        }

        COBlockTags(NameSpace namespace) {
            this(namespace, null);
        }

        COBlockTags(NameSpace namespace, @Nullable String pathOverride) {
            this.tag = TagKey.create(Registries.BLOCK, namespace.id(this, pathOverride));
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Block block) {
            return block.builtInRegistryHolder()
                    .is(tag);
        }

        public boolean matches(ItemStack stack) {
            return stack != null && stack.getItem() instanceof BlockItem blockItem && matches(blockItem.getBlock());
        }

        public boolean matches(BlockState state) {
            return state.is(tag);
        }

    }

    public enum COFluidTags {
        DRAGON_BREATHING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/dragon_breathing"),
        FREEZING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/freezing"),
        HONEYING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/honeying"),
        SANDING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/sanding"),
        SEETHING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/seething"),
        STICKYING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/stickying"),
        WITHERING_CATALYST(NameSpace.MOD, "fan_processing_catalysts/withering"),
        ;

        public final TagKey<Fluid> tag;

        COFluidTags() {
            this(NameSpace.MOD);
        }

        COFluidTags(NameSpace namespace) {
            this(namespace, null);
        }

        COFluidTags(NameSpace namespace, @Nullable String pathOverride) {
            this.tag = TagKey.create(Registries.FLUID, namespace.id(this, pathOverride));
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Fluid fluid) {
            return fluid.is(tag);
        }

        public boolean matches(FluidState state) {
            return state.is(tag);
        }
    }

}
