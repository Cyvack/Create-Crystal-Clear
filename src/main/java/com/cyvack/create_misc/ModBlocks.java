package com.cyvack.create_misc;

import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.TagKey;

public class ModBlocks {
		private static final
		CreateRegistrate REGISTRATE = Create_Misc.registrate().creativeModeTab(()-> MiscCreativeTab.MISC_TAB);
		
	public static final BlockEntry<CasingBlock> GLASS_ANDESITE_CASING = REGISTRATE
				.block("glass_andesite_casing", CasingBlock::new)
				.transform(BuilderTransformers.casing(() -> ModSpriteShifts.GLASS_ANDESITE_CASING))
				.register();

	public static final BlockEntry<CasingBlock> GLASS_BRASS_CASING = REGISTRATE
				.block("glass_brass_casing", CasingBlock::new)
				.transform(BuilderTransformers.casing(() -> ModSpriteShifts.GLASS_BRASS_CASING))
				.register();

	public static final BlockEntry<CasingBlock> GLASS_COPPER_CASING = REGISTRATE
			.block("glass_copper_casing", CasingBlock::new)
			.transform(BuilderTransformers.casing(() -> ModSpriteShifts.GLASS_COPPER_CASING))
			.register();




	public static void register() {}
}
