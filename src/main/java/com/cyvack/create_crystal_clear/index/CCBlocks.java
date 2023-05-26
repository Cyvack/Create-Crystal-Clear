package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.content.blocks.GlassCasing;
import com.cyvack.create_crystal_clear.content.blocks.GlassEncasedCogwheel;
import com.cyvack.create_crystal_clear.content.blocks.GlassEncasedShaft;
import com.cyvack.create_crystal_clear.index.casing_names.CasingTypes;

import static com.cyvack.create_crystal_clear.data_gen.BlockBuilders.*;

public class CCBlocks {



	//TODO: make this proper
	public static final GlassBlockList<GlassCasing>
		CLEAR_GLASS = new GlassBlockList<>(CasingTypes.NORMAL_CASINGS.names, (casing) -> glassCasing(casing, true)),
		GLASS_CASINGS = new GlassBlockList<>(CasingTypes.NORMAL_CASINGS.names, (casing) -> glassCasing(casing, false));

	//Glass Encased Shafts
	public static GlassBlockList<GlassEncasedShaft>
		GLASS_ENCASED_SHAFTS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.names,
			(casing) -> glassEncasedShaft(casing, false, (p -> new GlassEncasedShaft(p, () -> GLASS_CASINGS.getCasing(casing))))),

		CLEAR_GLASS_ENCASED_SHAFTS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.names,
			(casing) -> glassEncasedShaft(casing, true, (p -> new GlassEncasedShaft(p, () -> CLEAR_GLASS.getCasing(casing)))));

	//Glass Encased Cogwheels
	public static final GlassBlockList<GlassEncasedCogwheel>
		SMALL_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.names,
			(casing) -> glassEncasedCogwheel(casing, false, false, (p -> new GlassEncasedCogwheel(p, false, () -> GLASS_CASINGS.getCasing(casing))))),

		SMALL_CLEAR_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.names,
				(casing) -> glassEncasedCogwheel(casing, false, true, (p -> new GlassEncasedCogwheel(p, false, () -> CLEAR_GLASS.getCasing(casing))))),

		LARGE_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.names,
				(casing) -> glassEncasedCogwheel(casing, true, false, (p -> new GlassEncasedCogwheel(p, true, () -> GLASS_CASINGS.getCasing(casing))))),

		LARGE_CLEAR_GLASS_ENCASED_COGWHEELS = new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.names,
				(casing) -> glassEncasedCogwheel(casing, true, true, (p -> new GlassEncasedCogwheel(p, true, () -> CLEAR_GLASS.getCasing(casing)))));


	public static void register() {}
}
