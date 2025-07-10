package fr.silenthill99.ilona_mod.init;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.utils.ModSoundEvents;
import fr.silenthill99.ilona_mod.utils.ModToolMaterial;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);

    public static final DeferredItem<Item> ALBUM_UMP = ITEMS.register("album_ump",
            output -> new Item(
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, output))
            )
    );

    public static final DeferredItem<Item> UN_MONDE_PARFAIT = ITEMS.register("un_monde_parfait",
            output -> new Item(
                    new Item.Properties()
                            .stacksTo(1)
                            .jukeboxPlayable(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.UN_MONDE_PARFAIT))
                            .setId(ResourceKey.create(Registries.ITEM, output))
            ));

    public static final DeferredItem<Item> ILONITE = ITEMS.register("ilonite",
            output -> new Item(
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, output))
            ));

    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.registerItem(
            "copper_sword",
            props -> new SwordItem(
                    ModToolMaterial.COPPER_MATERIAL,
                    3,
                    -2.4f,
                    props
            )
    );

    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.registerItem("copper_axe",
            props -> new AxeItem(
                    ModToolMaterial.COPPER_MATERIAL,
                    3,
                    -2.4f,
                    props
            ));
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.registerItem("copper_pickaxe",
            props -> new PickaxeItem(
                    ModToolMaterial.COPPER_MATERIAL,
                    1,
                    -2.4f,
                    props
            ));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.registerItem("copper_shovel",
            props -> new ShovelItem(
                    ModToolMaterial.COPPER_MATERIAL,
                    1.5f,
                    -2.4f,
                    props
            ));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.registerItem("copper_hoe",
            props -> new HoeItem(
                    ModToolMaterial.COPPER_MATERIAL,
                    -1,
                    -2.4f,
                    props
            ));
}
