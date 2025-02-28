package net.pzpeen.ben_10_mod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.item.Mod_Items;

import java.util.function.Supplier;

public class Mod_Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ben_10_Mod.MODID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    public static <T extends Block>RegistryObject<Block> registerBlock(String name, Supplier<T> sblock){
        RegistryObject<Block> blockToReturn = BLOCKS.register(name, sblock);
        registerItemBlock(name, blockToReturn);
        return blockToReturn;
    }

    public static <T extends Block>RegistryObject<Item> registerItemBlock(String name, RegistryObject<T> block){
        return Mod_Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
