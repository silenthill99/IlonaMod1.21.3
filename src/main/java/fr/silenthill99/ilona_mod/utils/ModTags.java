package fr.silenthill99.ilona_mod.utils;

import fr.silenthill99.ilona_mod.Main;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class ModBlockTags {

        public static final TagKey<Block> NEEDS_ILONITE_TOOL = createTag("needs_ilonite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ILONITE_TOOL = createTag("incorrect_for_ilonite_tool");

        public static TagKey<Block> createTag(String name) {
            return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
        }
    }

    public static class ModItemTags {
        public static final TagKey<Item> ILONITES = createTag("ilonites");

        public static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
        }
    }
}
