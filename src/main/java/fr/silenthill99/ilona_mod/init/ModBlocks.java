package fr.silenthill99.ilona_mod.init;

import fr.silenthill99.ilona_mod.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Main.MODID);

    public static final DeferredBlock<Block> ILONITE_BLOCK = registerBlock("ilonite_block",
            () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                            .strength(5, 10)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Main.MODID, "ilonite_block")))
            ));

    public static final DeferredBlock<Block> ILONITE_ORE = registerBlock("ilonite_ore",
            () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                            .strength(3, 5)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Main.MODID, "ilonite_ore")))
            ));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> supplier) {
        DeferredBlock<T> block = (DeferredBlock<T>) BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, output -> new BlockItem(block.get(),
                new Item.Properties()
                        .useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, output))
        ));
        return block;
    }
}
