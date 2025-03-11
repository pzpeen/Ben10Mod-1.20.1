package net.pzpeen.ben_10_mod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pzpeen.ben_10_mod.Ben_10_Mod;

public class Mod_Tags {
    public static class Blocks{
        public static TagKey<Block> VALID_BLOCKS_TO_REINFORCE = tag("valid_blocks_to_reinforce");
        public static TagKey<Block> VALID_BLOCKS_TO_WEAKEN = tag("valid_blocks_to_weaken");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Ben_10_Mod.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Ben_10_Mod.MODID, name));
        }
    }
}
