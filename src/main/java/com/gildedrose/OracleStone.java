package com.gildedrose;

class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
    }

    void advanceDay() {
        day += 1;
    }

    int day() { return day; }
    int quality() { return quality; }
    boolean sealed() { return sealed; }
}
