package net.pzpeen.ben_10_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;
import net.pzpeen.ben_10_mod.util.Mod_Tags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class Mod_Block_Tags_Provider extends BlockTagsProvider {
    public Mod_Block_Tags_Provider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ben_10_Mod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Mod_Blocks.STEEL_BLOCK.get())
                .add(Mod_Blocks.RAW_STEEL_BLOCK.get())
                .add(Mod_Blocks.STEEL_ORE.get())
                .add(Mod_Blocks.DEEPSLATE_STEEL_ORE.get())
                .add(Mod_Blocks.STEEL_DOOR.get())
                .add(Mod_Blocks.STEEL_TRAPDOOR.get())
                .add(Mod_Blocks.STEEL_BUTTON.get())
                .add(Mod_Blocks.STEEL_PRESSURE_PLATE.get())
                .add(Mod_Blocks.STEEL_STAIR.get())
                .add(Mod_Blocks.STEEL_SLAB.get())
                .add(Mod_Blocks.STEEL_FENCE.get())
                .add(Mod_Blocks.STEEL_FENCE_GATE.get())
                .add(Mod_Blocks.STEEL_WALL.get())

                .add(Mod_Blocks.REINFORCED_STONE.get())
                .add(Mod_Blocks.REINFORCED_QUARTZ_BLOCK.get())
                .add(Mod_Blocks.REINFORCED_OBSIDIAN.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(Mod_Blocks.STEEL_BLOCK.get())
                .add(Mod_Blocks.RAW_STEEL_BLOCK.get())
                .add(Mod_Blocks.STEEL_ORE.get())
                .add(Mod_Blocks.DEEPSLATE_STEEL_ORE.get())
                .add(Mod_Blocks.STEEL_DOOR.get())
                .add(Mod_Blocks.STEEL_TRAPDOOR.get())
                .add(Mod_Blocks.STEEL_BUTTON.get())
                .add(Mod_Blocks.STEEL_PRESSURE_PLATE.get())
                .add(Mod_Blocks.STEEL_STAIR.get())
                .add(Mod_Blocks.STEEL_SLAB.get())
                .add(Mod_Blocks.STEEL_FENCE.get())
                .add(Mod_Blocks.STEEL_FENCE_GATE.get())
                .add(Mod_Blocks.STEEL_WALL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Mod_Blocks.REINFORCED_STONE.get())
                .add(Mod_Blocks.REINFORCED_QUARTZ_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(Mod_Blocks.REINFORCED_OBSIDIAN.get());

        this.tag(Mod_Tags.Blocks.VALID_BLOCKS_TO_REINFORCE)
                .add(Blocks.STONE)
                .add(Blocks.QUARTZ_BLOCK)
                .add(Blocks.OBSIDIAN);

        this.tag(Mod_Tags.Blocks.VALID_BLOCKS_TO_WEAKEN)
                .add(Mod_Blocks.REINFORCED_STONE.get())
                .add(Mod_Blocks.REINFORCED_QUARTZ_BLOCK.get())
                .add(Mod_Blocks.REINFORCED_OBSIDIAN.get());

        this.tag(BlockTags.FENCES)
                .add(Mod_Blocks.STEEL_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(Mod_Blocks.STEEL_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(Mod_Blocks.STEEL_WALL.get());

    }
}
