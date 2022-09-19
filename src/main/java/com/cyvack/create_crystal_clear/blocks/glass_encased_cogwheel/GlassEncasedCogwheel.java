package com.cyvack.create_crystal_clear.blocks.glass_encased_cogwheel;

import com.cyvack.create_crystal_clear.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.blocks.ModBlocks;
import com.cyvack.create_crystal_clear.blocks.glass_encased_shaft.GlassEncasedShaftBlock;
import com.cyvack.create_crystal_clear.tile_entities.ModtileEntities;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.base.IRotate;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.contraptions.components.structureMovement.ITransformableBlock;
import com.simibubi.create.content.contraptions.components.structureMovement.StructureTransform;
import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import com.simibubi.create.content.contraptions.relays.elementary.SimpleKineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.schematics.ISpecialBlockItemRequirement;
import com.simibubi.create.content.schematics.ItemRequirement;
import com.simibubi.create.foundation.block.ITE;
import com.simibubi.create.foundation.utility.VoxelShaper;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlassEncasedCogwheel extends RotatedPillarKineticBlock implements ICogWheel, ITE<SimpleKineticTileEntity>, ISpecialBlockItemRequirement, ITransformableBlock {
	public static final BooleanProperty TOP_SHAFT = BooleanProperty.create("top_shaft");
	public static final BooleanProperty BOTTOM_SHAFT = BooleanProperty.create("bottom_shaft");

	boolean isLarge;
	private BlockEntry<GlassCasing> casing;

	public static GlassEncasedCogwheel andesite_glass(boolean large, Properties properties) {
		return new GlassEncasedCogwheel(large, properties, ModBlocks.ANDESITE_GLASS_CASING);
	}

	public static GlassEncasedCogwheel andesite_clear_glass(boolean large, Properties properties) {
		return new GlassEncasedCogwheel(large, properties, ModBlocks.ANDESITE_CLEAR_GLASS_CASING);
	}

	public static GlassEncasedCogwheel brass_glass(boolean large, Properties properties) {
		return new GlassEncasedCogwheel(large, properties, ModBlocks.BRASS_GLASS_CASING);
	}

	public static GlassEncasedCogwheel brass_clear_glass(boolean large, Properties properties) {
		return new GlassEncasedCogwheel(large, properties, ModBlocks.BRASS_CLEAR_GLASS_CASING);
	}

	public static GlassEncasedCogwheel train_glass(boolean large, Properties properties) {
		return new GlassEncasedCogwheel(large, properties, ModBlocks.TRAIN_GLASS_CASING);
	}

	public static GlassEncasedCogwheel train_clear_glass(boolean large, Properties properties) {
		return new GlassEncasedCogwheel(large, properties, ModBlocks.TRAIN_CLEAR_GLASS_CASING);
	}

	public GlassEncasedCogwheel(boolean large, Properties properties, BlockEntry<GlassCasing> casing) {
		super(properties);
		isLarge = large;
		this.casing = casing;
		registerDefaultState(defaultBlockState().setValue(TOP_SHAFT, false)
				.setValue(BOTTOM_SHAFT, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder.add(TOP_SHAFT, BOTTOM_SHAFT));
	}

	@Override
	public void fillItemCategory(CreativeModeTab pTab, NonNullList<ItemStack> pItems) {}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		if (target instanceof BlockHitResult)
			return ((BlockHitResult) target).getDirection()
					.getAxis() != getRotationAxis(state)
					? isLarge ? AllBlocks.LARGE_COGWHEEL.asStack() : AllBlocks.COGWHEEL.asStack()
					: getCasing().asStack();
		return super.getCloneItemStack(state, target, world, pos, player);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState placedOn = context.getLevel()
				.getBlockState(context.getClickedPos()
						.relative(context.getClickedFace()
								.getOpposite()));
		BlockState stateForPlacement = super.getStateForPlacement(context);
		if (ICogWheel.isSmallCog(placedOn))
			stateForPlacement =
					stateForPlacement.setValue(AXIS, ((IRotate) placedOn.getBlock()).getRotationAxis(placedOn));
		return stateForPlacement;
	}

	public BlockEntry<GlassCasing> getCasing() {
		return casing;
	}

	@Override
	public InteractionResult onWrenched(BlockState state, UseOnContext context) {
		if (context.getClickedFace()
				.getAxis() != state.getValue(AXIS))
			return super.onWrenched(state, context);

		Level level = context.getLevel();
		if (level.isClientSide)
			return InteractionResult.SUCCESS;

		BlockPos pos = context.getClickedPos();
		KineticTileEntity.switchToBlockState(level, pos, state.cycle(context.getClickedFace()
				.getAxisDirection() == Direction.AxisDirection.POSITIVE ? TOP_SHAFT : BOTTOM_SHAFT));
		playRotateSound(level, pos);
		return InteractionResult.SUCCESS;
	}

	@Override
	public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) {
		originalState = swapShaftsForRotation(originalState, Rotation.CLOCKWISE_90, targetedFace.getAxis());
		return originalState.setValue(RotatedPillarKineticBlock.AXIS,
				VoxelShaper
						.axisAsFace(originalState.getValue(RotatedPillarKineticBlock.AXIS))
						.getClockWise(targetedFace.getAxis())
						.getAxis());
	}

	@Override
	public InteractionResult onSneakWrenched(BlockState state, UseOnContext context) {
		if (context.getLevel().isClientSide)
			return InteractionResult.SUCCESS;
		context.getLevel()
				.levelEvent(2001, context.getClickedPos(), Block.getId(state));
		KineticTileEntity.switchToBlockState(context.getLevel(), context.getClickedPos(),
				(isLarge ? AllBlocks.LARGE_COGWHEEL : AllBlocks.COGWHEEL).getDefaultState()
						.setValue(AXIS, state.getValue(AXIS)));
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
		return face.getAxis() == state.getValue(AXIS)
				&& state.getValue(face.getAxisDirection() == Direction.AxisDirection.POSITIVE ? TOP_SHAFT : BOTTOM_SHAFT);
	}

	@Override
	protected boolean areStatesKineticallyEquivalent(BlockState oldState, BlockState newState) {
		if (newState.getBlock() instanceof EncasedCogwheelBlock
				&& oldState.getBlock() instanceof EncasedCogwheelBlock) {
			if (newState.getValue(TOP_SHAFT) != oldState.getValue(TOP_SHAFT))
				return false;
			if (newState.getValue(BOTTOM_SHAFT) != oldState.getValue(BOTTOM_SHAFT))
				return false;
		}
		return super.areStatesKineticallyEquivalent(oldState, newState);
	}

	@Override
	public boolean isSmallCog() {
		return !isLarge;
	}

	@Override
	public boolean isLargeCog() {
		return isLarge;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		return CogWheelBlock.isValidCogwheelPosition(ICogWheel.isLargeCog(state), worldIn, pos, state.getValue(AXIS));
	}

	@Override
	public Direction.Axis getRotationAxis(BlockState state) {
		return state.getValue(AXIS);
	}

	public BlockState swapShafts(BlockState state) {
		boolean bottom = state.getValue(BOTTOM_SHAFT);
		boolean top = state.getValue(TOP_SHAFT);
		state = state.setValue(BOTTOM_SHAFT, top);
		state = state.setValue(TOP_SHAFT, bottom);
		return state;
	}

	public BlockState swapShaftsForRotation(BlockState state, Rotation rotation, Direction.Axis rotationAxis) {
		if (rotation == Rotation.NONE) {
			return state;
		}

		Direction.Axis axis = state.getValue(AXIS);
		if (axis == rotationAxis) {
			return state;
		}

		if (rotation == Rotation.CLOCKWISE_180) {
			return swapShafts(state);
		}

		boolean clockwise = rotation == Rotation.CLOCKWISE_90;

		if (rotationAxis == Direction.Axis.X) {
			if (	   axis == Direction.Axis.Z && !clockwise
					|| axis == Direction.Axis.Y && clockwise) {
				return swapShafts(state);
			}
		} else if (rotationAxis == Direction.Axis.Y) {
			if (	   axis == Direction.Axis.X && !clockwise
					|| axis == Direction.Axis.Z && clockwise) {
				return swapShafts(state);
			}
		} else if (rotationAxis == Direction.Axis.Z) {
			if (	   axis == Direction.Axis.Y && !clockwise
					|| axis == Direction.Axis.X && clockwise) {
				return swapShafts(state);
			}
		}

		return state;
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		Direction.Axis axis = state.getValue(AXIS);
		if (axis == Direction.Axis.X && mirror == Mirror.FRONT_BACK
				|| axis == Direction.Axis.Z && mirror == Mirror.LEFT_RIGHT) {
			return swapShafts(state);
		}
		return state;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		state = swapShaftsForRotation(state, rotation, Direction.Axis.Y);
		return super.rotate(state, rotation);
	}

	@Override
	public BlockState transform(BlockState state, StructureTransform transform) {
		if (transform.mirror != null) {
			state = mirror(state, transform.mirror);
		}

		if (transform.rotationAxis == Direction.Axis.Y) {
			return rotate(state, transform.rotation);
		}

		state = swapShaftsForRotation(state, transform.rotation, transform.rotationAxis);
		state = state.setValue(AXIS, transform.rotateAxis(state.getValue(AXIS)));
		return state;
	}

	@Override
	public ItemRequirement getRequiredItems(BlockState state, BlockEntity te) {
		return ItemRequirement
				.of(isLarge ? AllBlocks.LARGE_COGWHEEL.getDefaultState() : AllBlocks.COGWHEEL.getDefaultState(), te);
	}

	@Override
	public Class<SimpleKineticTileEntity> getTileEntityClass() {
		return SimpleKineticTileEntity.class;
	}

	@Override
	public BlockEntityType<? extends SimpleKineticTileEntity> getTileEntityType() {
		return isLarge ? ModtileEntities.GLASS_ENCASED_LARGE_COG.get() : ModtileEntities.GLASS_ENCASED_COG.get();
	}

	@SuppressWarnings("deprecation")
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction side) {
		return ((pState.getBlock() instanceof GlassEncasedCogwheel) && (pAdjacentBlockState.getBlock() instanceof GlassEncasedCogwheel));
	}

}
