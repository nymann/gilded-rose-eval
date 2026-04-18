package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final DoubleSupplier oracleRoll;

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    void update() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) quality++;
        if (day % 7 == 0) {
            double roll = oracleRoll.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
