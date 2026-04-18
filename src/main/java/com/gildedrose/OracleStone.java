package com.gildedrose;

public class OracleStone extends Item {

    private final int initialDay;
    private final int initialQuality;
    private final boolean ownSealed;

    public OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", -day, quality);
        this.initialDay = day;
        this.initialQuality = quality;
        this.ownSealed = sealed;
    }

    public int day() {
        return -sellIn;
    }

    public int quality() {
        return initialQuality + (day() / 3) - (initialDay / 3);
    }

    public boolean sealed() {
        return ownSealed;
    }
}
