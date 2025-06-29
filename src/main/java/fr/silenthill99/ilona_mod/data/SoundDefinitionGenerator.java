package fr.silenthill99.ilona_mod.data;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class SoundDefinitionGenerator extends SoundDefinitionsProvider {
    protected SoundDefinitionGenerator(PackOutput output, ExistingFileHelper helper) {
        super(output, Main.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSoundEvents.DANS_MA_FUSEE, SoundDefinition.definition()
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "03_dans_ma_fusee"))));
    }
}
