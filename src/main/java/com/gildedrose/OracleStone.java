package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {
    public int day;
    public boolean sealed;
    public DoubleSupplier oracleRoll;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }
}
