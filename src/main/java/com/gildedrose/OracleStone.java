package com.gildedrose;

import java.util.function.Supplier;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final Supplier<Double> random;

    OracleStone(int day, int quality, boolean sealed, Supplier<Double> random) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.random = random;
    }

    void advanceDay() {
        day++;
        if (!sealed) {
            if (day % 3 == 0) {
                quality++;
            }
            if (day % 7 == 0) {
                double roll = random.get();
                if (roll < 0.9) {
                    quality += 10;
                } else {
                    sealed = true;
                }
            }
        }
    }
}
