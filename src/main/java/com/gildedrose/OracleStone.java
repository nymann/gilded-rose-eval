package com.gildedrose;

public class OracleStone extends Item {

    private final boolean sealed;

    public OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", day, quality);
        this.sealed = sealed;
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
}
