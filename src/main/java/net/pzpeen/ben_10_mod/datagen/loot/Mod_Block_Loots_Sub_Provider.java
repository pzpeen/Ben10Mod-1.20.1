package net.pzpeen.ben_10_mod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;
import net.pzpeen.ben_10_mod.item.Mod_Items;

import java.util.Set;

public class Mod_Block_Loots_Sub_Provider extends BlockLootSubProvider {
    private static final Set<Item> explosionResistant = Set.of(Mod_Blocks.REINFORCED_OBSIDIAN.get().asItem(),
            Mod_Blocks.REINFORCED_STONE.get().asItem(),
            Mod_Blocks.REINFORCED_QUARTZ_BLOCK.get().asItem());

    public Mod_Block_Loots_Sub_Provider() {
        super(explosionResistant, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        dropSelf(Mod_Blocks.STEEL_BLOCK.get());
        dropSelf(Mod_Blocks.RAW_STEEL_BLOCK.get());

        this.add(Mod_Blocks.STEEL_ORE.get(), createBetweenOreDrops(Mod_Blocks.STEEL_ORE.get(), Mod_Items.STEEL.get(), 1F, 5F));
        this.add(Mod_Blocks.DEEPSLATE_STEEL_ORE.get(), createBetweenOreDrops(Mod_Blocks.DEEPSLATE_STEEL_ORE.get(), Mod_Items.STEEL.get(), 1F, 5F));

        dropSelf(Mod_Blocks.REINFORCED_STONE.get());
        dropSelf(Mod_Blocks.REINFORCED_QUARTZ_BLOCK.get());
        dropSelf(Mod_Blocks.REINFORCED_OBSIDIAN.get());

        dropSelf(Mod_Blocks.STEEL_SLAB.get());
        dropSelf(Mod_Blocks.STEEL_STAIR.get());

        dropSelf(Mod_Blocks.STEEL_BUTTON.get());
        dropSelf(Mod_Blocks.STEEL_PRESSURE_PLATE.get());

        dropSelf(Mod_Blocks.STEEL_DOOR.get());
        dropSelf(Mod_Blocks.STEEL_TRAPDOOR.get());

        dropSelf(Mod_Blocks.STEEL_FENCE.get());
        dropSelf(Mod_Blocks.STEEL_FENCE_GATE.get());
        dropSelf(Mod_Blocks.STEEL_WALL.get());
    }

    protected LootTable.Builder createBetweenOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Mod_Blocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
