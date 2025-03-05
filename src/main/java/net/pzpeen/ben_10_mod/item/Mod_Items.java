package net.pzpeen.ben_10_mod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.item.custom.BubbleGumItem;
import net.pzpeen.ben_10_mod.item.custom.FuelItem;
import net.pzpeen.ben_10_mod.item.custom.ReinforceControlItem;
import net.pzpeen.ben_10_mod.item.custom.WeakenControlItem;

public class Mod_Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ben_10_Mod.MODID);

    public static final RegistryObject<Item> IMPROVISED_COMPONENT = ITEMS.register("improvised_component",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> REINFORCE_CONTROL = ITEMS.register("reinforce_control",
            () -> new ReinforceControlItem(new Item.Properties().stacksTo(1).durability(150)));
    public static final RegistryObject<Item> WEAKEN_CONTROL = ITEMS.register("weaken_control",
            () -> new WeakenControlItem(new Item.Properties().stacksTo(1).durability(150)));

    public static final RegistryObject<Item> BUBBLE_GUM = ITEMS.register("bubble_gum",
            () -> new BubbleGumItem(new Item.Properties().food(Mod_Food.BUBBLE_GUM), 30));

    public static final RegistryObject<Item> STEEL = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_STEEL = ITEMS.register("raw_steel",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
