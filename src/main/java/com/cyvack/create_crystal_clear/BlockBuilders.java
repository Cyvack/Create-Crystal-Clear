package com.cyvack.create_crystal_clear;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCTBehaviour;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class BlockBuilders {
	private static final CreateRegistrate REGISTRATE = Create_Crystal_Clear.registrate();
	private static Properties glassProperties(Properties p) {
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


	public static BlockEntry<ConnectedGlassBlock> glasscasing(String name, Supplier<ConnectedTextureBehaviour> behaviour) {
		return REGISTRATE.block(name, ConnectedGlassBlock::new)
				.onRegister(connectedTextures(behaviour))
				.addLayer(() -> RenderType::cutout)
				.initialProperties(() -> Blocks.GLASS)
				.properties(BlockBuilders::glassProperties)
				.loot(BlockLoot::dropWhenSilkTouch)

				.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "glass_casing/", c.getName()))
				.tag(AllTags.AllBlockTags.CASING.tag)

				.item()
				.tag(AllTags.AllItemTags.CASING.tag)
				.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/glass_casing/" + c.getName()), p.modLoc("block/glass_casing/" + c.getName())))

				.build()
				.register();
	}


	public static <B extends GlassEncasedShaft, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassencasedshaft(String casing, Supplier<CTSpriteShiftEntry> casingShift) {
		return builder -> encasedBase(builder, AllBlocks.SHAFT::get)
				.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(casingShift.get())))
				.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
						(s, f) -> f.getAxis() != s.getValue(GlassEncasedShaft.AXIS))))

				.blockstate((c, p) -> axisBlock(c, p, blockState -> p.models()
						.getExistingFile(p.modLoc("block/encased_shaft/block_" + casing)), true))
				.initialProperties(() -> Blocks.GLASS)
				.properties(BlockBuilders::glassProperties)

				.item()
				.model(AssetLookup.customBlockItemModel("encased_shaft", "item_" + casing))
				.build();
	}

	public static <B extends EncasedCogwheelBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassencasedCogwheel(
			String casing, Supplier<CTSpriteShiftEntry> casingShift) {
		return b -> glassencasedCogwheelBase(b, casing, casingShift, () -> AllBlocks.COGWHEEL.get(), false);
	}







///////////////////////
	private static <B extends RotatedPillarKineticBlock, P> BlockBuilder<B, P> encasedBase(BlockBuilder<B, P> b,Supplier<ItemLike> drop) {
		return b.initialProperties(SharedProperties::stone)
				.properties(BlockBehaviour.Properties::noOcclusion)
				.addLayer(() -> RenderType::cutout)
				.transform(BlockStressDefaults.setNoImpact())
				.loot((p, lb) -> p.dropOther(lb, drop.get()));
	}

	private static <B extends EncasedCogwheelBlock, P> BlockBuilder<B, P> glassencasedCogwheelBase(BlockBuilder<B, P> b, String casing, Supplier<CTSpriteShiftEntry> casingShift, Supplier<ItemLike> drop, boolean large) {
		String encasedSuffix = "_encased_cogwheel_side" + (large ? "_connected" : "");
		String blockFolder = large ? "encased_large_cogwheel" : "encased_cogwheel";
		String wood = casing.equals("brass") ? "dark_oak" : "spruce";
		return encasedBase(b, drop).addLayer(() -> RenderType::cutoutMipped)
				.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
						(s, f) -> f.getAxis() == s.getValue(EncasedCogwheelBlock.AXIS)
								&& !s.getValue(f.getAxisDirection() == Direction.AxisDirection.POSITIVE ? EncasedCogwheelBlock.TOP_SHAFT
								: EncasedCogwheelBlock.BOTTOM_SHAFT))))

				.blockstate((c, p) -> axisBlock(c, p, blockState -> {
					String suffix = (blockState.getValue(EncasedCogwheelBlock.TOP_SHAFT) ? "_top" : "")
							+ (blockState.getValue(EncasedCogwheelBlock.BOTTOM_SHAFT) ? "_bottom" : "");
					String modelName = c.getName() + suffix;
					return p.models()
							.withExistingParent(modelName, p.modLoc("block/" + blockFolder + "/block" + suffix))
							.texture("casing", Create_Crystal_Clear.asResource("block/" + casing + "_casing"))
							.texture("1", new ResourceLocation("block/stripped_" + wood + "_log_top"))
							.texture("side", Create_Crystal_Clear.asResource("block/" + casing + encasedSuffix));
				}, false))

				.item()
				.model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + blockFolder + "/item"))
						.texture("casing", Create_Crystal_Clear.asResource("block/" + casing + "_casing"))
						.texture("1", new ResourceLocation("block/stripped_" + wood + "_log_top"))
						.texture("side", Create_Crystal_Clear.asResource("block/" + casing + encasedSuffix)))
				.build();
	}
}
