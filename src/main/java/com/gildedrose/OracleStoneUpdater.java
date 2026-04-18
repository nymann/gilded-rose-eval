package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStoneUpdater {
    private static final double UNFAVORABLE_THRESHOLD = 0.9;

    private final DoubleSupplier oracleRoll;

    public OracleStoneUpdater(DoubleSupplier oracleRoll) {
        this.oracleRoll = oracleRoll;
    }

    public void update(OracleStone stone) {
        stone.day++;
        if (stone.sealed) return;

        if (stone.day % 7 == 0) {
            double roll = oracleRoll.getAsDouble();
            if (roll >= UNFAVORABLE_THRESHOLD) {
                stone.sealed = true;
            } else {
                stone.quality += 10;
            }
        } else if (stone.day % 3 == 0) {
            stone.quality++;
        }
    }
}
