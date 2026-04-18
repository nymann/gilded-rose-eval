package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;
    private final DoubleSupplier rollSupplier;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier rollSupplier) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.rollSupplier = rollSupplier;
    }

    public void advanceDay() {
        day++;
        if (sealed) return;

        if (day % 7 == 0) {
            double roll = rollSupplier.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }
}
