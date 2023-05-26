package com.cyvack.create_crystal_clear.index;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GlassBlockList<T extends Block> /*implements Iterable<BlockEntry<T>>*/{

    /**
     * A map that contains all block entries associated with their respective casing names
     */
    public Map<String, BlockEntry<T>> blockEntryMap = new HashMap<>();

    /**
     * @param casings Name of casings
     * @param filler Block Entry to supply with casing names
     */
    public GlassBlockList(List<String> casings, Function<String, BlockEntry<T>> filler) {
        for (String casing : casings) {
            blockEntryMap.put(casing, filler.apply(casing));
        }
    }

    //Crude TODO: make this better
    @SuppressWarnings("unchecked")
    public BlockEntry<T>[] toArray() {
        BlockEntry<?>[] blockEntries = new BlockEntry<?>[blockEntryMap.size()];

        int i = 0;
        for (BlockEntry<T> value : blockEntryMap.values()) {
            blockEntries[i] = value;
            i++;
        }

        return (BlockEntry<T>[]) blockEntries;
    }

    public Block getCasing (String casingName) {
        return blockEntryMap.get(casingName).get();
    }
}
