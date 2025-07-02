package fr.silenthill99.ilona_mod.data.models;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.ILONITE_BLOCK.get(), models().cubeAll("ilonite_block", blockTexture(ModBlocks.ILONITE_BLOCK.get())));
    }
}
