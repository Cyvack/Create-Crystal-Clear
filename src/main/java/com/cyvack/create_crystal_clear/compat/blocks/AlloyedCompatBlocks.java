package com.cyvack.create_crystal_clear.compat.blocks;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.blocks.CrystalClearTab;
import com.cyvack.create_crystal_clear.blocks.EmptyBlocks.HiddenGlassCasing;
import com.cyvack.create_crystal_clear.blocks.EmptyBlocks.HiddenTintedGlassCasing;
import com.cyvack.create_crystal_clear.blocks.glass_encased_shaft.GlassEncasedShaftBlock;
import com.cyvack.create_crystal_clear.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.blocks.ModSpriteShifts;
import com.cyvack.create_crystal_clear.blocks.glass_casings.TintedGlassCasing;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Blocks;

import static com.cyvack.create_crystal_clear.data_gen.BlockBuilders.*;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class AlloyedCompatBlocks {
	private static final
	CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate().creativeModeTab(()-> CrystalClearTab.GLASS_TAB);

	//GLASS CASING
	public static final BlockEntry<GlassCasing>
			STEEL_GLASS_CASING =
			REGISTRATE.block("steel_glass_casing", Create_Crystal_Clear.isAlloyedLoaded ? GlassCasing::new : HiddenGlassCasing::new)
			.onRegister(connectedTextures(() -> new SimpleCTBehaviour(ModSpriteShifts.STEEL_GLASS_CASING)))
			.addLayer(() -> RenderType::cutout)
			.initialProperties(() -> Blocks.GLASS)
			.loot(BlockLoot::dropWhenSilkTouch)
			.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", c.getName()))
			.tag(AllTags.AllBlockTags.CASING.tag)
			.item()
			.tag(AllTags.AllItemTags.CASING.tag)
			.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/" + c.getName()), p.modLoc("block/" + c.getName())))
			.build()
			.register();

	//TINTED GLASS CASING
	public static final BlockEntry<TintedGlassCasing>
			STEEL_TINTED_GLASS_CASING =
			REGISTRATE.block("steel_tinted_glass_casing", Create_Crystal_Clear.isAlloyedLoaded ? TintedGlassCasing::new : HiddenTintedGlassCasing::new)
			.onRegister(connectedTextures(()-> new SimpleCTBehaviour(ModSpriteShifts.STEEL_TINTED_GLASS_CASING)))
			.addLayer(() -> RenderType::translucent)
			.initialProperties(() -> Blocks.TINTED_GLASS)
			.loot(BlockLoot::dropWhenSilkTouch)
			.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", c.getName()))
			.tag(AllTags.AllBlockTags.CASING.tag)
			.item()
			.tag(AllTags.AllItemTags.CASING.tag)
			.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/" + c.getName()), p.modLoc("block/" + c.getName())))
			.build()
			.register();

	//ENCASED SHAFTS
	public static final BlockEntry<GlassEncasedShaftBlock>
			STEEL_GLASS_ENCASED_SHAFT =
			REGISTRATE.block("steel_glass_encased_shaft", GlassEncasedShaftBlock::steelglass)
			.transform(glassEncasedShaftBuilder("steel_glass", () -> ModSpriteShifts.omni("steel_glass_casing")))
			.register();


	public static void register() {}
}
