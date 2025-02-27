package net.pzpeen.ben_10_mod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;

public class Mod_Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ben_10_Mod.MODID);

    public static final RegistryObject<Item> IMPROVISED_COMPONENT = ITEMS.register("improvised_component", () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
