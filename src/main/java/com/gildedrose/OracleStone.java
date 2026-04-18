package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier oracleRoll;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    public void update() {
        day++;
        if (sealed) return;

        if (day % 7 == 0) {
            double roll = oracleRoll.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
}
