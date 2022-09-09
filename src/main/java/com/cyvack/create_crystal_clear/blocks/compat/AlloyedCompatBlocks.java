package com.cyvack.create_crystal_clear.blocks.compat;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.CrystalClearTab;
import com.cyvack.create_crystal_clear.blocks.GlassCasing;
import com.cyvack.create_crystal_clear.blocks.ModSpriteShifts;
import com.cyvack.create_crystal_clear.blocks.TintedGlassCasing;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.data.BlockBuilders.glasscasing;
import static com.cyvack.create_crystal_clear.data.BlockBuilders.tintedglasscasing;

public class AlloyedCompatBlocks {
	private static final
	CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(()-> CrystalClearTab.GLASS_TAB);

	public static final BlockEntry<GlassCasing>
			STEEL_GLASS_CASING =
			glasscasing("steel_glass_casing", ()-> new SimpleCTBehaviour((ModSpriteShifts.STEEL_GLASS_CASING)));

	public static final BlockEntry<TintedGlassCasing>
			STEEL_TINTED_GLASS_CASING =
			tintedglasscasing("steel_tinted_glass_casing", () -> new SimpleCTBehaviour((ModSpriteShifts.STEEL_TINTED_GLASS_CASING)));

	public static void register() {}
}
