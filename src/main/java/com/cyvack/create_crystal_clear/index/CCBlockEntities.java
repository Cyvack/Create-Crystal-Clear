package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.CrystalClear;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CCBlockEntities {
	private static final CreateRegistrate REGISTRATE = CrystalClear.registrate();

//	Glass Encased Shafts
	public static final BlockEntityEntry<KineticBlockEntity> GLASS_ENCASED_SHAFT = REGISTRATE
			.blockEntity("glass_encased_shaft", KineticBlockEntity::new)
			.instance(()-> ShaftInstance::new, false)
			.validBlocks(CCBlocks.GLASS_ENCASED_SHAFTS.toArray())
			.validBlocks(CCBlocks.CLEAR_GLASS_ENCASED_SHAFTS.toArray())
			.renderer(()-> ShaftRenderer::new)
			.register();

	//Glass Encased Small Cogs
	public static final BlockEntityEntry<SimpleKineticBlockEntity> GLASS_ENCASED_COG = REGISTRATE
			.blockEntity("glass_encased_cog", SimpleKineticBlockEntity::new)
			.instance(()-> EncasedCogInstance::small, false)
			.validBlocks(CCBlocks.SMALL_GLASS_ENCASED_COGWHEELS.toArray())
			.validBlocks(CCBlocks.SMALL_CLEAR_GLASS_ENCASED_COGWHEELS.toArray())
			.renderer(()-> EncasedCogRenderer::small)
			.register();

	//Glass Encased Large Cogs
	public static final BlockEntityEntry<SimpleKineticBlockEntity> GLASS_ENCASED_LARGE_COG = REGISTRATE
			.blockEntity("glass_encased_large_cog", SimpleKineticBlockEntity::new)
			.instance(()-> EncasedCogInstance::large, false)
			.validBlocks(CCBlocks.LARGE_GLASS_ENCASED_COGWHEELS.toArray())
			.validBlocks(CCBlocks.LARGE_CLEAR_GLASS_ENCASED_COGWHEELS.toArray())
			.renderer(()-> EncasedCogRenderer::large)
			.register();

	public static void register() {}
}
