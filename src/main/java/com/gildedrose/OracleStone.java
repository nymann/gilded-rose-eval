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

    void update() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) quality++;
        if (day % 7 == 0) {
            if (oracle.get() < 0.7) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
