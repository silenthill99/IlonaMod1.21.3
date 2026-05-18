package fr.silenthill99.ilona_mod.data.sounds;

import fr.silenthill99.ilona_mod.Main;
import fr.silenthill99.ilona_mod.utils.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class SoundDefinitionGenerator extends SoundDefinitionsProvider {
    public SoundDefinitionGenerator(PackOutput output) {
        super(output, Main.MODID);
    }

    @Override
    public void registerSounds() {
        add(ModSoundEvents.UN_MONDE_PARFAIT, SoundDefinition.definition()
                .with(sound(Identifier.fromNamespaceAndPath(Main.MODID, "01_un_monde_parfait"))));
        add(ModSoundEvents.CEST_LES_VACANCES, SoundDefinition.definition()
                .with(sound(Identifier.fromNamespaceAndPath(Main.MODID, "02_cest_les_vacances"))));
        add(ModSoundEvents.DANS_MA_FUSEE, SoundDefinition.definition()
                .with(sound(Identifier.fromNamespaceAndPath(Main.MODID, "03_dans_ma_fusee"))));
    }
}
