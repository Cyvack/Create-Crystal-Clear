package com.cyvack.create_misc;

import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

public class ModBlocks {
		private static final
		CreateRegistrate REGISTRATE = Create_Misc.registrate().creativeModeTab(()-> MiscCreativeTab.MISC_TAB);
		
	public static final BlockEntry<CasingBlock> GLASS_CASING = REGISTRATE
				.block("glass_casing", CasingBlock::new)
				.transform(BuilderTransformers.casing(() -> ModSpriteShifts.GLASS_CASING))
				.register();





	public static void register() {}
}
