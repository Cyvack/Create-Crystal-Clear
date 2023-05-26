package com.cyvack.create_crystal_clear.index.casing_names;

import java.util.ArrayList;
import java.util.List;

public enum CasingTypes {

    NORMAL_CASINGS("andesite", "brass", "copper", "train"),
    GENERAL_ENCASED("andesite", "brass", "train");

    public final List<String> names = new ArrayList<>();

    CasingTypes(String ... names) {
        this.names.addAll(List.of(names));
    }
}
