package com.cyvack.create_crystal_clear.blocks;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.CrystalClearTab;
import com.cyvack.create_crystal_clear.GlassEncasedShaftBlock;
import com.cyvack.create_crystal_clear.data.BlockBuilders;
import com.cyvack.create_crystal_clear.data.GlassCasing;
import com.cyvack.create_crystal_clear.data.ModSpriteShifts;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.data.BlockBuilders.glasscasing;
import static com.simibubi.create.AllTags.axeOrPickaxe;

public class ModBlocks {
	private static final
		CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(()-> CrystalClearTab.GLASS_TAB);



	//Casings
	public static final BlockEntry<GlassCasing>
			ANDESITE_GLASS_CASING = glasscasing("andesite_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_GLASS_CASING)),

			BRASS_GLASS_CASING = glasscasing("brass_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_GLASS_CASING)),

			COPPER_GLASS_CASING = glasscasing("copper_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_GLASS_CASING));

	//Clear Casings
	public static final BlockEntry<GlassCasing>
			ANDESITE_CLEAR_GLASS_CASING = glasscasing("andesite_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_CLEAR_GLASS_CASING)),

			BRASS_CLEAR_GLASS_CASING = glasscasing("brass_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_CLEAR_GLASS_CASING)),

			COPPER_CLEAR_GLASS_CASING = glasscasing("copper_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_CLEAR_GLASS_CASING));

	//Glass Encased Shafts
	public static final BlockEntry<GlassEncasedShaftBlock>
			ANDESITE_GLASS_ENCASED_SHAFT = REGISTRATE
					.block("andesite_glass_encased_shaft", GlassEncasedShaftBlock::andesiteglass)
					.transform(BlockBuilders.glassencasedShaft("andesite_glass", () -> ModSpriteShifts.ANDESITE_GLASS_CASING))
					.transform(axeOrPickaxe())
					.register(),
			ANDESITE_CLEAR_GLASS_ENCASED_SHAFT = REGISTRATE
					.block("andesite_clear_glass_encased_shaft", GlassEncasedShaftBlock::andesiteclearglass)
					.transform(BlockBuilders.glassencasedShaft("andesite_clear_glass", () -> ModSpriteShifts.ANDESITE_CLEAR_GLASS_CASING))
					.transform(axeOrPickaxe())
					.register(),
			BRASS_GLASS_ENCASED_SHAFT = REGISTRATE
					.block("brass_glass_encased_shaft", GlassEncasedShaftBlock::brassglass)
					.transform(BlockBuilders.glassencasedShaft("brass_glass", () -> ModSpriteShifts.BRASS_GLASS_CASING))
					.transform(axeOrPickaxe())
					.register(),

			BRASS_CLEAR_GLASS_ENCASED_SHAFT = REGISTRATE
					.block("brass_clear_glass_encased_shaft", GlassEncasedShaftBlock::brassclearglass)
					.transform(BlockBuilders.glassencasedShaft("brass_clear_glass", () -> ModSpriteShifts.BRASS_CLEAR_GLASS_CASING))
					.transform(axeOrPickaxe())
			.register();




	// Glass Encased Cogwheel - TODO

	// Glass Encased Pipe - TODO

/*
			*_GLASS_ENCASED_SHAFT = REGISTRATE
					.block("*_glass_encased_shaft", GlassEncasedShaftBlock::*glass)
					.transform(BlockBuilders.glassencasedShaft("*_glass", () -> ModSpriteShifts.*_GLASS_CASING))
					.transform(axeOrPickaxe())
					.register(),
			*_CLEAR_GLASS_ENCASED_SHAFT = REGISTRATE
					.block("*_clear_glass_encased_shaft", GlassEncasedShaftBlock::*clearglass)
					.transform(BlockBuilders.glassencasedShaft("*_clear_glass", () -> ModSpriteShifts.*_CLEAR_GLASS_CASING))
					.transform(axeOrPickaxe())
					.register();
 */




	public static void register() {}
}
