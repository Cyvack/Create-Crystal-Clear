package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.content.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.content.blocks.glass_encased_cogwheel.NewGlassEncasedCogwheelBlock;
import com.cyvack.create_crystal_clear.content.blocks.glass_encased_shaft.NewGlassEncasedShaftBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.data_gen.BlockBuilders.*;

public class ModBlocks {

	//TODO: make this proper
	//Clear Casings
	public static final BlockEntry<GlassCasing>
			ANDESITE_CLEAR_GLASS_CASING = glasscasing("andesite_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_CLEAR_GLASS_CASING), null),
			BRASS_CLEAR_GLASS_CASING = glasscasing("brass_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_CLEAR_GLASS_CASING), null),

			COPPER_CLEAR_GLASS_CASING = glasscasing("copper_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_CLEAR_GLASS_CASING), null),
			TRAIN_CLEAR_GLASS_CASING = glasscasing("train_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.TRAIN_CLEAR_GLASS_CASING), null);

	//Casings
	public static final BlockEntry<GlassCasing>
			ANDESITE_GLASS_CASING = glasscasing("andesite_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_GLASS_CASING), ANDESITE_CLEAR_GLASS_CASING::get),
			BRASS_GLASS_CASING = glasscasing("brass_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_GLASS_CASING), BRASS_CLEAR_GLASS_CASING::get),
			COPPER_GLASS_CASING = glasscasing("copper_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_GLASS_CASING), COPPER_CLEAR_GLASS_CASING::get),
			TRAIN_GLASS_CASING = glasscasing("train_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.TRAIN_GLASS_CASING), TRAIN_CLEAR_GLASS_CASING::get);

//	Glass Encased Shafts
	public static final BlockEntry<NewGlassEncasedShaftBlock>
			ANDESITE_GLASS_ENCASED_SHAFT = glassEncasedShaft("andesite", false, p -> new NewGlassEncasedShaftBlock(p, ANDESITE_GLASS_CASING::get)),
			ANDESITE_CLEAR_GLASS_ENCASED_SHAFT = glassEncasedShaft("andesite", true,  p -> new NewGlassEncasedShaftBlock(p, ANDESITE_CLEAR_GLASS_CASING::get)),
			BRASS_GLASS_ENCASED_SHAFT = glassEncasedShaft("brass", false,  p -> new NewGlassEncasedShaftBlock(p, BRASS_GLASS_CASING::get)),
			BRASS_CLEAR_GLASS_ENCASED_SHAFT = glassEncasedShaft("brass", true,  p -> new NewGlassEncasedShaftBlock(p, BRASS_CLEAR_GLASS_CASING::get)),
			TRAIN_GLASS_ENCASED_SHAFT = glassEncasedShaft("train", false, p -> new NewGlassEncasedShaftBlock(p, TRAIN_GLASS_CASING::get)),
			TRAIN_CLEAR_GLASS_ENCASED_SHAFT = glassEncasedShaft("train", true, p -> new NewGlassEncasedShaftBlock(p, TRAIN_CLEAR_GLASS_CASING::get));

	//Glass Encased Cogwheels
	public static final BlockEntry<NewGlassEncasedCogwheelBlock>

			//SMALL COGS
			ANDESITE_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("andesite", false, false, p -> new NewGlassEncasedCogwheelBlock(p, false, ANDESITE_GLASS_CASING::get)),
			BRASS_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("brass", false, false, p -> new NewGlassEncasedCogwheelBlock(p, false, BRASS_GLASS_CASING::get)),
			TRAIN_GLASS_ENCASED_COGWHEEL =  glassEncasedCogwheel("train", false, false, p -> new NewGlassEncasedCogwheelBlock(p, false, TRAIN_GLASS_CASING::get)),

			ANDESITE_CLEAR_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("andesite", false, true, p -> new NewGlassEncasedCogwheelBlock(p, false, ANDESITE_CLEAR_GLASS_CASING::get)),
			BRASS_CLEAR_GLASS_ENCASED_COGWHEEL = glassEncasedCogwheel("brass", false, true, p -> new NewGlassEncasedCogwheelBlock(p, false, BRASS_CLEAR_GLASS_CASING::get)),
			TRAIN_CLEAR_GLASS_ENCASED_COGWHEEL =  glassEncasedCogwheel("train", false, true, p -> new NewGlassEncasedCogwheelBlock(p, false, TRAIN_CLEAR_GLASS_CASING::get)),

			//LARGE COGS
			ANDESITE_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("andesite", true, false, p -> new NewGlassEncasedCogwheelBlock(p, true, ANDESITE_GLASS_CASING::get)),
			BRASS_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("brass", true, false, p -> new NewGlassEncasedCogwheelBlock(p, true, BRASS_GLASS_CASING::get)),
			TRAIN_GLASS_ENCASED_LARGE_COGWHEEL =  glassEncasedCogwheel("train", true, false, p -> new NewGlassEncasedCogwheelBlock(p, true, TRAIN_GLASS_CASING::get)),

			ANDESITE_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("andesite", true, true, p -> new NewGlassEncasedCogwheelBlock(p, true, ANDESITE_CLEAR_GLASS_CASING::get)),
			BRASS_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL = glassEncasedCogwheel("brass", true, true, p -> new NewGlassEncasedCogwheelBlock(p, true, BRASS_CLEAR_GLASS_CASING::get)),
			TRAIN_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL =  glassEncasedCogwheel("train", true, true, p -> new NewGlassEncasedCogwheelBlock(p, true, TRAIN_CLEAR_GLASS_CASING::get));

	public static void register() {}
}
