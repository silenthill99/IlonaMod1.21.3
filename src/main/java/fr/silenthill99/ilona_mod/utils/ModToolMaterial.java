package fr.silenthill99.ilona_mod.utils;

import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.Tags;

public class ModToolMaterial {

//    public static final ToolMaterial ILONITE_TOOLS = new ToolMaterial(ModTags.ModBlockTags.INCORRECT_FOR_ILONITE_TOOL, 200, 10, 400, 2, ModTags.ModItemTags.ILONITES);

    // We place copper somewhere between stone and iron.
    public static final ToolMaterial COPPER_MATERIAL = new ToolMaterial(
            // The tag that determines what blocks this material cannot break. See below for more information.
            ModTags.ModBlockTags.INCORRECT_FOR_COPPER_TOOL,
            // Determines the durability of the material.
            // Stone is 131, iron is 250.
            200,
            // Determines the mining speed of the material. Unused by swords.
            // Stone uses 4, iron uses 6.
            5f,
            // Determines the attack damage bonus. Different tools use this differently. For example, swords do (getAttackDamageBonus() + 4) damage.
            // Stone uses 1, iron uses 2, corresponding to 5 and 6 attack damage for swords, respectively; our sword does 5.5 damage now.
            1.5f,
            // Determines the enchantability of the material. This represents how good the enchantments on this tool will be.
            // Gold uses 22, we put copper slightly below that.
            20,
            // The tag that determines what items can repair this material.
            Tags.Items.INGOTS_COPPER
    );

}
