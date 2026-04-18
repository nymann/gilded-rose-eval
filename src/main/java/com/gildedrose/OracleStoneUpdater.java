package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStoneUpdater {
    private final DoubleSupplier oracle;

    public OracleStoneUpdater(DoubleSupplier oracle) {
        this.oracle = oracle;
    }

    public void update(OracleStone stone) {
        if (stone.sealed) {
            stone.day++;
            return;
        }
        stone.day++;
        if (stone.day % 7 == 0) {
            double roll = oracle.getAsDouble();
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
