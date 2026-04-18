package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final DoubleSupplier oracleRoll;

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    void tick() {
        day++;
        if (day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            if (oracleRoll.getAsDouble() >= 0.9) {
                sealed = true;
            } else {
                quality += 10;
            }
        }
    }
}
