package fr.silenthill99.ilona_mod.data;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.data.loot_tables.LootTableGenerator;
import fr.silenthill99.ilona_mod.data.models.ModelGenerator;
import fr.silenthill99.ilona_mod.data.recipes.RecipeGenerator;
import fr.silenthill99.ilona_mod.data.sounds.SoundDefinitionGenerator;
import fr.silenthill99.ilona_mod.data.tags.BlockTagsGenerator;
import fr.silenthill99.ilona_mod.data.tags.ItemTagsGenerator;
import fr.silenthill99.ilona_mod.utils.ModSoundEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Main.MODID)
public class DataGeneration {
    @SubscribeEvent // on the mod event bus
    public static void onGatherData(GatherDataEvent.Client event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.createDatapackRegistryObjects(
                new RegistrySetBuilder()
                        .add(Registries.JUKEBOX_SONG, bootstrap -> {
                            bootstrap.register(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.UN_MONDE_PARFAIT.get()), new JukeboxSong(
                                    ModSoundEvents.UN_MONDE_PARFAIT,
                                    Component.translatable("ilona_mod.sounds.un_monde_parfait"),
                                    186,
                                    0
                            ));
                            bootstrap.register(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.CEST_LES_VACANCES.get()), new JukeboxSong(
                                    ModSoundEvents.CEST_LES_VACANCES,
                                    Component.translatable("ilona_mod.sounds.cest_les_vacances"),
                                    229,
                                    0
                            ));
                        })
        );

        // Client
        generator.addProvider(true, new SoundDefinitionGenerator(packOutput));
        generator.addProvider(true, new ModelGenerator(packOutput));

        // Serveur
        generator.addProvider(true, new BlockTagsGenerator(packOutput, lookupProvider));
        generator.addProvider(true, new ItemTagsGenerator(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableGenerator(packOutput, lookupProvider));
        generator.addProvider(true, new RecipeGenerator.Runner(packOutput, lookupProvider));
    }
}
