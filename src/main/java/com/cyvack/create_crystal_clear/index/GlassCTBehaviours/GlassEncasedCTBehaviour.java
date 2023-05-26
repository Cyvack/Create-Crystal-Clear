package com.cyvack.create_crystal_clear.index.GlassCTBehaviours;

import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

public class GlassEncasedCTBehaviour extends EncasedCTBehaviour {
    public GlassEncasedCTBehaviour(CTSpriteShiftEntry shift) {
        super(shift);
    }

    @Override
    public boolean buildContextForOccludedDirections() {
        return true;
    }

    @Override
    public boolean connectsTo(BlockState selfState, BlockState compareState, BlockAndTintGetter reader, BlockPos pos, BlockPos otherPos, Direction face) {
        if (compareState.getBlock() == selfState.getBlock() /*&& compareState.getValue(AXIS) == selfState.getValue(AXIS)*/)
            return true;

        return super.connectsTo(selfState, compareState, reader, pos, otherPos, face);
    }
}
