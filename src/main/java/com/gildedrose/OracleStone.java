package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final Supplier<Double> oracle;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, Supplier<Double> oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public void tick() {
        day++;
        if (day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            quality += 10;
        }
    }

    public int day() { return day; }
    public int quality() { return quality; }
    public boolean sealed() { return sealed; }
}
