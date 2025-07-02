package fr.silenthill99.ilona_mod.data.models;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Main.MODID, existingFileHelper);
    }

    Item[] CD = {
            ModItems.UN_MONDE_PARFAIT.get()
    };

    @Override
    protected void registerModels() {
        withExistingParent(BuiltInRegistries.ITEM.getKey(ModItems.ALBUM_UMP.get()).getPath(), "item/generated")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Main.MODID, "item/un_monde_parfait"));

        for (Item cd : CD) {
            withExistingParent(BuiltInRegistries.ITEM.getKey(cd).getPath(), "item/generated")
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(Main.MODID, "item/cd"));
        }

        basicItem(ModItems.ILONITE.get());
    }
}
