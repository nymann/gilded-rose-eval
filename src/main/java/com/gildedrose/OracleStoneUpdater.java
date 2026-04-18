package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStoneUpdater {
    private final DoubleSupplier roller;

    public OracleStoneUpdater(DoubleSupplier roller) {
        this.roller = roller;
    }

    public OracleStoneUpdater() {
        this(Math::random);
    }

    public void update(OracleStone stone) {
        stone.day++;
        if (stone.sealed) {
            return;
        }
        if (stone.day % 7 == 0) {
            if (roller.getAsDouble() < 0.9) {
                stone.quality += 10;
            } else {
                stone.sealed = true;
            }
        } else if (stone.day % 3 == 0) {
            stone.quality++;
        }
    }
}
