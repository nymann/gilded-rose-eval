package com.gildedrose;

import java.util.function.DoubleSupplier;

class OracleStoneUpdater {
    private final DoubleSupplier oracle;

    OracleStoneUpdater(DoubleSupplier oracle) {
        this.oracle = oracle;
    }

    OracleStoneUpdater() {
        this(Math::random);
    }

    void update(OracleStone stone) {
        stone.day++;
        if (stone.sealed) return;

        if (stone.day % 3 == 0) {
            stone.quality++;
        }

        if (stone.day % 7 == 0) {
            double roll = oracle.getAsDouble();
            if (roll < 0.75) {
                stone.quality += 10;
            } else {
                stone.sealed = true;
            }
        }
    }
}
