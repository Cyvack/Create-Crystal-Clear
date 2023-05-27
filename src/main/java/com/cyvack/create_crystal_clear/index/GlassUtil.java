package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.content.blocks.GlassCasing;
import com.cyvack.create_crystal_clear.content.blocks.GlassEncasedCogwheel;
import com.cyvack.create_crystal_clear.content.blocks.GlassEncasedShaft;
import net.minecraft.world.level.block.state.BlockState;

public class GlassUtil {

    public static boolean checkForGlassBlock(BlockState state) {
        return state.getBlock() instanceof GlassEncasedCogwheel
                || state.getBlock() instanceof GlassEncasedShaft;
    }


}
