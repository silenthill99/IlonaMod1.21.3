package fr.silenthill99.ilona_mod.data;

import fr.silenthill99.ilona_mod.Main;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Main.MODID)
public class DataGeneration {
    @SubscribeEvent // on the mod event bus
    public static void onGatherData(GatherDataEvent event) {
        boolean client = event.includeClient();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(client, new SoundDefinitionGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new ItemModelGenerator(packOutput, existingFileHelper));
    }
}
