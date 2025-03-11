package net.pzpeen.ben_10_mod.datagen;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.pzpeen.ben_10_mod.Ben_10_Mod;
import net.pzpeen.ben_10_mod.block.Mod_Blocks;
import net.pzpeen.ben_10_mod.item.Mod_Items;
import net.pzpeen.ben_10_mod.util.Mod_Tags;
import net.pzpeen.ben_10_mod.util.RecipeSets;

import java.util.List;
import java.util.function.Consumer;

public class Mod_Recipes_Provider extends RecipeProvider {
    public Mod_Recipes_Provider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Bubble_Gum
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Mod_Items.BUBBLE_GUM.get())
                .pattern(" P ")
                .pattern("WSW")
                .pattern(" D ")
                .define('P', Items.PAPER)
                .define('W', Items.WHEAT)
                .define('S', Items.SLIME_BALL)
                .define('D', Items.PINK_DYE)
                .unlockedBy(getHasName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                .save(consumer);

        //Improvised Component
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Mod_Items.IMPROVISED_COMPONENT.get())
                .pattern(" L ")
                .pattern("rBr")
                .pattern(" R ")
                .define('L', Items.LAPIS_BLOCK)
                .define('r', Items.REDSTONE)
                .define('B', Mod_Items.BUBBLE_GUM.get())
                .define('R', Items.REDSTONE_BLOCK)
                .unlockedBy(getHasName(Mod_Items.BUBBLE_GUM.get()), has(Mod_Items.BUBBLE_GUM.get()))
                .save(consumer);

        //Raw Steel Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Mod_Blocks.RAW_STEEL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Mod_Items.RAW_STEEL.get())
                .unlockedBy(getHasName(Mod_Items.RAW_STEEL.get()), has(Mod_Items.RAW_STEEL.get()))
                .save(consumer);

        //Raw Steel from Raw Steel Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Mod_Items.RAW_STEEL.get(), 9)
                .requires(Mod_Blocks.RAW_STEEL_BLOCK.get())
                .unlockedBy(getHasName(Mod_Blocks.RAW_STEEL_BLOCK.get()), has(Mod_Blocks.RAW_STEEL_BLOCK.get()))
                .save(consumer);

        //Steel Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Mod_Blocks.STEEL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Mod_Items.STEEL.get())
                .unlockedBy(getHasName(Mod_Items.STEEL.get()), has(Mod_Items.STEEL.get()))
                .save(consumer);

        //Steel from Steel Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Mod_Items.STEEL.get(), 9)
                .requires(Mod_Blocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(Mod_Blocks.STEEL_BLOCK.get()), has(Mod_Blocks.STEEL_BLOCK.get()))
                .save(consumer);

        //Steel from smelting
        oreSmelting(consumer, RecipeSets.STEEL_SMELTABLES, RecipeCategory.MISC, Mod_Items.STEEL.get(), 0.1F, 200, "steel");

        //Steel from Blasting
        oreBlasting(consumer, RecipeSets.STEEL_SMELTABLES, RecipeCategory.MISC, Mod_Items.STEEL.get(), 0.1F, 100, "steel");


        //Reinforce Control
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Mod_Items.REINFORCE_CONTROL.get())
                .pattern("OEO")
                .pattern("SBS")
                .pattern("RIR")
                .define('O', Items.OBSIDIAN)
                .define('E', Items.ENDER_EYE)
                .define('S', Mod_Items.STEEL.get())
                .define('B', Items.STONE_BUTTON)
                .define('R', Items.REDSTONE_BLOCK)
                .define('I', Mod_Items.IMPROVISED_COMPONENT.get())
                .unlockedBy(getHasName(Mod_Items.IMPROVISED_COMPONENT.get()), has(Mod_Items.IMPROVISED_COMPONENT.get()))
                .save(consumer);

        //Weaken Control
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Mod_Items.WEAKEN_CONTROL.get())
                .pattern("GWG")
                .pattern("SCS")
                .pattern("RIR")
                .define('G', Items.GLASS_PANE)
                .define('W', Blocks.WITHER_SKELETON_SKULL)
                .define('S', Mod_Items.STEEL.get())
                .define('C', Mod_Items.REINFORCE_CONTROL.get())
                .define('R', Items.REDSTONE_BLOCK)
                .define('I', Mod_Items.IMPROVISED_COMPONENT.get())
                .unlockedBy(getHasName(Mod_Items.REINFORCE_CONTROL.get()), has(Mod_Items.REINFORCE_CONTROL.get()))
                .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, Ben_10_Mod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
