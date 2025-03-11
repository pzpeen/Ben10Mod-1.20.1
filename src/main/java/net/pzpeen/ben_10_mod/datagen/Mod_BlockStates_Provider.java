package net.pzpeen.ben_10_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraftforge.client.RenderTypeGroup;
import net.minecraftforge.client.RenderTypeHelper;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.earlydisplay.ElementShader;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;

public class Mod_BlockStates_Provider extends BlockStateProvider {
    public Mod_BlockStates_Provider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ben_10_Mod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(Mod_Blocks.RAW_STEEL_BLOCK);
        simpleBlockWithItem(Mod_Blocks.STEEL_BLOCK);
        simpleBlockWithItem(Mod_Blocks.STEEL_ORE);
        simpleBlockWithItem(Mod_Blocks.DEEPSLATE_STEEL_ORE);

        simpleBlockWithItem(Mod_Blocks.REINFORCED_QUARTZ_BLOCK);
        simpleBlockWithItem(Mod_Blocks.REINFORCED_OBSIDIAN);
        simpleBlockWithItem(Mod_Blocks.REINFORCED_STONE);

        slabBlock((SlabBlock) Mod_Blocks.STEEL_SLAB.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));
        stairsBlock((StairBlock) Mod_Blocks.STEEL_STAIR.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));

        buttonBlock((ButtonBlock) Mod_Blocks.STEEL_BUTTON.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock)Mod_Blocks.STEEL_PRESSURE_PLATE.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) Mod_Blocks.STEEL_DOOR.get(), modLoc("block/steel_door_bottom"),
                modLoc("block/steel_door_top"), "translucent");
        trapdoorBlockWithRenderType((TrapDoorBlock) Mod_Blocks.STEEL_TRAPDOOR.get(), modLoc("block/steel_trapdoor"), true,
                "translucent");

        fenceBlock((FenceBlock) Mod_Blocks.STEEL_FENCE.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) Mod_Blocks.STEEL_FENCE_GATE.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));
        wallBlock((WallBlock) Mod_Blocks.STEEL_WALL.get(), blockTexture(Mod_Blocks.STEEL_BLOCK.get()));
    }

    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
