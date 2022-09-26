package com.cyvack.create_crystal_clear.compat.tile_entities;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.compat.blocks.AlloyedCompatBlocks;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.ShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.ShaftRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AlloyedTileEntities {
	private static final CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate();

	public static final BlockEntityEntry<KineticTileEntity> STEEL_GLASS_ENCASED_SHAFT = REGISTRATE
			.tileEntity("steel_glass_encased_shaft", KineticTileEntity::new)
			.instance(()-> ShaftInstance::new, false)
			.validBlocks(AlloyedCompatBlocks.STEEL_GLASS_ENCASED_SHAFT)
			.renderer(()-> ShaftRenderer::new)
			.register();
	public static void register(){};
}
