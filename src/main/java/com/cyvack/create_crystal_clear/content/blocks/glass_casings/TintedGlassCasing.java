package com.cyvack.create_crystal_clear.content.blocks.glass_casings;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TintedGlassCasing extends GlassBlock {

	public TintedGlassCasing(Properties p_53640_) {
		super(p_53640_);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return ((state.getBlock() instanceof TintedGlassCasing) && (adjacentBlockState.getBlock() instanceof TintedGlassCasing));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState p_154824_, BlockGetter p_154825_, BlockPos p_154826_) {
		return false;
	}

	@Override
	public int getLightBlock(BlockState p_154828_, BlockGetter p_154829_, BlockPos p_154830_) {
		return p_154829_.getMaxLightLevel();
	}
	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
		return true;
	}
}
