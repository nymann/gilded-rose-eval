package com.gildedrose;

public class OracleStone extends Item {

    private final int ownQuality;
    private final boolean ownSealed;

    public OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", -day, quality);
        this.ownQuality = quality;
        this.ownSealed = sealed;
    }

    public int day() {
        return -sellIn;
    }

    public int quality() {
        return ownQuality;
    }

    public boolean sealed() {
        return ownSealed;
    }
}
