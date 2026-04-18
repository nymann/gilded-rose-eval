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

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            double roll = oracleRoll.getAsDouble();
            if (roll < 0.7) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }
}
