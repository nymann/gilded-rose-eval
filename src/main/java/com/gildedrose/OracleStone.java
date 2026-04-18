package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;
    private final DoubleSupplier rng;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier rng) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.rng = rng;
    }

    public void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            double roll = rng.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
            return;
        }
        if (day % 3 == 0) {
            quality++;
        }
    }
}
