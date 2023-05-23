package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.CrystalClear;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CrystalClearTab {

    public static CreativeModeTab MAIN_GROUP = new CreativeModeTab("main_group") {
        @Override
        public ItemStack makeIcon() {
            return ModBlocks.COPPER_GLASS_CASING.asStack();
        }
    };
}
