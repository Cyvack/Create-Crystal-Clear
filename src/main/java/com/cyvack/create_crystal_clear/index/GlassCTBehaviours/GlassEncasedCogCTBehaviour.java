package com.cyvack.create_crystal_clear.index.GlassCTBehaviours;

import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.utility.Couple;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

public class GlassEncasedCogCTBehaviour extends EncasedCogCTBehaviour {

    public GlassEncasedCogCTBehaviour(CTSpriteShiftEntry shift) {
        super(shift);
    }

    public GlassEncasedCogCTBehaviour(CTSpriteShiftEntry shift, Couple<CTSpriteShiftEntry> sideShifts) {
        super(shift, sideShifts);
    }

    @Override
    public boolean buildContextForOccludedDirections() {
        return true;
    }
}
