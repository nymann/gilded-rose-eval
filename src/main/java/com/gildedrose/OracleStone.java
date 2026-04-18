package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier oracle;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public void advanceDay() {
        day++;
        if (!sealed) {
            if (day % 7 == 0) {
                double roll = oracle.getAsDouble();
                if (roll < 0.9) {
                    quality += 10;
                } else {
                    sealed = true;
                }
            } else if (day % 3 == 0) {
                quality += 1;
            }
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
}
