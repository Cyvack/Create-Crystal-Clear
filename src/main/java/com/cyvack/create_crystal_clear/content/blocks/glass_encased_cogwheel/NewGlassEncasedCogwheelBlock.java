package com.cyvack.create_crystal_clear.content.blocks.glass_encased_cogwheel;

import com.cyvack.create_crystal_clear.content.blocks.glass_casings.GlassCasing;
import com.cyvack.create_crystal_clear.index.CrystalClearBlockEntities;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class NewGlassEncasedCogwheelBlock extends EncasedCogwheelBlock implements EncasedBlock {
    public NewGlassEncasedCogwheelBlock(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties, large, casing);
    }

    @Override
    public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
        return isLarge ? CrystalClearBlockEntities.GLASS_ENCASED_LARGE_COG.get() : CrystalClearBlockEntities.GLASS_ENCASED_COG.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction side) {
        return ((pState.getBlock() instanceof NewGlassEncasedCogwheelBlock) && (pAdjacentBlockState.getBlock() instanceof NewGlassEncasedCogwheelBlock));
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
        return true;
    }
}
