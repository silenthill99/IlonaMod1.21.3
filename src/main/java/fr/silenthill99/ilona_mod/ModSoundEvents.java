package fr.silenthill99.ilona_mod;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Main.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> DANS_MA_FUSEE = SOUNDS.register("dans_ma_fusee",
            ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Main.MODID, "dans_ma_fusee")));

    public static ResourceKey<JukeboxSong> convertToJukeboxSong(DeferredHolder<SoundEvent, SoundEvent> sound) {
        String name = BuiltInRegistries.SOUND_EVENT.getKey(sound.get()).getPath();
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
    }
}
