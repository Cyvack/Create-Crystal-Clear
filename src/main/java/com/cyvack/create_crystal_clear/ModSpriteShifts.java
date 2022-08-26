package com.cyvack.create_crystal_clear;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;

public class ModSpriteShifts {
	//Casings
	public static final CTSpriteShiftEntry
			ANDESITE_GLASS_CASING = omni("glass_casing/andesite_glass_casing"),
			BRASS_GLASS_CASING = omni("glass_casing/brass_glass_casing"),
			COPPER_GLASS_CASING = omni("glass_casing/copper_glass_casing");

	public static final CTSpriteShiftEntry
			ANDESITE_CLEAR_GLASS_CASING = omni("glass_casing/andesite_clear_glass_casing"),
			BRASS_CLEAR_GLASS_CASING = omni("glass_casing/brass_clear_glass_casing"),
			COPPER_CLEAR_GLASS_CASING = omni("glass_casing/copper_clear_glass_casing");

	//Cogwheels
	public static final CTSpriteShiftEntry
			ANDESITE_GLASS_ENCASED_COGWHEEL_SIDE = vertical("andesite_glass_encased_cogwheel_side"),
			ANDESITE_GLASS_ENCASED_COGWHEEL_OTHERSIDE = horizontal("andesite_glass_encased_cogwheel_side"),
			BRASS_GLASS_ENCASED_COGWHEEL_SIDE = vertical("brass_glass_encased_cogwheel_side"),
			BRASS_GLASS_ENCASED_COGWHEEL_OTHERSIDE = horizontal("brass_glass_encased_cogwheel_side");





	//////////////////////
		private static CTSpriteShiftEntry omni(String name) {
			return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
		}

		private static CTSpriteShiftEntry horizontal(String name) {
			return getCT(AllCTTypes.HORIZONTAL, name);
		}

		private static CTSpriteShiftEntry vertical(String name) {
			return getCT(AllCTTypes.VERTICAL, name);
		}

	private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
		return SpriteShifter.get(Create_Crystal_Clear.asResource(originalLocation), Create_Crystal_Clear.asResource(targetLocation));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, Create_Crystal_Clear.asResource("block/" + blockTextureName), Create_Crystal_Clear.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}
}