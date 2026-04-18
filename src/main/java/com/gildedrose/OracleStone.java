package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone {
    static final String NAME = "Oracle Stone";

    int day;
    int quality;
    boolean sealed;
    private final Item item;
    private final DoubleSupplier rollSource;

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier rollSource) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.rollSource = rollSource;
        this.item = new Item(NAME, day, quality);
    }

    Item toItem() {
        return item;
    }

    void sync() {
        day++;
        quality = item.quality;
        if (day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            double roll = rollSource.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
