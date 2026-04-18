package com.gildedrose;

import java.util.function.Supplier;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final Supplier<Double> oracle;

    OracleStone(int day, int quality, boolean sealed, Supplier<Double> oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    void tick() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracle.get() < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }
}
