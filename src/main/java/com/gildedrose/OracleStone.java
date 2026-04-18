package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final Supplier<Double> oracle;

    public OracleStone(int day, int quality, boolean sealed, Supplier<Double> oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            double roll = oracle.get();
            if (roll <= 0.5) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
}
