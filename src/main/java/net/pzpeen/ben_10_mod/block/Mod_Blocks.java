package net.pzpeen.ben_10_mod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.item.Mod_Items;

import java.util.function.Supplier;

public class Mod_Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ben_10_Mod.MODID);


    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3.5F)));
    public static final RegistryObject<Block> RAW_STEEL_BLOCK = registerBlock("raw_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> STEEL_ORE = registerBlock("steel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.5F).requiresCorrectToolForDrops(), UniformInt.of(0, 2)));
    public static final RegistryObject<Block> DEEPSLATE_STEEL_ORE = registerBlock("deepslate_steel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3.5F).requiresCorrectToolForDrops(), UniformInt.of(0, 3)));

    public static final RegistryObject<Block> STEEL_SLAB = registerBlock("steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3F)));
    public static final RegistryObject<Block> STEEL_STAIR = registerBlock("steel_stair",
            () -> new StairBlock(() -> Mod_Blocks.STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3.5F)));

    public static final RegistryObject<Block> STEEL_BUTTON = registerBlock("steel_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(1.5F),
                    BlockSetType.IRON, 20, true));
    public static final RegistryObject<Block> STEEL_PRESSURE_PLATE = registerBlock("steel_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2.5F), BlockSetType.IRON));

    public static final RegistryObject<Block> STEEL_DOOR = registerBlock("steel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3F).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3F).noOcclusion(), BlockSetType.STONE));

    public static final RegistryObject<Block> STEEL_FENCE = registerBlock("steel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3.5F)));
    public static final RegistryObject<Block> STEEL_FENCE_GATE = registerBlock("steel_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3.5F),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> STEEL_WALL = registerBlock("steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3.5F)));

    public static final RegistryObject<Block> REINFORCED_STONE = registerBlock("reinforced_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.5F, 8F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REINFORCED_QUARTZ_BLOCK = registerBlock("reinforced_quartz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).strength(3F, 6F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).strength(40F, 1500F).requiresCorrectToolForDrops()));


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
