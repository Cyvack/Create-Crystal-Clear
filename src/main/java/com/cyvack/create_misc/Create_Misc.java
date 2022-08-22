package com.cyvack.create_misc;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.CreateRegistry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("create_misc")
public class Create_Misc {
    public static final String MOD_ID = "create_misc";
    private static final NonNullSupplier<CreateRegistrate> REGISTRATE = CreateRegistrate.lazy(MOD_ID);

    public Create_Misc(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ModBlocks.register();
    }


    public static void init(final FMLCommonSetupEvent event) {
    }


    public static CreateRegistrate registrate() {
        return REGISTRATE.get();
    }
}
