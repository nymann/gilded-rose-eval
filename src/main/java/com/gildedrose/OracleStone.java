package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone extends Item {
    int day;
    boolean sealed;
    DoubleSupplier roller;

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier roller) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
        this.roller = roller;
    }
}
