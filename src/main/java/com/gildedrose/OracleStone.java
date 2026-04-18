package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;
    private final DoubleSupplier roller;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier roller) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roller = roller;
    }

    public void updateQuality() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            double roll = roller.getAsDouble();
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
