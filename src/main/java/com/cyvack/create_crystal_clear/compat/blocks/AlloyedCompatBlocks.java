package com.cyvack.create_crystal_clear.compat.blocks;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.blocks.CrystalClearTab;
import com.cyvack.create_crystal_clear.blocks.glass_encased_shaft.GlassEncasedShaftBlock;
import com.cyvack.create_crystal_clear.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.blocks.ModSpriteShifts;
import com.cyvack.create_crystal_clear.blocks.glass_casings.TintedGlassCasing;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.data_gen.BlockBuilders.*;

public class AlloyedCompatBlocks {
	private static final
	CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(()-> CrystalClearTab.GLASS_TAB);

	public static final BlockEntry<GlassCasing>
			STEEL_GLASS_CASING =
			glasscasing("steel_glass_casing", ()-> new SimpleCTBehaviour((ModSpriteShifts.STEEL_GLASS_CASING)));

	public static final BlockEntry<TintedGlassCasing>
			STEEL_TINTED_GLASS_CASING =
			tintedglasscasing("steel_tinted_glass_casing", () -> new SimpleCTBehaviour((ModSpriteShifts.STEEL_TINTED_GLASS_CASING)));

	public static final BlockEntry<GlassEncasedShaftBlock>
			STEEL_GLASS_ENCASED_SHAFT = glassEncasedShaft("steel", false, GlassEncasedShaftBlock::steelglass);

	public static void register() {}
}
