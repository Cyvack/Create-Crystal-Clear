package com.cyvack.create_crystal_clear.blocks;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.blocks.ModBlocks;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CrystalClearTab {
	public static final CreativeModeTab GLASS_TAB = new CreativeModeTab("create_crystal_clear") {
		@Override
		public ItemStack makeIcon() {return ModBlocks.COPPER_GLASS_CASING.asStack();}
	};
	private static final CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(() -> GLASS_TAB, "Create: Crystal Clear");
}
