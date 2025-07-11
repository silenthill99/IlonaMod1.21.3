package fr.silenthill99.ilona_mod.init;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.utils.ModSoundEvents;
import fr.silenthill99.ilona_mod.utils.ModToolMaterial;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);

    public static final DeferredItem<Item> ALBUM_UMP = ITEMS.registerItem("album_ump", Item::new);

    public static final DeferredItem<Item> UN_MONDE_PARFAIT = ITEMS.registerItem("un_monde_parfait",
            properties -> new Item(
                    properties
                            .stacksTo(1)
                            .jukeboxPlayable(ModSoundEvents.convertToJukeboxSong("un_monde_parfait"))
            ));

    public static final DeferredItem<Item> ILONITE = ITEMS.registerItem("ilonite", Item::new);

    public static final DeferredItem<Item> ILONITE_PICKAXE = ITEMS.registerItem("ilonite_pickaxe",
            properties -> new PickaxeItem(ModToolMaterial.ILONITE_TOOLS, 1, -2.8f, properties));
}