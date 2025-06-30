package fr.silenthill99.ilona_mod.init;

import fr.silenthill99.ilona_mod.Main;
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
}
