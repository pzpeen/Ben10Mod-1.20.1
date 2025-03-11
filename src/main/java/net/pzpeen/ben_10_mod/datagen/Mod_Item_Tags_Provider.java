package net.pzpeen.ben_10_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class Mod_Item_Tags_Provider extends ItemTagsProvider {
    public Mod_Item_Tags_Provider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookUpProvider,
                                  CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookUpProvider, blockTags, Ben_10_Mod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
