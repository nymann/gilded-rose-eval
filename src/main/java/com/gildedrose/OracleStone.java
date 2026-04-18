package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;
    private final DoubleSupplier oracleRoll;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    public void update() {
        day++;
        if (day % 3 == 0) {
            quality++;
        }
        if (day == 7 && oracleRoll.getAsDouble() >= 0.5) {
            quality += 10;
        }
    }
}
