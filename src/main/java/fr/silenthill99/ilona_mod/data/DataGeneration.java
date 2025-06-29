package fr.silenthill99.ilona_mod.data;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.ModSoundEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Main.MODID)
public class DataGeneration {
    public static final ResourceKey<DamageType> EXAMPLE_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Main.MODID, "example"));

    @SubscribeEvent // on the mod event bus
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
//        CompletableFuture<HolderLookup.Provider> lookupProvider = generator.addProvider(
//                event.includeServer(),
//                new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), new RegistrySetBuilder()
//                        .add(Registries.JUKEBOX_SONG, bootstrap -> {
//                            bootstrap.register(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.DANS_MA_FUSEE), new JukeboxSong(
//                                    ModSoundEvents.DANS_MA_FUSEE,
//                                    Component.translatable("songs.dans_ma_fusee"),
//                                    233,
//                                    0
//                            ));
//                        }),
//                        Set.of(Main.MODID)
//                )
//        ).getRegistryProvider();

//        generator.addProvider(event.includeClient(), new SoundDefinitionGenerator(packOutput, existingFileHelper));
    }
}
