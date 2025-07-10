package fr.silenthill99.ilona_mod.data.tags;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModBlocks;
import fr.silenthill99.ilona_mod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.ILONITE_STAIRS.get()
        );

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.ILONITE_BLOCK.get(),
                ModBlocks.ILONITE_STAIRS.get()
        );

        tag(BlockTags.FENCES).add(
                ModBlocks.ILONITE_FENCE.get()
        );

        tag(ModTags.ModBlockTags.NEEDS_COPPER_TOOL).add(
                ModBlocks.ILONITE_BLOCK.get()
        ).addTag(BlockTags.NEEDS_STONE_TOOL);

        tag(ModTags.ModBlockTags.INCORRECT_FOR_COPPER_TOOL).addTag(
                BlockTags.INCORRECT_FOR_STONE_TOOL
        ).remove(ModTags.ModBlockTags.NEEDS_COPPER_TOOL);
    }
}
