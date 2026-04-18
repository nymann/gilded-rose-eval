package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {
    private final DoubleSupplier roll;
    private boolean isSealed;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier roll) {
        super("Oracle Stone", day, quality);
        this.isSealed = sealed;
        this.roll = roll;
    }

    public Item toItem() {
        return this;
    }

    public int day() {
        return sellIn;
    }

    public int quality() {
        return quality;
    }

    public boolean sealed() {
        return isSealed;
    }

    public void seal() {
        isSealed = true;
    }

    public double nextRoll() {
        return roll.getAsDouble();
    }
}
