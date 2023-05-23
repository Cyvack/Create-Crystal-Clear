package com.cyvack.create_crystal_clear.content.blocks.glass_casings;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class GlassCasing extends GlassBlock implements IWrenchable {

	Block resultingClearCasing;

	public GlassCasing(Properties p_53640_, Supplier<Block> resultingClearGlassBlock) {
		super(p_53640_);

		if (resultingClearGlassBlock != null)
			resultingClearCasing = resultingClearGlassBlock.get();
	}

	//TODO: also make this proper
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (resultingClearCasing != null && player.getItemInHand(hand).is(AllItems.SAND_PAPER.get())) {

//			if (level.isClientSide)
//				return InteractionResult.SUCCESS;

			player.getItemInHand(hand).hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
			level.setBlockAndUpdate(pos, resultingClearCasing.defaultBlockState());

			AllSoundEvents.SANDING_LONG.play(level, player, pos, 1, 1 + (level.random.nextFloat() * 0.5f - 1f) / 5f);
			level.levelEvent(player, 3004, pos, 0);

			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction side) {
		return ((pState.getBlock() instanceof GlassCasing) && (pAdjacentBlockState.getBlock() instanceof GlassCasing));
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
		return true;
	}
}
