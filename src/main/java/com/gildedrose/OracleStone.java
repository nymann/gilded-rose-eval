package com.gildedrose;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;

    public OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
    }

    public void tick() {
        day++;
        if (day % 3 == 0) {
            quality++;
        }
    }

    public void tick(double roll) {
        day++;
        if (day % 3 == 0) {
            quality++;
        }
        if (day % 7 == 0) {
            quality += 10;
        }
    }

    public int day() { return day; }
    public int quality() { return quality; }
    public boolean sealed() { return sealed; }
}
