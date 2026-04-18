package com.gildedrose;

import java.util.function.Supplier;

public class OracleStone extends Item {

    private boolean sealed;
    private final Supplier<Double> oracleRoll;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, Supplier<Double> oracleRoll) {
        super("Oracle Stone", day, quality);
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    public double roll() {
        return oracleRoll.get();
    }

    public int day() {
        return sellIn;
    }

    public int quality() {
        return quality;
    }

    public boolean isSealed() {
        return sealed;
    }

    public void seal() {
        sealed = true;
    }
}
