package com.cyvack.create_misc;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MiscCreativeTab {
	public static final CreativeModeTab MISC_TAB = new CreativeModeTab("create_misc") {
		@Override
		public ItemStack makeIcon() {return ModBlocks.GLASS_COPPER_CASING.asStack();}
	};
	private static final CreateRegistrate REGISTRATE = Create_Misc.registrate().creativeModeTab(() -> MISC_TAB, "Create Misc");
}
