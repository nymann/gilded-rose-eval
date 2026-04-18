package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;
    private final DoubleSupplier oracle;

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    public void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracle.getAsDouble() < 0.7) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }
}
