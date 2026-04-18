package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleSupplier;

class OracleStone {
    static final String NAME = "Oracle Stone";

    private static final Map<Item, DoubleSupplier> rolls = new HashMap<>();

    private final Item item;
    private final boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        this.item = new Item(NAME, -day, quality);
        this.sealed = sealed;
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier roll) {
        this.item = new Item(NAME, -day, quality);
        this.sealed = sealed;
        rolls.put(this.item, roll);
    }

    static double roll(Item item) {
        return rolls.getOrDefault(item, Math::random).getAsDouble();
    }

    int day() {
        return -item.sellIn;
    }

    int quality() {
        return item.quality;
    }

    boolean sealed() {
        return sealed;
    }

    Item toItem() {
        return item;
    }
}
