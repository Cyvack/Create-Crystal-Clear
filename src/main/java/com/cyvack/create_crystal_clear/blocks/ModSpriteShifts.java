package com.cyvack.create_crystal_clear.blocks;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;


public class ModSpriteShifts {
	//Casings
	public static final CTSpriteShiftEntry
			ANDESITE_GLASS_CASING = omni("andesite_glass_casing"),
			BRASS_GLASS_CASING = omni("brass_glass_casing"),
			COPPER_GLASS_CASING = omni("copper_glass_casing"),
			TRAIN_GLASS_CASING = omni("train_glass_casing"),
			STEEL_GLASS_CASING = omni("steel_glass_casing");

	//Clear Glass Casings
	public static final CTSpriteShiftEntry
			ANDESITE_CLEAR_GLASS_CASING = omni("andesite_clear_glass_casing"),
			BRASS_CLEAR_GLASS_CASING = omni("brass_clear_glass_casing"),
			TRAIN_CLEAR_GLASS_CASING = omni("train_clear_glass_casing"),
			COPPER_CLEAR_GLASS_CASING = omni("copper_clear_glass_casing");

	//Tinted Glass Casings
	public static  final CTSpriteShiftEntry
			STEEL_TINTED_GLASS_CASING = omni("steel_tinted_glass_casing");




	//////////////////////
	public static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	public static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}

	public static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}

	/////

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, Create_Crystal_Clear.asResource("block/" + blockTextureName), Create_Crystal_Clear.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}
}

