package com.cyvack.create_crystal_clear.mixins;


import com.cyvack.create_crystal_clear.blocks.glass_encased_cogwheel.GlassEncasedCogwheel;
import com.cyvack.create_crystal_clear.blocks.ModBlocks;
import com.simibubi.create.content.contraptions.base.IRotate;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.simibubi.create.content.contraptions.base.RotatedPillarKineticBlock.AXIS;


@Mixin(CogWheelBlock.class)
public class CogwheelMixin {
@Inject(method = "use",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;getItemInHand(Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;"),
		cancellable = true)

		private void Inject(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult ray, CallbackInfoReturnable<InteractionResult> cir){
	ItemStack heldItem = player.getItemInHand(hand);
	GlassEncasedCogwheel[] glassEncasedBlocks = isLarge
			? new GlassEncasedCogwheel[] {
				ModBlocks.ANDESITE_GLASS_ENCASED_LARGE_COGWHEEL.get(),
				ModBlocks.BRASS_GLASS_ENCASED_LARGE_COGWHEEL.get(),
				ModBlocks.TRAIN_GLASS_ENCASED_LARGE_COGWHEEL.get(),
				ModBlocks.ANDESITE_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL.get(),
				ModBlocks.BRASS_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL.get(),
				ModBlocks.TRAIN_CLEAR_GLASS_ENCASED_LARGE_COGWHEEL.get()} //Add more large cogs

			: new GlassEncasedCogwheel[] {
				ModBlocks.ANDESITE_GLASS_ENCASED_COGWHEEL.get(),
				ModBlocks.BRASS_GLASS_ENCASED_COGWHEEL.get(),
				ModBlocks.TRAIN_GLASS_ENCASED_COGWHEEL.get(),
				ModBlocks.ANDESITE_CLEAR_GLASS_ENCASED_COGWHEEL.get(),
				ModBlocks.BRASS_CLEAR_GLASS_ENCASED_COGWHEEL.get(),
				ModBlocks.TRAIN_CLEAR_GLASS_ENCASED_COGWHEEL.get()}; //Add more small cogs


		for (GlassEncasedCogwheel glassEncasedCogwheel : glassEncasedBlocks) {
			if (!glassEncasedCogwheel.getCasing()
					.isIn(heldItem))
				continue;

			if (world.isClientSide)
				cir.setReturnValue(InteractionResult.SUCCESS);

			BlockState encasedState = glassEncasedCogwheel.defaultBlockState()
					.setValue(AXIS, state.getValue(AXIS));

			for (Direction d : Iterate.directionsInAxis(state.getValue(AXIS))) {
				BlockState adjacentState = world.getBlockState(pos.relative(d));
				if (!(adjacentState.getBlock() instanceof IRotate))
					continue;
				IRotate def = (IRotate) adjacentState.getBlock();
				if (!def.hasShaftTowards(world, pos.relative(d), adjacentState, d.getOpposite()))
					continue;
				encasedState =
						encasedState.cycle(d.getAxisDirection() == Direction.AxisDirection.POSITIVE ? GlassEncasedCogwheel.TOP_SHAFT
								: GlassEncasedCogwheel.BOTTOM_SHAFT);
			}

			KineticTileEntity.switchToBlockState(world, pos, encasedState);
			cir.setReturnValue(InteractionResult.SUCCESS);
		}
	}

@Shadow
boolean isLarge;
}
