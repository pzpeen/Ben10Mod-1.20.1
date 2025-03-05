package net.pzpeen.ben_10_mod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.pzpeen.ben_10_mod.util.MethodsUtil;

public class BubbleGumItem extends FuelItem{
    public BubbleGumItem(Properties pProperties, int burnTime) {
        super(pProperties, burnTime);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(!pLevel.isClientSide()){
            if (pLivingEntity instanceof Player){
                MethodsUtil.addOrDropItem(((Player) pLivingEntity), new ItemStack(Items.PAPER));
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
