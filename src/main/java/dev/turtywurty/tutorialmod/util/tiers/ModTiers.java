package dev.turtywurty.tutorialmod.util.tiers;

import dev.turtywurty.tutorialmod.init.ItemInit;
import dev.turtywurty.tutorialmod.util.tags.ModBlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier EXAMPLE = new ForgeTier(4, 1800, 4.5f, 7,
            320, ModBlockTags.EXAMPLE_TOOL, () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
}
