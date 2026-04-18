package com.gildedrose;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleSupplier;

class OracleStone {
    static final String NAME = "Oracle Stone";

    private static final Map<Item, DoubleSupplier> rolls = new HashMap<>();
    private static final Set<Item> sealedItems = new HashSet<>();

    private final Item item;
    private boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        this.item = new Item(NAME, -day, quality);
        this.sealed = sealed;
        if (sealed) sealedItems.add(this.item);
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier roll) {
        this.item = new Item(NAME, -day, quality);
        this.sealed = sealed;
        rolls.put(this.item, roll);
        if (sealed) sealedItems.add(this.item);
    }

    static double roll(Item item) {
        return rolls.getOrDefault(item, Math::random).getAsDouble();
    }

    static void seal(Item item) {
        sealedItems.add(item);
    }

    static boolean isSealed(Item item) {
        return sealedItems.contains(item);
    }

    int day() {
        return -item.sellIn;
    }

    int quality() {
        return item.quality;
    }

    boolean sealed() {
        return sealed || sealedItems.contains(item);
    }

    Item toItem() {
        return item;
    }
}
