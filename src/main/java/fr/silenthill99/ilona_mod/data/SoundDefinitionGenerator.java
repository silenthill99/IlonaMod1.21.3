package fr.silenthill99.ilona_mod.data;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.utils.ModSoundEvents;
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
        add(ModSoundEvents.UN_MONDE_PARFAIT, SoundDefinition.definition()
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "01_un_monde_parfait"))));
        add(ModSoundEvents.CEST_LES_VACANCES, SoundDefinition.definition()
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "02_cest_les_vacances"))));
    }
}
