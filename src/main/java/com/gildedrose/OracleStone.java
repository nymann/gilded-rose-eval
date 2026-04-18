package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier oracle;

    private static final double FAVORABLE_THRESHOLD = 0.7;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracle.getAsDouble() < FAVORABLE_THRESHOLD) {
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
