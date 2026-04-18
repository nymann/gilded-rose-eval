package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final DoubleSupplier oracle;

    public OracleStone(int day, int quality) {
        this(day, quality, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, Math::random);
        this.sealed = sealed;
    }

    public OracleStone(int day, int quality, DoubleSupplier oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = false;
        this.oracle = oracle;
    }

    public void tick() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            double roll = oracle.getAsDouble();
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
