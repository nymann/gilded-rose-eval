package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {

    private int day;
    private boolean sealed;
    private final DoubleSupplier roll;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier roll) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
        this.roll = roll;
    }

    public int day() {
        return day;
    }

    public boolean isSealed() {
        return sealed;
    }

    void incrementDay() {
        day++;
        if (!sealed && day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            if (roll.getAsDouble() < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
