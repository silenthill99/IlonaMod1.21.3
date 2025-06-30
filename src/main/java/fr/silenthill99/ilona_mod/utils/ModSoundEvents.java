package fr.silenthill99.ilona_mod.utils;

import fr.silenthill99.ilona_mod.Main;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("DataFlowIssue")
public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Main.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> UN_MONDE_PARFAIT = registerSound("un_monde_parfait");

    public static ResourceKey<JukeboxSong> convertToJukeboxSong(DeferredHolder<SoundEvent, SoundEvent> sound) {
        String name = BuiltInRegistries.SOUND_EVENT.getKey(sound.get()).getPath();
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
    }

    public static DeferredHolder<SoundEvent, SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, SoundEvent::createVariableRangeEvent);
    }
}
