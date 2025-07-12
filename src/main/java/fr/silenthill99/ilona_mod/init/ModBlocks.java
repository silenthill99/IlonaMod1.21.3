package fr.silenthill99.ilona_mod.init;

import fr.silenthill99.ilona_mod.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);

    public static final DeferredBlock<Block> ILONITE_BLOCK = registerBlock("ilonite_block",
            (properties) -> new Block(
                    properties.mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .strength(5, 10)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)
            ));

    public static final DeferredBlock<Block> ILONITE_ORE = registerBlock("ilonite_ore",
            (properties) -> new Block(
                    properties.mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .sound(SoundType.METAL)
                            .strength(3, 5)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<StairBlock> ILONITE_STAIRS = registerBlock("ilonite_stairs",
            (properties) -> new StairBlock(ModBlocks.ILONITE_BLOCK.get().defaultBlockState(),
                    properties
                            .mapColor(MapColor.METAL)
                            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .strength(5, 10)
                            .sound(SoundType.METAL)
            ));

    public static final DeferredBlock<FenceBlock> ILONITE_FENCE = registerBlock("ilonite_fence",
            (properties) -> new FenceBlock(
                    properties
                            .mapColor(MapColor.METAL)
                            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                            .strength(5, 10)
                            .sound(SoundType.METAL)
            ));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, function);
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(),
                properties.useBlockDescriptionPrefix()
        ));
        return block;
    }
}
