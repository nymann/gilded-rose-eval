package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier roller;

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier roller) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roller = roller;
    }

    void advanceDay() {
        day += 1;
        if (day % 3 == 0) {
            quality += 1;
        }
    }

    int day() { return day; }
    int quality() { return quality; }
    boolean sealed() { return sealed; }
}
