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

    void advanceDay(double oracleRoll) {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracleRoll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }
}
