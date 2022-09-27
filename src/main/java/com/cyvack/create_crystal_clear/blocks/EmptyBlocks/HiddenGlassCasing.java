package com.cyvack.create_crystal_clear.blocks.EmptyBlocks;

import com.cyvack.create_crystal_clear.blocks.glass_casings.GlassCasing;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.system.NonnullDefault;


public class HiddenGlassCasing extends GlassCasing{

	public HiddenGlassCasing(Properties p) {
		super(p);
	}

	@Override
	@NonnullDefault
	public void fillItemCategory(CreativeModeTab pTab, NonNullList<ItemStack> pItems) {
		// Don't add the item to any item category - therefore making it hidden.
	}
}
