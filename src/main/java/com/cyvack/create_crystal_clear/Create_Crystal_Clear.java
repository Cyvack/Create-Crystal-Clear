package com.cyvack.create_crystal_clear;

import com.cyvack.create_crystal_clear.blocks.ModBlocks;
import com.cyvack.create_crystal_clear.compat.blocks.AlloyedCompatBlocks;
import com.cyvack.create_crystal_clear.tile_entities.ModtileEntities;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("create_crystal_clear")
@Mod.EventBusSubscriber
public class Create_Crystal_Clear {

    public static final String MOD_ID = "create_crystal_clear";
    public static boolean isAlloyedLoaded = false;
    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public Create_Crystal_Clear(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        isAlloyedLoaded = ModList.get().isLoaded("alloyed");

        REGISTRATE.registerEventListeners(eventBus);

        ModBlocks.register();
        ModtileEntities.register();

        //compat
        AlloyedCompatBlocks.register();
    }


    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
