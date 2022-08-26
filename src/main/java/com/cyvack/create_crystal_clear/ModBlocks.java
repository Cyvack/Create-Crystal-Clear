package com.cyvack.create_crystal_clear;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedShaftBlock;
import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static com.cyvack.create_crystal_clear.BlockBuilders.glasscasing;

public class ModBlocks {
	private static final
		CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(()-> MiscCreativeTab.GLASS_TAB);



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

	public static final BlockEntry<GlassEncasedShaft>
			GLASS_ANDESITE_ENCASED_SHAFT = REGISTRATE
				.block("andesite_glass_encased_shaft", GlassEncasedShaft::andesite_glass)
				.transform(BlockBuilders.glassencasedshaft("andesite_glass_casing", () -> ModSpriteShifts.ANDESITE_GLASS_CASING))
				.register(),

			GLASS_BRASS_ENCASED_SHAFT = REGISTRATE
				.block("brass_glass_encased_shaft", GlassEncasedShaft::brass_glass)
				.transform(BlockBuilders.glassencasedshaft("brass_glass_casing", () -> ModSpriteShifts.BRASS_GLASS_CASING))
				.register();


/*
	public static final BlockEntry<EncasedCogwheelBlock> ANDESITE_GLASS_ENCASED_COGWHEEL = REGISTRATE
			.block("andesite_encased_cogwheel", p -> EncasedCogwheelBlock.andesite(false, p))
			.transform(BlockBuilders.glassencasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING))
			.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
					Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
							AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
			.register();
*/



	public static void register() {}
}
