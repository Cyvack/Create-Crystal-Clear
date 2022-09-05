package com.cyvack.create_crystal_clear;

import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.BlockBuilders.glasscasing;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

public class ModBlocks {
	private static final
		CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(()-> CrystalClearTab.GLASS_TAB);



	//Casings
	public static final BlockEntry<ConnectedGlassBlock>
				ANDESITE_GLASS_CASING =
				glasscasing("andesite_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_GLASS_CASING)),

				BRASS_GLASS_CASING =
				glasscasing("brass_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_GLASS_CASING)),

				COPPER_GLASS_CASING =
				glasscasing("copper_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_GLASS_CASING));

	//Clear Casings
	public static final BlockEntry<ConnectedGlassBlock>
				ANDESITE_CLEAR_GLASS_CASING =
				glasscasing("andesite_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.ANDESITE_CLEAR_GLASS_CASING)),

				BRASS_CLEAR_GLASS_CASING =
				glasscasing("brass_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.BRASS_CLEAR_GLASS_CASING)),

				COPPER_CLEAR_GLASS_CASING =
				glasscasing("copper_clear_glass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.COPPER_CLEAR_GLASS_CASING));


	public static void register() {}
}
