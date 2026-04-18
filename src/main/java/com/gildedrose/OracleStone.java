package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStone extends Item {
    private int day;
    private boolean sealed;
    private final DoubleSupplier oracleRoll;

    OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    int day() { return day; }
    int quality() { return quality; }
    boolean isSealed() { return sealed; }

    void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) quality++;
        if (day % 7 == 0) {
            double roll = oracleRoll.getAsDouble();
            if (roll <= 0.5) quality += 10;
            else sealed = true;
        }
    }
}
