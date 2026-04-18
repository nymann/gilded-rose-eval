package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;
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
        if (sealed) {
            day++;
            return;
        }
        day++;
        if (day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            double roll = oracle.get();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
