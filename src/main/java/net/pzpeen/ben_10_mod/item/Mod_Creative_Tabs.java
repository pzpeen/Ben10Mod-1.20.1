package net.pzpeen.ben_10_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;

public class Mod_Creative_Tabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ben_10_Mod.MODID);

    public static final RegistryObject<CreativeModeTab> MISCELLANEOUS = CREATIVE_TABS.register("miscellaneous", () -> CreativeModeTab.builder().title(Component
            .translatable("creativetab.ben_10_mod.miscellaneous")).icon(() -> new ItemStack(Mod_Items.IMPROVISED_COMPONENT.get()))
            .displayItems((itemDisplayParameters, output) ->{
                    output.accept(Mod_Items.IMPROVISED_COMPONENT.get());

            }).build());

    public static final RegistryObject<CreativeModeTab> MATERIALS = CREATIVE_TABS.register("materials", () -> CreativeModeTab.builder().title(Component
                    .translatable("creativetab.ben_10_mod.materials")).icon(() -> new ItemStack(Mod_Blocks.STEEL_BLOCK.get()))
            .displayItems((itemDisplayParameters, output) ->{
                output.accept(Mod_Items.STEEL.get());
                output.accept(Mod_Items.RAW_STEEL.get());
                output.accept(Mod_Blocks.STEEL_BLOCK.get());

            }).build());

    public static void register (IEventBus eventBus){
        CREATIVE_TABS.register(eventBus);
    }

    public static void addVanillaTabs(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(Mod_Items.IMPROVISED_COMPONENT);
        }
    }
}
