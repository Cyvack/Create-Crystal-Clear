package com.cyvack.create_crystal_clear;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MiscCreativeTab {
	public static final CreativeModeTab GLASS_TAB = new CreativeModeTab("create_crystal_clear") {
		@Override
		public ItemStack makeIcon() {return ModBlocks.ANDESITE_GLASS_CASING.asStack();}
	};
	private static final CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(() -> GLASS_TAB, "Create: Crystal Clear");
}
