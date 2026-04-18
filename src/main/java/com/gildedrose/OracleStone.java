package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier roll;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier roll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roll = roll;
    }

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) quality++;
        if (day % 7 == 0) {
            if (roll.getAsDouble() < 0.9) quality += 10;
            else sealed = true;
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
}
