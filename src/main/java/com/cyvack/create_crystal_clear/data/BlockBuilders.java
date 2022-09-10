package com.cyvack.create_crystal_clear.data;

import com.cyvack.create_crystal_clear.Create_Crystal_Clear;
import com.cyvack.create_crystal_clear.GlassEncasedShaftBlock;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCTBehaviour;
import com.simibubi.create.content.contraptions.relays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class BlockBuilders {
	private static final CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate();

	private static @NotNull Properties glassProperties(Properties p) {
		return p.isValidSpawn(BlockBuilders::never)
				.isRedstoneConductor(BlockBuilders::never)
				.isSuffocating(BlockBuilders::never)
				.isViewBlocking(BlockBuilders::never);
	}

	private static boolean never(BlockState p_235436_0_, BlockGetter p_235436_1_, BlockPos p_235436_2_) {
		return false;
	}

	private static Boolean never(BlockState p_235427_0_, BlockGetter p_235427_1_, BlockPos p_235427_2_,
								 EntityType<?> p_235427_3_) {
		return false;
	}

	//Glass Casings
	public static BlockEntry<GlassCasing> glasscasing(String name, Supplier<ConnectedTextureBehaviour> behaviour) {
		return REGISTRATE.block(name, GlassCasing::new)
				.onRegister(connectedTextures(behaviour))
				.addLayer(() -> RenderType::cutout)
				.initialProperties(() -> Blocks.GLASS)
				.properties(BlockBuilders::glassProperties)
				.loot(BlockLoot::dropWhenSilkTouch)
				.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", c.getName()))
				.tag(AllTags.AllBlockTags.CASING.tag)

				.item()
				.tag(AllTags.AllItemTags.CASING.tag)
				.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/" + c.getName()), p.modLoc("block/" + c.getName())))

				.build()
				.register();
	}

	//Tinted Glass Casings
	public static  BlockEntry<TintedGlassCasing> tintedglasscasing(String name, Supplier<ConnectedTextureBehaviour> behaviour){
		return REGISTRATE.block(name, TintedGlassCasing::new)
				.onRegister(connectedTextures(behaviour))
				.addLayer(() -> RenderType::translucent)
				.initialProperties(() -> Blocks.TINTED_GLASS)
				.properties(BlockBuilders::glassProperties)
				.loot(BlockLoot::dropWhenSilkTouch)
				.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", c.getName()))
				.tag(AllTags.AllBlockTags.CASING.tag)

				.item()
				.tag(AllTags.AllItemTags.CASING.tag)
				.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/" + c.getName()), p.modLoc("block/" + c.getName())))

				.build()
				.register();
	}

	//Glass Encased Shafts - TODO
	public static <B extends GlassEncasedShaftBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassencasedShaft(String casing, Supplier<CTSpriteShiftEntry> casingShift) {
		return builder -> glassencasedBase(builder, () -> AllBlocks.SHAFT.get())
				.initialProperties(() -> Blocks.GLASS)
				.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(casingShift.get())))
				.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
						(s, f) -> f.getAxis() != s.getValue(EncasedShaftBlock.AXIS))))
				.addLayer(() -> RenderType::cutout)
				.initialProperties(() -> Blocks.GLASS)
				.properties(BlockBuilders::glassProperties)
				.blockstate((c, p) -> axisBlock(c, p, blockState -> p.models()
						.getExistingFile(p.modLoc("block/glass_encased_shaft/block_" + casing)), true))
				.item()
				.model(AssetLookup.customBlockItemModel("glass_encased_shaft", "item_" + casing))
				.build();
	}

	//Glass Encased Cogwheels - TODO

	//Glass Encased Pipe - TODO


	///////////////////////

	private static <B extends RotatedPillarKineticBlock, P> BlockBuilder<B, P> glassencasedBase(BlockBuilder<B, P> b, Supplier<ItemLike> drop) {
		return b.properties(BlockBehaviour.Properties::noOcclusion)
				.transform(BlockStressDefaults.setNoImpact())
				.loot((p, lb) -> p.dropOther(lb, drop.get()));
	}



}
