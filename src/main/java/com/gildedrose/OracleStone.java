package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone extends Item {
    int day;
    boolean sealed;
    private final DoubleSupplier oracle;

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracle) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            double roll = oracle.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }
}
