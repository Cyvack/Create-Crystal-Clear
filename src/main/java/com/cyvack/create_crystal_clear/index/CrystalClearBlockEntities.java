package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.CrystalClear;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CrystalClearBlockEntities {
	private static final CreateRegistrate REGISTRATE = CrystalClear.REGISTRATE.creativeModeTab(() -> CrystalClearTab.MAIN_GROUP, "Crystal Clear");

	//Glass Encased Shafts
	public static final BlockEntityEntry<KineticBlockEntity> GLASS_ENCASED_SHAFT = REGISTRATE
			.blockEntity("glass_encased_shaft", KineticBlockEntity::new)
			.instance(()-> ShaftInstance::new, false)
			.validBlocks(ModBlocks.ANDESITE_GLASS_ENCASED_SHAFT, ModBlocks.ANDESITE_CLEAR_GLASS_ENCASED_SHAFT,
						 ModBlocks.BRASS_GLASS_ENCASED_SHAFT, ModBlocks.BRASS_CLEAR_GLASS_ENCASED_SHAFT,
					     ModBlocks.TRAIN_GLASS_ENCASED_SHAFT, ModBlocks.TRAIN_CLEAR_GLASS_ENCASED_SHAFT)
			.renderer(()-> ShaftRenderer::new)
			.register();

	//Glass Encased Small Cogs
	public static final BlockEntityEntry<SimpleKineticBlockEntity> GLASS_ENCASED_COG = REGISTRATE
			.blockEntity("glass_encased_cog", SimpleKineticBlockEntity::new)
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
	public static final BlockEntityEntry<SimpleKineticBlockEntity> GLASS_ENCASED_LARGE_COG = REGISTRATE
			.blockEntity("glass_encased_large_cog", SimpleKineticBlockEntity::new)
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
