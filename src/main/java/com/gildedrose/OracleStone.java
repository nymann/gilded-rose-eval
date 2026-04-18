package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final Supplier<Double> roll;

    public OracleStone(int day, int quality, boolean sealed, Supplier<Double> roll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roll = roll;
    }

    public void update() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) quality++;
        if (day % 7 == 0) {
            if (roll.get() < 0.7) quality += 10;
            else sealed = true;
        }
    }
}
