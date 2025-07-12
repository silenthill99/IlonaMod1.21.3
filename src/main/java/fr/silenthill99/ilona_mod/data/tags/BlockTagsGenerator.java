package fr.silenthill99.ilona_mod.data.tags;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModBlocks;
import fr.silenthill99.ilona_mod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.ILONITE_BLOCK.get(),
                ModBlocks.ILONITE_ORE.get()
        );

        tag(Tags.Blocks.NEEDS_WOOD_TOOL);
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).remove(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(ModBlocks.ILONITE_BLOCK.get());

        tag(Tags.Blocks.NEEDS_GOLD_TOOL);
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .remove(Tags.Blocks.NEEDS_WOOD_TOOL);

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .remove(BlockTags.NEEDS_STONE_TOOL);

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(BlockTags.NEEDS_IRON_TOOL);
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.ILONITE_BLOCK.get(),
                ModBlocks.ILONITE_ORE.get()
        );

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        tag(ModTags.ModBlockTags.NEEDS_ILONITE_TOOL);
        tag(ModTags.ModBlockTags.INCORRECT_FOR_ILONITE_TOOL).addTag(
                BlockTags.INCORRECT_FOR_NETHERITE_TOOL
        ).remove(
                ModTags.ModBlockTags.NEEDS_ILONITE_TOOL
        );

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).addTag(
                ModTags.ModBlockTags.NEEDS_ILONITE_TOOL
        );

        tag(BlockTags.FENCES).add(
                ModBlocks.ILONITE_FENCE.get()
        );
    }
}
