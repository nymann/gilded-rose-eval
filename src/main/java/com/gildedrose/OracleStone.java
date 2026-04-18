package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {
    public int day;
    public boolean sealed;
    public final DoubleSupplier roller;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier roller) {
        super("Oracle Stone", day, quality);
        this.day = day;
        this.sealed = sealed;
        this.roller = roller;
    }
}
