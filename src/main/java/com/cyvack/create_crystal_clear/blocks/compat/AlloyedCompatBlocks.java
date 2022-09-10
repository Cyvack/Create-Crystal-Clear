package com.cyvack.create_crystal_clear.blocks.compat;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.CrystalClearTab;
import com.cyvack.create_crystal_clear.GlassEncasedShaftBlock;
import com.cyvack.create_crystal_clear.data.BlockBuilders;
import com.cyvack.create_crystal_clear.data.GlassCasing;
import com.cyvack.create_crystal_clear.data.ModSpriteShifts;
import com.cyvack.create_crystal_clear.data.TintedGlassCasing;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.cyvack.create_crystal_clear.data.BlockBuilders.glasscasing;
import static com.cyvack.create_crystal_clear.data.BlockBuilders.tintedglasscasing;
import static com.simibubi.create.AllTags.axeOrPickaxe;

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
			STEEL_GLASS_ENCASED_SHAFT = REGISTRATE
				.block("steel_glass_encased_shaft", GlassEncasedShaftBlock::steelglass)
				.transform(BlockBuilders.glassencasedShaft("steel_glass", () -> ModSpriteShifts.STEEL_GLASS_CASING))
				.transform(axeOrPickaxe())
				.register();

	public static void register() {}
}
