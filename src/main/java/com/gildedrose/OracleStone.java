package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone extends Item {
    private boolean sealed;
    private final Supplier<Double> oracleRoll;

    public OracleStone(int day, int quality, Supplier<Double> oracleRoll) {
        super("Oracle Stone", day, quality);
        this.sealed = false;
        this.oracleRoll = oracleRoll;
    }

    public OracleStone(int day, int quality, boolean sealed, Supplier<Double> oracleRoll) {
        super("Oracle Stone", day, quality);
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    public int getDay() {
        return sellIn;
    }

    public boolean isSealed() {
        return sealed;
    }

    void advanceDay() {
        sellIn++;
        if (sealed) return;
        int day = sellIn;
        if (day % 7 == 0) {
            double roll = oracleRoll.get();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }
}
