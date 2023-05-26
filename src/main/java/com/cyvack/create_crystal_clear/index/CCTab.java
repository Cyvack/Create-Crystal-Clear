package com.cyvack.create_crystal_clear.index;

import com.cyvack.create_crystal_clear.index.casing_names.CasingTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CCTab {

    public static CreativeModeTab MAIN_GROUP = new CreativeModeTab("main_group") {
        @Override
        public ItemStack makeIcon() {
            return CCBlocks.GLASS_CASINGS.blockEntryMap.get("copper").asStack();
        }
    };
}
