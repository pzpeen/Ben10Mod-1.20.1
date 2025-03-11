package net.pzpeen.ben_10_mod.datagen;

import com.google.common.eventbus.Subscribe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pzpeen.ben_10_mod.Ben_10_Mod;

import java.security.Provider;
import java.util.concurrent.CompletableFuture;

public class Data_Generators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator dataGen = event.getGenerator();
        ExistingFileHelper eFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = dataGen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        dataGen.addProvider(event.includeClient(), new Mod_Item_Models_Provider(packOutput, eFileHelper));
        dataGen.addProvider(event.includeClient(), new Mod_BlockStates_Provider(packOutput, eFileHelper));

        Mod_Block_Tags_Provider blockTagsProvider = dataGen.addProvider(event.includeServer(),
                new Mod_Block_Tags_Provider(packOutput, lookupProvider, eFileHelper));
        dataGen.addProvider(event.includeServer(), new Mod_Item_Tags_Provider(packOutput, lookupProvider,
                blockTagsProvider.contentsGetter(), eFileHelper));

        dataGen.addProvider(event.includeServer(), new Mod_Recipes_Provider(packOutput));
        dataGen.addProvider(event.includeServer(), new Mod_Loot_Tables_Provider(packOutput));

    }

}
