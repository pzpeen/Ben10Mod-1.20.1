package net.pzpeen.ben_10_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.pzpeen.ben_10_mod.datagen.loot.Mod_Block_Loots_Sub_Provider;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Mod_Loot_Tables_Provider extends LootTableProvider {
    private static final List<SubProviderEntry> subProviderEntries = List.of(
            new SubProviderEntry(Mod_Block_Loots_Sub_Provider::new, LootContextParamSets.BLOCK));

    public Mod_Loot_Tables_Provider(PackOutput pOutput) {
        super(pOutput, Collections.emptySet(), subProviderEntries);
    }

}
