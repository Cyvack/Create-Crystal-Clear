package com.cyvack.create_crystal_clear;

import com.cyvack.create_crystal_clear.index.CCBlockEntities;
import com.cyvack.create_crystal_clear.index.CCBlocks;
import com.cyvack.create_crystal_clear.index.CCTab;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(CrystalClear.ID)
public class CrystalClear {

    public static final String ID = "create_crystal_clear";
    public static final NonNullSupplier<CreateRegistrate> REGISTRATE = NonNullSupplier.lazy(() -> CreateRegistrate.create(ID)
            .creativeModeTab(() -> CCTab.MAIN_GROUP, "Crystal Clear"));

    public CrystalClear(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        registrate().registerEventListeners(modEventBus);

        CCBlocks.register();
        CCBlockEntities.register();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE.get();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
}
