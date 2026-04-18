package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private final String name;
    private int quality;
    private int day;
    private boolean sealed;
    private final DoubleSupplier oracle;

    public OracleStone(String name, int quality, int day, boolean sealed, DoubleSupplier oracle) {
        this.name = name;
        this.quality = quality;
        this.day = day;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) {
            quality += 1;
        }
        if (day % 7 == 0) {
            double roll = oracle.getAsDouble();
            if (roll < 0.8) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
    public String getName() { return name; }
}
