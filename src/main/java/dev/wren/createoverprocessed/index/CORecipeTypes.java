package dev.wren.createoverprocessed.index;

import com.mojang.serialization.Codec;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.content.recipes.*;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public enum CORecipeTypes implements IRecipeTypeInfo, StringRepresentable {
    DRAGON_BREATHING(DragonBreathingRecipe::new),
    FREEZING(FreezingRecipe::new),
    HONEYING(HoneyingRecipe::new),
    SANDING(SandingRecipe::new),
    SEETHING(SeethingRecipe::new),
    STICKYING(StickyingRecipe::new),
    WITHERING(WitheringRecipe::new)
    ;

    public final ResourceLocation id;
    public final Supplier<RecipeSerializer<?>> serializerSupplier;
    private final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializerObject;
    private final DeferredHolder<RecipeType<?>, RecipeType<?>> typeObject;
    private final Supplier<RecipeType<?>> type;

    public static final Codec<CORecipeTypes> codec = StringRepresentable.fromEnum(CORecipeTypes::values);

    CORecipeTypes(StandardProcessingRecipe.Factory<?> processingFactory) {
        final Supplier<RecipeSerializer<?>> factorySerializerSupplier = () -> new StandardProcessingRecipe.Serializer<>(processingFactory);
        String name = Lang.asId(name());
        id = COverprocessed.asResource(name);
        this.serializerSupplier = factorySerializerSupplier;
        serializerObject = Registers.SERIALIZER_REGISTER.register(name, factorySerializerSupplier);
        typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
        type = typeObject;
    }

    @ApiStatus.Internal
    public static void register(IEventBus modEventBus) {
        ShapedRecipePattern.setCraftingSize(9, 9);
        Registers.SERIALIZER_REGISTER.register(modEventBus);
        Registers.TYPE_REGISTER.register(modEventBus);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject.get();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    public <I extends RecipeInput, R extends Recipe<I>> Optional<RecipeHolder<R>> find(I inv, Level level) {
        return level.getRecipeManager().getRecipeFor(getType(), inv, level);
    }

    @Override
    public @NotNull String getSerializedName() {
        return id.toString();
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, COverprocessed.MODID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, COverprocessed.MODID);
    }
}
