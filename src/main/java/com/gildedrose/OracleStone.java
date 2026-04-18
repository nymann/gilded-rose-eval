package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier random;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier random) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.random = random;
    }

    public void updateQuality() {
        day++;
        if (sealed) return;

        if (day % 7 == 0) {
            double roll = random.getAsDouble();
            if (roll < 0.9) {
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
