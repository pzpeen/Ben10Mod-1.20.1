package net.pzpeen.ben_10_mod.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ScreenEvent;

import java.util.List;

public class MethodsUtil {
    public static void addOrDropItem(Player player, ItemStack itemStack){
        boolean addedItem = player.addItem(itemStack);
        if (!addedItem){
            player.drop(itemStack, false);
        }
    }

    public static void addShiftTooltipComponent (List<Component> toolTipComponents, String componentId) {
        if (Screen.hasShiftDown()){
            toolTipComponents.add(Component.translatable(componentId).withStyle(ChatFormatting.GRAY));
        }else{
            toolTipComponents.add(Component.translatable("tooltip.ben_10_mod.shift_util").withStyle(ChatFormatting.DARK_GRAY));
        }
    }
}
