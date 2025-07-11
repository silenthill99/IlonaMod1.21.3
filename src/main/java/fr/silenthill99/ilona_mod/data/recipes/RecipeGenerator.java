package fr.silenthill99.ilona_mod.data.recipes;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModBlocks;
import fr.silenthill99.ilona_mod.init.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider {
    protected RecipeGenerator(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ILONITE_ORE), RecipeCategory.MISC, new ItemStack(ModItems.ILONITE.get()), 0.8f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ILONITE_ORE))
                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(Main.MODID, "ilonite_smelting")));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.ILONITE_ORE), RecipeCategory.MISC, new ItemStack(ModItems.ILONITE.get()).getItem(),
                0.8f, 100)
                        .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ILONITE_ORE))
                                .save(output, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(Main.MODID, "ilonite_blasting")));

        HolderLookup.RegistryLookup<Item> items = this.registries.lookupOrThrow(Registries.ITEM);
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, new ItemStack(ModBlocks.ILONITE_BLOCK.get()))
                .requires(ModItems.ILONITE, 9)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ILONITE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, new ItemStack(ModItems.ILONITE.get()).getItem(), 9)
                .requires(ModBlocks.ILONITE_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ILONITE_BLOCK))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModBlocks.ILONITE_STAIRS.get()).getItem(), 4)
                .pattern("0  ")
                .pattern("00 ")
                .pattern("000")
                .define('0', ModBlocks.ILONITE_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ILONITE_BLOCK))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModBlocks.ILONITE_FENCE.get()).getItem(), 3)
                .pattern("010")
                .pattern("010")
                .define('0', ModBlocks.ILONITE_BLOCK)
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ILONITE_BLOCK, Items.STICK))
                .save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, new ItemStack(ModItems.ILONITE_PICKAXE.get()))
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .define('0', ModItems.ILONITE)
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ILONITE, Items.STICK))
                .save(output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
            return new RecipeGenerator(provider, recipeOutput);
        }

        @Override
        public @NotNull String getName() {
            return "";
        }
    }
}
