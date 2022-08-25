package com.cyvack.create_misc;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedShaftBlock;
import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.WindowGen;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;

import static com.cyvack.create_misc.GlassCasings.glasscasing;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class ModBlocks {
		private static final
		CreateRegistrate REGISTRATE = Create_Misc.registrate().creativeModeTab(()-> MiscCreativeTab.MISC_TAB);

	//Casings
	public static final BlockEntry<ConnectedGlassBlock>
			GLASS_ANDESITE_CASING =
			glasscasing("glass_andesite_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.GLASS_ANDESITE_CASING)),
			GLASS_BRASS_CASING =
			glasscasing("glass_brass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.GLASS_BRASS_CASING)),
			GLASS_COPPER_CASING =
			glasscasing("glass_copper_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.GLASS_COPPER_CASING));

	//Clear Casings
	public static final BlockEntry<ConnectedGlassBlock>
			CLEAR_GLASS_ANDESITE_CASING =
			glasscasing("clear_glass_andesite_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.CLEAR_GLASS_ANDESITE_CASING)),
			CLEAR_GLASS_BRASS_CASING =
			glasscasing("clear_glass_brass_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.CLEAR_GLASS_BRASS_CASING)),
			CLEAR_GLASS_COPPER_CASING =
			glasscasing("clear_glass_copper_casing", () -> new SimpleCTBehaviour(ModSpriteShifts.CLEAR_GLASS_COPPER_CASING));




		//Cogs



	public static void register() {}
}
