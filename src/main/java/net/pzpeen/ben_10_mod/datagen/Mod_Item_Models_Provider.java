package net.pzpeen.ben_10_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;
import net.pzpeen.ben_10_mod.item.Mod_Items;

public class Mod_Item_Models_Provider extends ItemModelProvider {
    public Mod_Item_Models_Provider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ben_10_Mod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(Mod_Items.IMPROVISED_COMPONENT);
        simpleItem(Mod_Items.REINFORCE_CONTROL);
        simpleItem(Mod_Items.WEAKEN_CONTROL);

        simpleItem(Mod_Items.BUBBLE_GUM);

        simpleItem(Mod_Items.RAW_STEEL);
        simpleItem(Mod_Items.STEEL);

        simpleStairsBlockItem(Mod_Blocks.STEEL_STAIR, Mod_Blocks.STEEL_BLOCK);
        simpleSlabBlockItem(Mod_Blocks.STEEL_SLAB, Mod_Blocks.STEEL_BLOCK);
        simpleButtonBlockItem(Mod_Blocks.STEEL_BUTTON, Mod_Blocks.STEEL_BLOCK);
        simplePressurePlateBlockItem(Mod_Blocks.STEEL_PRESSURE_PLATE, Mod_Blocks.STEEL_BLOCK);
        simpleItemToBlockWithRenderType(Mod_Blocks.STEEL_DOOR, "translucent");
        simpleTrapdoorBlockItem(Mod_Blocks.STEEL_TRAPDOOR, Mod_Blocks.STEEL_TRAPDOOR);
        simpleFenceBlockItem(Mod_Blocks.STEEL_FENCE, Mod_Blocks.STEEL_BLOCK);
        simpleFenceGateBlockItem(Mod_Blocks.STEEL_FENCE_GATE, Mod_Blocks.STEEL_BLOCK);
        simpleWallBlockItem(Mod_Blocks.STEEL_WALL, Mod_Blocks.STEEL_BLOCK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Ben_10_Mod.MODID, "item/"+item.getId().getPath()));
    }
    private ItemModelBuilder simpleItemToBlock(RegistryObject<Block> block){
        return withExistingParent(block.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Ben_10_Mod.MODID, "item/"+block.getId().getPath()));
    }
    private ItemModelBuilder simpleItemToBlockWithRenderType(RegistryObject<Block> block, String renderType){
        return withExistingParent(block.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Ben_10_Mod.MODID, "item/"+block.getId().getPath())).renderType(renderType);
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<net.minecraft.world.level.block.Block> block){
        return withExistingParent(block.getId().getPath(), modLoc("block/"+block.getId().getPath())).renderType("translucent");
    }

    private ItemModelBuilder simpleStairsBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return stairs(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()),
                modLoc("block/"+blockBase.getId().getPath()), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simpleSlabBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return slab(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()),
                modLoc("block/"+blockBase.getId().getPath()), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simpleButtonBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return buttonInventory(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simplePressurePlateBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return pressurePlate(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simpleFenceBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return fenceInventory(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simpleFenceGateBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return fenceGate(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simpleWallBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return wallInventory(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath()));
    }
    private ItemModelBuilder simpleTrapdoorBlockItem(RegistryObject<Block> block, RegistryObject<Block> blockBase){
        return trapdoorOrientableBottom(block.getId().getPath(), modLoc("block/"+blockBase.getId().getPath())).renderType("translucent");
    }


}
