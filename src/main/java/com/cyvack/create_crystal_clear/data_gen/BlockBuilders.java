package com.cyvack.create_crystal_clear.data_gen;

import com.cyvack.create_crystal_clear.CrystalClear;
import com.cyvack.create_crystal_clear.content.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.content.blocks.glass_casings.TintedGlassCasing;
import com.cyvack.create_crystal_clear.content.blocks.glass_encased_cogwheel.NewGlassEncasedCogwheelBlock;
import com.cyvack.create_crystal_clear.content.blocks.glass_encased_shaft.NewGlassEncasedShaftBlock;
import com.cyvack.create_crystal_clear.index.CrystalClearTab;
import com.cyvack.create_crystal_clear.index.ModSpriteShifts;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
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

	// Tell Registrate to create a lang entry for the item groups
	private static final CreateRegistrate REGISTRATE = CrystalClear.REGISTRATE.creativeModeTab(() -> CrystalClearTab.MAIN_GROUP, "Crystal Clear");

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
		//Entry
		public static BlockEntry<GlassCasing> glasscasing(String name, Supplier<ConnectedTextureBehaviour> behaviour, Supplier<Block> resultingClearCasing) {
			return REGISTRATE.block(name, p -> new GlassCasing(p, resultingClearCasing))
					.onRegister(connectedTextures(behaviour))
					.addLayer(() -> RenderType::cutout)
					.initialProperties(() -> Blocks.GLASS)
//					.loot(BlockLoot::dropWhenSilkTouch)
					.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", c.getName()))
					.tag(AllTags.AllBlockTags.CASING.tag)
					.item()
					.tag(AllTags.AllItemTags.CASING.tag)
					.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/" + c.getName()), p.modLoc("block/" + c.getName())))
					.build()
					.register();
		}

	//Tinted Glass Casings
		//Entry
		public static  BlockEntry<TintedGlassCasing> tintedglasscasing(String name, Supplier<ConnectedTextureBehaviour> behaviour){
			return REGISTRATE.block(name, TintedGlassCasing::new)
				.onRegister(connectedTextures(behaviour))
				.addLayer(() -> RenderType::translucent)
				.initialProperties(() -> Blocks.TINTED_GLASS)
//				.loot(BlockLoot::dropWhenSilkTouch)
				.blockstate((c, p) -> BlockStateGen.cubeAll(c, p, "", c.getName()))
				.tag(AllTags.AllBlockTags.CASING.tag)

				.item()
				.tag(AllTags.AllItemTags.CASING.tag)
				.model((c, p) -> p.cubeColumn(c.getName(), p.modLoc("block/" + c.getName()), p.modLoc("block/" + c.getName())))

				.build()
				.register();
		}

	//Glass Encased Shafts

		//Entry
		public static BlockEntry<NewGlassEncasedShaftBlock> glassEncasedShaft(String casingType, Boolean clear, NonNullFunction<Properties, NewGlassEncasedShaftBlock> factory){
			String name = clear?  casingType + "_clear":casingType;
			return 	REGISTRATE
					.block(name + "_glass_encased_shaft", factory)
					.transform(glassEncasedShaftBuilder(name + "_glass", () -> ModSpriteShifts.omni(name+"_glass_casing")))
					.register();
		}

		//Builder
		public static <B extends NewGlassEncasedShaftBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedShaftBuilder(String casing, Supplier<CTSpriteShiftEntry> casingShift) {
			return builder -> glassencasedBase(builder, AllBlocks.SHAFT::get)
					.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(casingShift.get())))
					.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
							(s, f) -> f.getAxis() != s.getValue(EncasedShaftBlock.AXIS))))
					.addLayer(() -> RenderType::cutout)
					.initialProperties(() -> Blocks.GLASS)
					.blockstate((c, p) -> axisBlock(c, p, blockState -> p.models()
							.getExistingFile(p.modLoc("block/glass_encased_shaft/block_" + casing)), true))
					.transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
					.item()
					.model(AssetLookup.customBlockItemModel("glass_encased_shaft", "item_" + casing))
					.build();
		}


	//Glass Encased Cogwheels
		//Entry
		public static BlockEntry<NewGlassEncasedCogwheelBlock> glassEncasedCogwheel(String casingType, Boolean large, Boolean clear, NonNullFunction<Properties, NewGlassEncasedCogwheelBlock> factory){
			String name = clear? casingType+"_clear" : casingType;
			return !large?
				//small cog
				REGISTRATE
				.block(name+"_glass_encased_cogwheel", factory)
				.transform(BlockBuilders.NewGlassEncasedCogwheelBlock(casingType, clear,
						()-> ModSpriteShifts.omni(name+"_glass_casing")))
				.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(ModSpriteShifts.omni(name+"_glass_casing"),
						Couple.create(ModSpriteShifts.vertical("encased_cogwheels/" + casingType +"_encased_cogwheel_side"),
						ModSpriteShifts.horizontal("encased_cogwheels/" + casingType +"_encased_cogwheel_side")))))
				.register() :
				//Large Cog
				REGISTRATE
				.block(name+ "_glass_encased_large_cogwheel", factory)
				.transform(BlockBuilders.glassencasedLargeCogwheel(casingType, clear,
						() -> ModSpriteShifts.omni(name+"_glass_casing")))
				.register();
		}

		//Builders
		public static <B extends NewGlassEncasedCogwheelBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> NewGlassEncasedCogwheelBlock(
				String casing, Boolean clear, Supplier<CTSpriteShiftEntry> casingShift) {
			return b -> glassEncasedCogwheelBase(b, casing, clear, casingShift, AllBlocks.COGWHEEL::get, false);
		}

		public static <B extends NewGlassEncasedCogwheelBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassencasedLargeCogwheel(
				String casing, Boolean clear, Supplier<CTSpriteShiftEntry> casingShift) {
			return b -> glassEncasedCogwheelBase(b, casing, clear, casingShift, AllBlocks.COGWHEEL::get, true)
				.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(casingShift.get())));
		}

	//----------------------------//

	//Glass Encased Cogwheel Base
	private static <B extends NewGlassEncasedCogwheelBlock, P> BlockBuilder<B, P> glassEncasedCogwheelBase(BlockBuilder<B, P> b,
	String casingType, Boolean clear, Supplier<CTSpriteShiftEntry> casingShift, Supplier<ItemLike> drop, boolean large) {

		String casing = clear? casingType+"_clear_glass" : casingType+"_glass";

		String encasedSuffix = "_encased_cogwheel_side" + (large ? "_connected" : "");
		String blockFolder = large ? "encased_large_cogwheel" : "encased_cogwheel";

		return glassencasedBase(b, drop)
				.addLayer(() -> RenderType::cutout)
				.initialProperties(() -> Blocks.GLASS)
				.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
						(s, f) -> f.getAxis() == s.getValue(NewGlassEncasedCogwheelBlock.AXIS)
								&& !s.getValue(f.getAxisDirection() == Direction.AxisDirection.POSITIVE ? NewGlassEncasedCogwheelBlock.TOP_SHAFT
								: NewGlassEncasedCogwheelBlock.BOTTOM_SHAFT))))
				.blockstate((c, p) -> axisBlock(c, p, blockState -> {
					String suffix = (blockState.getValue(NewGlassEncasedCogwheelBlock.TOP_SHAFT) ? "_top" : "")
							+ (blockState.getValue(NewGlassEncasedCogwheelBlock.BOTTOM_SHAFT) ? "_bottom" : "");
					String modelName = c.getName() + suffix;
				return p.models()
					.withExistingParent(modelName, p.modLoc("block/" + blockFolder + "/block" + suffix))
					//Normal Casing
					.texture("casing", CrystalClear.asResource("block/" + casing + "_casing"))
					//Backing
					.texture("1", getBacking(casingType))
					//Gearbox
					.texture(large?"3":"4", casingType.equals("andesite")? Create.asResource("block/gearbox"):getGearbox(casingType+"_"))
					//Side Casing
					.texture("side", getSiding(casingType, encasedSuffix));
				}, false))
				.transform(EncasingRegistry.addVariantTo(large ? AllBlocks.LARGE_COGWHEEL : AllBlocks.COGWHEEL))
				.item()
				.model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + blockFolder + "/item"))
					.texture("casing", CrystalClear.asResource("block/" + casing + "_casing"))
					//Backing
					.texture("1", getBacking(casingType))
					//Gearbox
					.texture(large?"3":"4", casingType.equals("andesite")? Create.asResource("block/gearbox"):getGearbox(casingType+"_"))
					//Side Casing
					.texture("side", getSiding(casingType, encasedSuffix)))
				.build();
	}

	private static ResourceLocation getBacking(String backing){
			return backing.equals("andesite")? new ResourceLocation("block/stripped_spruce_log_top") :
					backing.equals("brass") ? new ResourceLocation("block/stripped_dark_oak_log_top") :
					CrystalClear.asResource("block/" + backing + "_backing");
	}

	private static ResourceLocation getGearbox(String opening){
			return 	opening.equals("brass_") ?
					Create.asResource("block/" + opening + "gearbox") :
					CrystalClear.asResource("block/" + opening + "gearbox");
	}

	private static ResourceLocation getSiding(String siding, String encasedSuffix){
		return CrystalClear.asResource("block/encased_cogwheels/" + siding + encasedSuffix);
	}

	private static <B extends RotatedPillarKineticBlock, P> BlockBuilder<B, P> glassencasedBase(BlockBuilder<B, P> b, Supplier<ItemLike> drop) {
		return b.properties(BlockBehaviour.Properties::noOcclusion)
				.transform(BlockStressDefaults.setNoImpact())
				.loot((p, lb) -> p.dropOther(lb, drop.get()));
	}
}
