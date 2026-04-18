package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {

    private int day;
    private boolean sealed;
    private final DoubleSupplier oracleRoll;

    public OracleStone(int day, int quality) {
        this(day, quality, Math::random);
    }

    public OracleStone(int day, int quality, DoubleSupplier oracleRoll) {
        super("Oracle Stone", day, quality);
        this.day = day;
        this.sealed = false;
        this.oracleRoll = oracleRoll;
    }

    public OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", day, quality);
        this.day = day;
        this.sealed = sealed;
        this.oracleRoll = Math::random;
    }

    public void advanceDay() {
        day++;
        if (!sealed && day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            double roll = oracleRoll.getAsDouble();
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }

    public int day() {
        return day;
    }

    public int quality() {
        return quality;
    }

    public boolean isSealed() {
        return sealed;
    }
}
