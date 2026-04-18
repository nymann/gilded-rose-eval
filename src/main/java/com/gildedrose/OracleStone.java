package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final DoubleSupplier roll;

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier roll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roll = roll;
    }

    void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (roll.getAsDouble() < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }
}
