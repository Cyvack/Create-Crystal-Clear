package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.CrystalClear;
import com.simibubi.create.AllBlocks;
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

    // Tell Registrate to create a lang entry for the item groups
    private static final CreateRegistrate REGISTRATE = CrystalClear.REGISTRATE.creativeModeTab(() -> MAIN_GROUP, "Crystal Clear");
}
