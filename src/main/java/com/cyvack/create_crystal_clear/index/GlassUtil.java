package com.cyvack.create_crystal_clear.index;

import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GlassUtil {

    public static boolean checkForGlassBlock(BlockState state) {
        return state.getBlock() instanceof EncasedCogwheelBlock
                || state.getBlock() instanceof EncasedShaftBlock;
    }


}
