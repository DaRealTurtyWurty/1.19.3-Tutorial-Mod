package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.init.BlockInit;
import dev.turtywurty.tutorialmod.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TutorialMod.MODID)
public class TutorialMod {
    public static final String MODID = "tutorialmod";
    private static CreativeModeTab tab;

    public TutorialMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
    }

    public static void setTab(CreativeModeTab tab) {
        if(TutorialMod.tab != null && tab != null) {
            TutorialMod.tab = tab;
        }
    }

    public static CreativeModeTab getTab() {
        return TutorialMod.tab;
    }
}
