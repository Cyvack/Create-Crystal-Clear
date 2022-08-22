package com.cyvack.create_misc;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;

import static com.simibubi.create.foundation.block.connected.AllCTTypes.OMNIDIRECTIONAL;


public class ModSpriteShifts {
		public static final CTSpriteShiftEntry GLASS_ANDESITE_CASING =
			CTSpriteShifter.getCT(OMNIDIRECTIONAL,
			Create_Misc.asResource("block/glass_andesite_casing"),
			Create_Misc.asResource("block/glass_andesite_casing_connected"));
		public static final CTSpriteShiftEntry GLASS_BRASS_CASING =
			CTSpriteShifter.getCT(OMNIDIRECTIONAL,
			Create_Misc.asResource("block/glass_brass_casing"),
			Create_Misc.asResource("block/glass_brass_casing_connected"));

		public static final CTSpriteShiftEntry GLASS_COPPER_CASING =
			CTSpriteShifter.getCT(OMNIDIRECTIONAL,
			Create_Misc.asResource("block/glass_copper_casing"),
			Create_Misc.asResource("block/glass_copper_casing_connected"));




	/*
	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	///////
	private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
		return SpriteShifter.get(Create_Misc.asResource(originalLocation), Create_Misc.asResource(targetLocation));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, Create_Misc.asResource("block/" + blockTextureName), Create_Misc.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}
	 */
}