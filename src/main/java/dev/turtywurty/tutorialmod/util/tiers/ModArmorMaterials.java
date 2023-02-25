package dev.turtywurty.tutorialmod.util.tiers;

import dev.turtywurty.tutorialmod.init.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class ModArmorMaterials {
    public static final ModArmorMaterial EXAMPLE = new ModArmorMaterial(new int[]{400, 600, 1200, 500},
            new int[]{13, 15, 16, 11}, 320, SoundEvents.CROP_BREAK, () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()),
            "example", 0.25f, 0.0f);
}
