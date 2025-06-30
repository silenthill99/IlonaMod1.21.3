package fr.silenthill99.ilona_mod.utils;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Main.MODID);

    public static final Supplier<CreativeModeTab> UN_MONDE_PARFAIT = CREATIVE_TABS.register(
            "un_monde_parfait", ()-> CreativeModeTab
                    .builder()
                    .icon(() -> new ItemStack(ModItems.ALBUM_UMP.get()))
                    .title(Component.translatable("itemGroup.un_monde_parfait"))
                    .displayItems((input, output) -> {
                        output.accept(ModItems.ALBUM_UMP);
                    })
                    .build()
    );
}
