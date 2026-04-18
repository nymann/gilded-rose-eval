package com.gildedrose;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;

    public OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
    }

    public void update() {
        day++;
        if (day % 3 == 0) {
            quality++;
        }
    }
}
