package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            TutorialMod.MODID);

    public static final BlockWithItemHolder<Block> EXAMPLE_BLOCK = registerBlock("example_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).friction(0.5f).explosionResistance(25f).destroyTime(4.5f)
                    .requiresCorrectToolForDrops()), new Item.Properties().fireResistant().rarity(Rarity.RARE));

    private static <T extends Block> BlockWithItemHolder<T> registerBlock(String name, Supplier<T> block, Item.Properties properties) {
        RegistryObject<T> regBlock = BLOCKS.register(name, block);
        RegistryObject<BlockItem> regBlockItem = ItemInit.ITEMS.register(name,
                () -> new BlockItem(regBlock.get(), properties));
        return new BlockWithItemHolder<>(regBlock, regBlockItem);
    }

    private static <T extends Block> BlockWithItemHolder<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, new Item.Properties());
    }

    public record BlockWithItemHolder<T extends Block>(RegistryObject<T> block, RegistryObject<BlockItem> blockItem) {
    }
}
