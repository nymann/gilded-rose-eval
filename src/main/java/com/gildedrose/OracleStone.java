package com.gildedrose;

class OracleStone {
    int day;
    int quality;
    boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
    }

    void tick() {
        day++;
    }
}
