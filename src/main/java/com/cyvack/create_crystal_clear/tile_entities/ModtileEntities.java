package com.cyvack.create_crystal_clear.tile_entities;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.blocks.ModBlocks;
import com.cyvack.create_crystal_clear.compat.blocks.AlloyedCompatBlocks;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.elementary.SimpleKineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogInstance;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogRenderer;
import com.simibubi.create.content.contraptions.relays.encased.ShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.ShaftRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class ModtileEntities {
	private static final CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate();

	/////////

	//Glass Encased Shafts
	public static final BlockEntityEntry<KineticTileEntity> GLASS_ENCASED_SHAFT = REGISTRATE
			.tileEntity("glass_encased_shaft", KineticTileEntity::new)
			.instance(()-> ShaftInstance::new, false)
			.validBlocks(ModBlocks.ANDESITE_GLASS_ENCASED_SHAFT, ModBlocks.ANDESITE_CLEAR_GLASS_ENCASED_SHAFT,
						 ModBlocks.BRASS_GLASS_ENCASED_SHAFT, ModBlocks.BRASS_CLEAR_GLASS_ENCASED_SHAFT,
					     ModBlocks.TRAIN_GLASS_ENCASED_SHAFT, ModBlocks.TRAIN_CLEAR_GLASS_ENCASED_SHAFT,
						 AlloyedCompatBlocks.STEEL_GLASS_ENCASED_SHAFT)
			.renderer(()-> ShaftRenderer::new)
			.register();

	//Glass Encased Small Cogs
	public static final BlockEntityEntry<SimpleKineticTileEntity> GLASS_ENCASED_COG = REGISTRATE
			.tileEntity("glass_encased_cog", SimpleKineticTileEntity::new)
			.instance(()-> EncasedCogInstance::small, false)
			.validBlocks(ModBlocks.ANDESITE_GLASS_ENCASED_COGWHEEL,
						 ModBlocks.ANDESITE_CLEAR_GLASS_ENCASED_COGWHEEL,
						 ModBlocks.BRASS_GLASS_ENCASED_COGWHEEL,
						 ModBlocks.BRASS_CLEAR_GLASS_ENCASED_COGWHEEL,
						 ModBlocks.TRAIN_GLASS_ENCASED_COGWHEEL,
						 ModBlocks.TRAIN_CLEAR_GLASS_ENCASED_COGWHEEL)
			.renderer(()-> EncasedCogRenderer::small)
			.register();

	//Glass Encased Large Cogs
	public static final BlockEntityEntry<SimpleKineticTileEntity> GLASS_ENCASED_LARGE_COG = REGISTRATE
			.tileEntity("glass_encased_large_cog", SimpleKineticTileEntity::new)
			.instance(()-> EncasedCogInstance::large, false)
			.validBlocks(ModBlocks.ANDESITE_GLASS_ENCASED_LARGE_COGWHEEL,
						 ModBlocks.ANDESITE_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL,
						 ModBlocks.BRASS_GLASS_ENCASED_LARGE_COGWHEEL,
						 ModBlocks.BRASS_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL,
						 ModBlocks.TRAIN_GLASS_ENCASED_LARGE_COGWHEEL,
						 ModBlocks.TRAIN_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL)
			.renderer(()-> EncasedCogRenderer::large)
			.register();

	public static void register() {}
}
