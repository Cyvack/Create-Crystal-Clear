package com.cyvack.create_crystal_clear;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTileEntities;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.AbstractEncasedShaftBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedShaftBlock;
import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import com.simibubi.create.content.schematics.ISpecialBlockItemRequirement;
import com.simibubi.create.content.schematics.ItemRequirement;
import com.simibubi.create.foundation.block.ITE;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class GlassEncasedShaft extends AbstractEncasedShaftBlock
		implements ITE<KineticTileEntity>, ISpecialBlockItemRequirement {

	private BlockEntry<ConnectedGlassBlock> glasscasing;

	public static GlassEncasedShaft andesite_glass(Properties properties) {
		return new GlassEncasedShaft(properties, ModBlocks.ANDESITE_GLASS_CASING);
	}

	public static GlassEncasedShaft brass_glass(Properties properties) {
		return new GlassEncasedShaft(properties, ModBlocks.BRASS_GLASS_CASING);
	}

	public static GlassEncasedShaft andesite_clear_glass(Properties properties) {
		return new GlassEncasedShaft(properties, ModBlocks.ANDESITE_CLEAR_GLASS_CASING);
	}

	public static GlassEncasedShaft brass_clear_glass(Properties properties) {
		return new GlassEncasedShaft(properties, ModBlocks.BRASS_CLEAR_GLASS_CASING);
	}


	protected GlassEncasedShaft(Properties properties, BlockEntry<ConnectedGlassBlock> glasscasing) {
		super(properties);
		this.glasscasing = glasscasing;
	}

	public BlockEntry<ConnectedGlassBlock> getCasing() {
		return glasscasing;
	}

	@Override
	public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
		return pState.getBlock() == pAdjacentBlockState.getBlock()
				&& pState.getValue(AXIS) == pAdjacentBlockState.getValue(AXIS);
	}

	@Override
	public InteractionResult onSneakWrenched(BlockState state, UseOnContext context) {
		if (context.getLevel().isClientSide)
			return InteractionResult.SUCCESS;
		context.getLevel()
				.levelEvent(2001, context.getClickedPos(), Block.getId(state));
		KineticTileEntity.switchToBlockState(context.getLevel(), context.getClickedPos(),
				AllBlocks.SHAFT.getDefaultState()
						.setValue(AXIS, state.getValue(AXIS)));
		return InteractionResult.SUCCESS;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		if (target instanceof BlockHitResult)
			return ((BlockHitResult) target).getDirection()
					.getAxis() == getRotationAxis(state) ? AllBlocks.SHAFT.asStack() : getCasing().asStack();
		return super.getCloneItemStack(state, target, world, pos, player);
	}

	@Override
	public ItemRequirement getRequiredItems(BlockState state, BlockEntity te) {
		return ItemRequirement.of(AllBlocks.SHAFT.getDefaultState(), te);
	}

	@Override
	public Class<KineticTileEntity> getTileEntityClass() {return KineticTileEntity.class;}

	@Override
	public BlockEntityType<? extends KineticTileEntity> getTileEntityType() {return AllTileEntities.ENCASED_SHAFT.get();}
}
