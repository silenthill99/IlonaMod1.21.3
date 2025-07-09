package fr.silenthill99.ilona_mod.data.models;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.ILONITE_BLOCK.get(), models().cubeAll("ilonite_block", blockTexture(ModBlocks.ILONITE_BLOCK.get())));
        simpleBlockWithItem(ModBlocks.ILONITE_ORE.get(), models().cubeAll("ilonite_ore", blockTexture(ModBlocks.ILONITE_ORE.get())));
        stairsBlock(ModBlocks.ILONITE_STAIRS.get(), blockTexture(ModBlocks.ILONITE_BLOCK.get()));
        fenceBlock(ModBlocks.ILONITE_FENCE.get(), blockTexture(ModBlocks.ILONITE_BLOCK.get()));
    }

    @Override
    public void stairsBlock(@NotNull StairBlock block, @NotNull ResourceLocation texture) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        simpleBlockItem(block, models().stairs(name, texture, texture, texture));
        super.stairsBlock(block, texture);
    }

    @Override
    public void fenceBlock(@NotNull FenceBlock block, @NotNull ResourceLocation texture) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        super.fenceBlock(block, texture);
        simpleBlockItem(block, models().fenceInventory(name + "_inventory", texture));
    }
}
