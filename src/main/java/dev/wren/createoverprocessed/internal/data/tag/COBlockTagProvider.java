package dev.wren.createoverprocessed.internal.data.tag;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import dev.wren.createoverprocessed.COverprocessed;
import dev.wren.createoverprocessed.index.COTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class COBlockTagProvider extends TagsProvider<Block> {
    public COBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, Registries.BLOCK, lookupProvider, COverprocessed.MODID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(COTags.COBlockTags.DRAGON_BREATHING_CATALYST.tag).addAll(keys(Blocks.DRAGON_EGG, Blocks.DRAGON_WALL_HEAD));
        tag(COTags.COBlockTags.FREEZING_CATALYST.tag).addAll(keys(Blocks.POWDER_SNOW));
        tag(COTags.COBlockTags.HONEYING_CATALYST.tag).addAll(keys(Blocks.HONEY_BLOCK));
        tag(COTags.COBlockTags.SANDING_CATALYST.tag).addTag(Tags.Blocks.SANDS).addTag(BlockTags.SAND);
        tag(COTags.COBlockTags.SEETHING_CATALYST.tag).addAll(keys(AllBlocks.BLAZE_BURNER.get()));
        tag(COTags.COBlockTags.STICKYING_CATALYST.tag).addAll(keys(Blocks.SLIME_BLOCK));
        tag(COTags.COBlockTags.WITHERING_CATALYST.tag).addAll(keys(Blocks.WITHER_SKELETON_WALL_SKULL, Blocks.WITHER_ROSE, Blocks.POTTED_WITHER_ROSE));

        tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag).addTags(
                COTags.COBlockTags.DRAGON_BREATHING_CATALYST.tag, COTags.COBlockTags.FREEZING_CATALYST.tag,
                COTags.COBlockTags.HONEYING_CATALYST.tag, COTags.COBlockTags.SANDING_CATALYST.tag,
                COTags.COBlockTags.SEETHING_CATALYST.tag, COTags.COBlockTags.STICKYING_CATALYST.tag,
                COTags.COBlockTags.WITHERING_CATALYST.tag
        );
    }

    @SuppressWarnings("deprecation")
    public List<ResourceKey<Block>> keys(Block... blocks) {
        return Arrays.stream(blocks).map(block -> block.builtInRegistryHolder().key()).toList();
    }
}
