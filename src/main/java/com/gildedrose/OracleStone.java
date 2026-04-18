package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier oracleRoller;

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoller) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracleRoller = oracleRoller;
    }

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracleRoller.getAsDouble() < 0.7) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }

    int getDay() { return day; }
    int getQuality() { return quality; }
    boolean isSealed() { return sealed; }
}
