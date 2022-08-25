package com.cyvack.create_misc;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class GlassCasings {
	private static final CreateRegistrate REGISTRATE = Create_Misc.registrate();
	private static Properties glassProperties(Properties p) {
		return p.isValidSpawn(GlassCasings::never)
				.isRedstoneConductor(GlassCasings::never)
				.isSuffocating(GlassCasings::never)
				.isViewBlocking(GlassCasings::never);
	}

	private static boolean never(BlockState p_235436_0_, BlockGetter p_235436_1_, BlockPos p_235436_2_) {
		return false;
	}

	private static Boolean never(BlockState p_235427_0_, BlockGetter p_235427_1_, BlockPos p_235427_2_,
								 EntityType<?> p_235427_3_) {
		return false;
	}


	public static BlockEntry<ConnectedGlassBlock> glasscasing(String name, Supplier<ConnectedTextureBehaviour> behaviour) {
		return REGISTRATE.block(name, ConnectedGlassBlock::new)
				.onRegister(connectedTextures(behaviour))
				.addLayer(() -> RenderType::cutout)
				.initialProperties(() -> Blocks.GLASS)
				.properties(GlassCasings::glassProperties)
				.loot(BlockLoot::dropWhenSilkTouch)
				.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "glass_casing/", c.getName()))
				.tag(AllTags.AllBlockTags.CASING.tag)
				.item()
				.tag(AllTags.AllItemTags.CASING.tag)
				.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/glass_casing/" + c.getName()), p.modLoc("block/glass_casing/" + c.getName())))
				.build()
				.register();
	}

}
