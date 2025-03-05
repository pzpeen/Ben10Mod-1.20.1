package net.pzpeen.ben_10_mod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;
import net.pzpeen.ben_10_mod.util.MethodsUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WeakenControlItem extends Item {
    static Block[] VALIDBLOCKS = {Mod_Blocks.REINFORCED_STONE.get(), Mod_Blocks.REINFORCED_QUARTZ_BLOCK.get(), Mod_Blocks.REINFORCED_OBSIDIAN.get()};

    public WeakenControlItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        Level world = pContext.getLevel();
        if (!world.isClientSide){
            if(tryWeaken(blockpos, world)){
                if (player!= null){
                    player.getCooldowns().addCooldown(this, 60);
                    pContext.getItemInHand().hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(entity.getUsedItemHand()));
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        MethodsUtil.addShiftTooltipComponent(pTooltipComponents, "tooltip.ben_10_mod.weaken_control");
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

    }

    private static boolean tryWeaken(BlockPos blockpos, Level world) {
        Block blockToReinforce = isValidBlock(blockpos, world);
        if (blockToReinforce != null){
            String blockId = BuiltInRegistries.BLOCK.getKey(blockToReinforce).toString();
            String blockName = blockId.replace("ben_10_mod:reinforced_", "");
            if (!blockId.isEmpty()){
                try {
                    world.setBlock(blockpos, ForgeRegistries.BLOCKS.getValue(ResourceLocation.of("minecraft:"+blockName,':')).defaultBlockState(), 8);
                    return true;

                }catch (Exception e){
                    System.out.println("Error on TryWeaken, cannot set block");
                }

            }

        }
        return false;
    }

    private static Block isValidBlock(BlockPos blockpos, Level world) {
        for (Block validBlock : VALIDBLOCKS){
            if (world.getBlockState(blockpos).is(validBlock)){
                return world.getBlockState(blockpos).getBlock();
            }
        }
        return null;
    }
}
