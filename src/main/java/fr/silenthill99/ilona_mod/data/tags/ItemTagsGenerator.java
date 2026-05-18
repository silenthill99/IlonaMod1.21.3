package fr.silenthill99.ilona_mod.data.tags;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModItems;
import fr.silenthill99.ilona_mod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ItemTagsGenerator extends ItemTagsProvider {

    public ItemTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Main.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.ModItemTags.ILONITES).add(
                ModItems.ILONITE.get()
        );
    }
}
