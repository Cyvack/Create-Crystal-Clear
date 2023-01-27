package com.cyvack.create_crystal_clear.blocks;

import com.cyvack.create_crystal_clear.*;
import com.cyvack.create_crystal_clear.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.blocks.glass_encased_cogwheel.GlassEncasedCogwheel;
import com.cyvack.create_crystal_clear.blocks.glass_encased_shaft.GlassEncasedShaftBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.data_gen.BlockBuilders.*;

public class ModBlocks {

	private static final
	CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(() -> CrystalClearTab.GLASS_TAB);


	//Casings
	public static final BlockEntry<GlassCasing>
			ANDESITE_GLASS_CASING = glasscasing("andesite_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_GLASS_CASING)),
			BRASS_GLASS_CASING = glasscasing("brass_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_GLASS_CASING)),
			COPPER_GLASS_CASING = glasscasing("copper_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_GLASS_CASING)),
			TRAIN_GLASS_CASING = glasscasing("train_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.TRAIN_GLASS_CASING));

	//Clear Casings
	public static final BlockEntry<GlassCasing>
			ANDESITE_CLEAR_GLASS_CASING = glasscasing("andesite_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_CLEAR_GLASS_CASING)),
			BRASS_CLEAR_GLASS_CASING = glasscasing("brass_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_CLEAR_GLASS_CASING)),

			COPPER_CLEAR_GLASS_CASING = glasscasing("copper_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_CLEAR_GLASS_CASING)),
			TRAIN_CLEAR_GLASS_CASING = glasscasing("train_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.TRAIN_CLEAR_GLASS_CASING));

	//Glass Encased Shafts
	public static final BlockEntry<GlassEncasedShaftBlock>
			ANDESITE_GLASS_ENCASED_SHAFT = glassEncasedShaft("andesite", false, GlassEncasedShaftBlock::andesiteglass),
			ANDESITE_CLEAR_GLASS_ENCASED_SHAFT = glassEncasedShaft("andesite", true,  GlassEncasedShaftBlock::andesiteclearglass),
			BRASS_GLASS_ENCASED_SHAFT = glassEncasedShaft("brass", false,  GlassEncasedShaftBlock::brassglass),
			BRASS_CLEAR_GLASS_ENCASED_SHAFT = glassEncasedShaft("brass", true,  GlassEncasedShaftBlock::brassclearglass),
			TRAIN_GLASS_ENCASED_SHAFT = glassEncasedShaft("train", false, GlassEncasedShaftBlock::trainglass),
			TRAIN_CLEAR_GLASS_ENCASED_SHAFT = glassEncasedShaft("train", true, GlassEncasedShaftBlock::trainclearglass);

	//Glass Encased Cogwheels
	public static final BlockEntry<GlassEncasedCogwheel>

			//SMALL COGS
			ANDESITE_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("andesite", false, false, p -> GlassEncasedCogwheel.andesite_glass(false, p)),
			BRASS_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("brass", false, false, p -> GlassEncasedCogwheel.brass_glass(false, p)),
			TRAIN_GLASS_ENCASED_COGWHEEL =  glassEncasedCogwheel("train", false, false, p -> GlassEncasedCogwheel.train_glass(false, p)),

			ANDESITE_CLEAR_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("andesite", false, true, p -> GlassEncasedCogwheel.andesite_clear_glass(false, p)),
			BRASS_CLEAR_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("brass", false, true, p -> GlassEncasedCogwheel.brass_clear_glass(false, p)),
			TRAIN_CLEAR_GLASS_ENCASED_COGWHEEL =  glassEncasedCogwheel("train", false, true, p -> GlassEncasedCogwheel.train_clear_glass(false, p)),

			//LARGE COGS
			ANDESITE_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("andesite", true, false, p -> GlassEncasedCogwheel.andesite_glass(true, p)),
			BRASS_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("brass", true, false, p -> GlassEncasedCogwheel.brass_glass(true, p)),
			TRAIN_GLASS_ENCASED_LARGE_COGWHEEL =  glassEncasedCogwheel("train", true, false, p -> GlassEncasedCogwheel.train_glass(true, p)),

			ANDESITE_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("andesite", true, true, p -> GlassEncasedCogwheel.andesite_clear_glass(true, p)),
			BRASS_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("brass", true, true, p -> GlassEncasedCogwheel.brass_clear_glass(true, p)),
			TRAIN_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL =  glassEncasedCogwheel("train", true, true, p -> GlassEncasedCogwheel.train_clear_glass(true, p));

	public static void register() {}
}
