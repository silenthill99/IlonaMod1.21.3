package fr.silenthill99.ilona_mod.data;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.data.loot_tables.LootTableGenerator;
import fr.silenthill99.ilona_mod.data.models.BlockStateGenerator;
import fr.silenthill99.ilona_mod.data.models.ItemModelGenerator;
import fr.silenthill99.ilona_mod.data.recipes.RecipeGenerator;
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
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Main.MODID)
public class DataGeneration {
    @SubscribeEvent // on the mod event bus
    public static void onGatherData(GatherDataEvent event) {
        boolean client = event.includeClient();
        boolean server = event.includeServer();

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = generator.addProvider(
                server,
                new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), new RegistrySetBuilder()
                        .add(Registries.JUKEBOX_SONG, bootstrap -> {
                            bootstrap.register(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.UN_MONDE_PARFAIT), new JukeboxSong(
                                    ModSoundEvents.UN_MONDE_PARFAIT,
                                    Component.translatable("ilona_mod.sounds.un_monde_parfait"),
                                    186,
                                    0
                            ));
                        }),
                        Set.of(Main.MODID)
                )
        ).getRegistryProvider();

        generator.addProvider(client, new SoundDefinitionGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new ItemModelGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new BlockStateGenerator(packOutput, existingFileHelper));

        BlockTagsGenerator blockTagsGenerator = generator.addProvider(server, new BlockTagsGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ItemTagsGenerator(packOutput, lookupProvider, blockTagsGenerator.contentsGetter()));
        generator.addProvider(server, new LootTableGenerator(packOutput, lookupProvider));
        generator.addProvider(server, new RecipeGenerator.Runner(packOutput, lookupProvider));
    }
}
