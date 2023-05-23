package com.cyvack.create_crystal_clear.content.blocks.glass_encased_shaft;

import com.cyvack.create_crystal_clear.content.blocks.glass_encased_cogwheel.NewGlassEncasedCogwheelBlock;
import com.cyvack.create_crystal_clear.index.CrystalClearBlockEntities;
import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class NewGlassEncasedShaftBlock extends EncasedShaftBlock implements EncasedBlock, IBE<KineticBlockEntity> {
    public NewGlassEncasedShaftBlock(Properties properties, Supplier<Block> casing) {
        super(properties, casing);
    }


    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return CrystalClearBlockEntities.GLASS_ENCASED_SHAFT.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction side) {
        return ((pState.getBlock() instanceof NewGlassEncasedShaftBlock) && (pAdjacentBlockState.getBlock() instanceof NewGlassEncasedShaftBlock));
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
        return true;
    }
}
