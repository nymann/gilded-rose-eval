package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final Supplier<Double> oracle;

    public OracleStone(int day, int quality, boolean sealed, Supplier<Double> oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracle.get() < 0.9) quality += 10;
            else sealed = true;
            return;
        }
        if (day % 3 == 0) quality++;
    }
}
