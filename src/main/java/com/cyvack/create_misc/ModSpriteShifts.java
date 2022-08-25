package com.cyvack.create_misc;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;


public class ModSpriteShifts {
		//Casings
		public static final CTSpriteShiftEntry
			GLASS_ANDESITE_CASING =
			getCT(AllCTTypes.OMNIDIRECTIONAL, "glass_casing/glass_andesite_casing", "glass_casing/glass_andesite_casing"),
			GLASS_BRASS_CASING =
			getCT(AllCTTypes.OMNIDIRECTIONAL, "glass_casing/glass_brass_casing", "glass_casing/glass_brass_casing"),
			GLASS_COPPER_CASING =
			getCT(AllCTTypes.OMNIDIRECTIONAL, "glass_casing/glass_copper_casing", "glass_casing/glass_copper_casing");

	public static final CTSpriteShiftEntry
			CLEAR_GLASS_ANDESITE_CASING =
			getCT(AllCTTypes.OMNIDIRECTIONAL, "glass_casing/clear_glass_andesite_casing", "glass_casing/clear_glass_andesite_casing"),
			CLEAR_GLASS_BRASS_CASING =
			getCT(AllCTTypes.OMNIDIRECTIONAL, "glass_casing/clear_glass_brass_casing", "glass_casing/clear_glass_brass_casing"),
			CLEAR_GLASS_COPPER_CASING =
			getCT(AllCTTypes.OMNIDIRECTIONAL, "glass_casing/clear_glass_copper_casing", "glass_casing/clear_glass_copper_casing");






//////////////////////
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, Create_Misc.asResource("block/" + blockTextureName), Create_Misc.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}

}