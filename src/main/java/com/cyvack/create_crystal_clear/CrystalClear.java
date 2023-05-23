package com.cyvack.create_crystal_clear;

import com.cyvack.create_crystal_clear.index.CrystalClearBlockEntities;
import com.cyvack.create_crystal_clear.index.ModBlocks;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("create_crystal_clear")
@Mod.EventBusSubscriber
public class CrystalClear {

    public static final String MOD_ID = "create_crystal_clear";
//    public static boolean isAlloyedLoaded = false;
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public CrystalClear(){
        REGISTRATE.registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus());

        ModBlocks.register();
        CrystalClearBlockEntities.register();

        //compat
//        isAlloyedLoaded = ModList.get().isLoaded("alloyed");
//        AlloyedCompatBlocks.register();

        MinecraftForge.EVENT_BUS.register(this);
    }


    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
