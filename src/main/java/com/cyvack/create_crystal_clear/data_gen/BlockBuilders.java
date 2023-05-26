package com.cyvack.create_crystal_clear.data_gen;

import com.cyvack.create_crystal_clear.CrystalClear;
import com.cyvack.create_crystal_clear.content.blocks.GlassCasing;
import com.cyvack.create_crystal_clear.content.blocks.GlassEncasedCogwheel;
import com.cyvack.create_crystal_clear.content.blocks.GlassEncasedShaft;
import com.cyvack.create_crystal_clear.index.CCSpriteShifts;
import com.cyvack.create_crystal_clear.index.GlassCTBehaviours.GlassEncasedCTBehaviour;
import com.cyvack.create_crystal_clear.index.GlassCTBehaviours.GlassEncasedCogCTBehaviour;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class BlockBuilders {

	// Tell Registrate to create a lang entry for the item groups
	private static final CreateRegistrate REGISTRATE = CrystalClear.registrate();

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
	public static BlockEntry<GlassCasing> glassCasing(String name, boolean clear) {
		String newName = !clear ? name + "_glass_casing" : name + "_clear_glass_casing";
		CTSpriteShiftEntry ctEntry = CCSpriteShifts.omni(newName);

		return REGISTRATE.block(newName, GlassCasing::new)
				.initialProperties(() -> Blocks.GLASS)
				.properties(p -> p.sound(SoundType.GLASS))
				.properties(BlockBehaviour.Properties::noOcclusion)
				.addLayer(() -> RenderType::cutout)
				.blockstate((c, p) -> p.simpleBlock(c.get()))
				.onRegister(connectedTextures(() -> new SimpleCTBehaviour(ctEntry)))
				.tag(AllTags.AllBlockTags.CASING.tag)
				.item()
				.tag(AllTags.AllItemTags.CASING.tag)
				.build()
				.register();
	}

	/**
	 * TODO: make this not create 200000000 different block files in the same file
	 * @param casing String representative of desired casing type
	 * @param clear Whether this block is clear glass
	 * @param factory Base factory for block
	 */
	public static BlockEntry<GlassEncasedShaft> glassEncasedShaft(String casing, Boolean clear, NonNullFunction<Properties, GlassEncasedShaft> factory){
		String newName = casing + (!clear ? "_glass_encased_shaft" : "_clear_glass_encased_shaft");

		return 	REGISTRATE
				.block(newName, factory)
				.initialProperties(() -> Blocks.GLASS)
				.transform(glassEncasedShaftBuilder(casing + (!clear ? "_glass" : "_clear_glass"), () -> CCSpriteShifts.omni(casing + (!clear ? "_glass_casing" : "_clear_glass_casing"))))
				.transform(pickaxeOnly())

				.transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))

				.register();
	}

	public static <B extends GlassEncasedShaft, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedShaftBuilder(String casing, Supplier<CTSpriteShiftEntry> ctEntry) {
		return builder -> glassencasedBase(builder, AllBlocks.SHAFT::get)
				.addLayer(() -> RenderType::cutout)
				.onRegister(CreateRegistrate.connectedTextures(() -> new GlassEncasedCTBehaviour(ctEntry.get())))
				.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, ctEntry.get(), (state, face) -> face.getAxis() != state.getValue(GlassEncasedShaft.AXIS))))
				.blockstate((c, p) -> axisBlock(c, p, blockState -> p.models()
						.getExistingFile(p.modLoc("block/glass_encased_shaft/block_" + casing)), true))
				.item()
				.model(AssetLookup.customBlockItemModel("glass_encased_shaft", "item_" + casing))
				.build();
	}

	//Glass Encased Cogwheels
	//Entry
	public static BlockEntry<GlassEncasedCogwheel> glassEncasedCogwheel(String casingType, Boolean large, Boolean clear, NonNullFunction<Properties, GlassEncasedCogwheel> factory){
		String name = clear? casingType+"_clear" : casingType;
		return !large?
			//small cog
			REGISTRATE
			.block(name+"_glass_encased_cogwheel", factory)
			.transform(BlockBuilders.glassEncasedSmallCogwheel(casingType, clear,
					()-> CCSpriteShifts.omni(name+"_glass_casing")))
			.onRegister(CreateRegistrate.connectedTextures(() -> new GlassEncasedCogCTBehaviour(CCSpriteShifts.omni(name+"_glass_casing"),
					Couple.create(CCSpriteShifts.vertical("encased_cogwheels/" + casingType +"_encased_cogwheel_side"),
					CCSpriteShifts.horizontal("encased_cogwheels/" + casingType +"_encased_cogwheel_side")))))
			.register() :
			//Large Cog
			REGISTRATE
			.block(name+ "_glass_encased_large_cogwheel", factory)
			.transform(BlockBuilders.glassEncasedLargeCogwheel(casingType, clear,
					() -> CCSpriteShifts.omni(name+"_glass_casing")))
			.register();
	}

	//Builders
	public static <B extends GlassEncasedCogwheel, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedSmallCogwheel(
			String casing, Boolean clear, Supplier<CTSpriteShiftEntry> casingShift) {
		return b -> glassEncasedCogwheelBase(b, casing, clear, casingShift, AllBlocks.COGWHEEL::get, false);
	}

	public static <B extends GlassEncasedCogwheel, P> NonNullUnaryOperator<BlockBuilder<B, P>> glassEncasedLargeCogwheel(
			String casing, Boolean clear, Supplier<CTSpriteShiftEntry> casingShift) {
		return b -> glassEncasedCogwheelBase(b, casing, clear, casingShift, AllBlocks.COGWHEEL::get, true)
			.onRegister(CreateRegistrate.connectedTextures(() -> new GlassEncasedCogCTBehaviour(casingShift.get())));
	}

	//----------------------------//

	//Glass Encased Cogwheel Base
	private static <B extends GlassEncasedCogwheel, P> BlockBuilder<B, P> glassEncasedCogwheelBase(BlockBuilder<B, P> b,
		String casingType, Boolean clear, Supplier<CTSpriteShiftEntry> casingShift, Supplier<ItemLike> drop, boolean large) {

		String casing = clear? casingType+"_clear_glass" : casingType+"_glass";

		String encasedSuffix = "_encased_cogwheel_side" + (large ? "_connected" : "");
		String blockFolder = large ? "encased_large_cogwheel" : "encased_cogwheel";

		return glassencasedBase(b, drop)
				.addLayer(() -> RenderType::cutout)
				.initialProperties(() -> Blocks.GLASS)
				.onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
						(s, f) -> f.getAxis() == s.getValue(GlassEncasedCogwheel.AXIS)
								&& !s.getValue(f.getAxisDirection() == Direction.AxisDirection.POSITIVE ? GlassEncasedCogwheel.TOP_SHAFT
								: GlassEncasedCogwheel.BOTTOM_SHAFT))))
				.blockstate((c, p) -> axisBlock(c, p, blockState -> {
					String suffix = (blockState.getValue(GlassEncasedCogwheel.TOP_SHAFT) ? "_top" : "")
							+ (blockState.getValue(GlassEncasedCogwheel.BOTTOM_SHAFT) ? "_bottom" : "");
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
				.transform(EncasingRegistry.addVariantTo( large ? AllBlocks.LARGE_COGWHEEL : AllBlocks.COGWHEEL))
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
