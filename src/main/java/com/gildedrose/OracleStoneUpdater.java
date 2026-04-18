package com.gildedrose;

import java.util.function.Supplier;

public class OracleStoneUpdater {
    private final Supplier<Double> oracle;

    public OracleStoneUpdater(Supplier<Double> oracle) {
        this.oracle = oracle;
    }

    public void update(OracleStone stone) {
        stone.day++;
        if (stone.sealed) return;
        if (stone.day % 7 == 0) {
            double roll = oracle.get();
            if (roll < 0.9) {
                stone.quality += 10;
            } else {
                stone.sealed = true;
            }
        } else if (stone.day % 3 == 0) {
            stone.quality++;
        }
    }
}
