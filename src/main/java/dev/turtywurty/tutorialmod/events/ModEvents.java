package dev.turtywurty.tutorialmod.events;

import dev.turtywurty.tutorialmod.TutorialMod;
import dev.turtywurty.tutorialmod.init.BlockInit;
import dev.turtywurty.tutorialmod.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void addItemsToTabs(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.EXAMPLE_ITEM);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlockInit.EXAMPLE_BLOCK.blockItem());
        }
    }

    @SubscribeEvent
    public static void registerTabs(CreativeModeTabEvent.Register event) {
        TutorialMod.setTab(event.registerCreativeModeTab(new ResourceLocation(TutorialMod.MODID, "example_tab"),
                builder -> builder.icon(() -> ItemInit.EXAMPLE_PICKAXE.get().getDefaultInstance())
                        .title(Component.translatable("tab." + TutorialMod.MODID + ".example_tab"))
                        .displayItems((featureFlags, output, hasOp) -> {
                            ForgeRegistries.ITEMS.getEntries().stream()
                                    .filter(entry -> entry.getKey().location().getNamespace()
                                            .equalsIgnoreCase(TutorialMod.MODID))
                                    .map(Map.Entry::getValue)
                                    .forEachOrdered(output::accept);
                        })));
    }
}
