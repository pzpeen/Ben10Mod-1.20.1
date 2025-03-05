package net.pzpeen.ben_10_mod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Mod_Food {
    public static FoodProperties BUBBLE_GUM = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200), 0.05F).alwaysEat().build();
}
