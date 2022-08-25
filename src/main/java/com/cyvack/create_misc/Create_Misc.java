package com.cyvack.create_misc;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.CreateRegistry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("create_misc")
public class Create_Misc {
    public static final String MOD_ID = "create_misc";
    private static final NonNullSupplier<CreateRegistrate> REGISTRATE = CreateRegistrate.lazy(MOD_ID);

    public Create_Misc(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register();
        ModTileEntities.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLEAR_GLASS_ANDESITE_CASING.get(), RenderType.translucent());
        }


    public static CreateRegistrate registrate() {
        return REGISTRATE.get();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
