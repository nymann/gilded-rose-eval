package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {
    private int day;
    private final boolean sealed;
    private final DoubleSupplier oracleRoll;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    public int day() { return day; }
    public int quality() { return super.quality; }
    public boolean isSealed() { return sealed; }

    void advanceDay() {
        day++;
        if (day % 3 == 0) {
            super.quality++;
        }
        if (day % 7 == 0 && oracleRoll.getAsDouble() >= 0.5) {
            super.quality += 10;
        }
    }
}
