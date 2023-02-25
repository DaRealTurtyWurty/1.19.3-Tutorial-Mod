package dev.turtywurty.tutorialmod.util.tags;

import dev.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> EXAMPLE_TOOL = BlockTags.create(
            new ResourceLocation(TutorialMod.MODID, "needs_example_tool"));
}
