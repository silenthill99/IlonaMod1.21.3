package fr.silenthill99.ilona_mod.init;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.utils.ModSoundEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Main.MODID);

    public static final DeferredItem<Item> ALBUM_UMP = (DeferredItem<Item>) ITEMS.register("album_ump",
            output -> new Item(
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, output))
            )
    );

    public static final DeferredItem<Item> UN_MONDE_PARFAIT = (DeferredItem<Item>) ITEMS.register("un_monde_parfait",
            output -> new Item(
                    new Item.Properties()
                            .stacksTo(1)
                            .jukeboxPlayable(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.UN_MONDE_PARFAIT))
                            .setId(ResourceKey.create(Registries.ITEM, output))
            ));
}
