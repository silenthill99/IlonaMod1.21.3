package fr.silenthill99.ilona_mod.data.models;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModBlocks;
import fr.silenthill99.ilona_mod.init.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

public class ModelGenerator extends ModelProvider {


    Item[] CD = {
            ModItems.UN_MONDE_PARFAIT.get(),
            ModItems.CEST_LES_VACANCES.get()
    };

    public ModelGenerator(PackOutput output) {
        super(output, Main.MODID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
        flatItemWithTexture(itemModels, ModItems.ALBUM_UMP.get(), Identifier.fromNamespaceAndPath(Main.MODID, "item/un_monde_parfait"));
        for (Item item : CD) {
            flatItemWithTexture(itemModels, item, Identifier.fromNamespaceAndPath(Main.MODID, "item/cd"));
        }
        itemModels.generateFlatItem(ModItems.ILONITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ILONITE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        blockModels.createTrivialCube(ModBlocks.ILONITE_ORE.get());
        blockModels.family(ModBlocks.ILONITE_BLOCK.get())
                .stairs(ModBlocks.ILONITE_STAIRS.get())
                .fence(ModBlocks.ILONITE_FENCE.get());
    }

    private void flatItemWithTexture(ItemModelGenerators itemModels, Item item, Identifier texture) {
        Identifier model = ModelTemplates.FLAT_ITEM.create(
                ModelLocationUtils.getModelLocation(item),
                TextureMapping.layer0(texture),
                itemModels.modelOutput
        );
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(model));
    }
}
