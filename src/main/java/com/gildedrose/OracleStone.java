package com.gildedrose;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final OracleRoller roller;

    OracleStone(int day, int quality, boolean sealed, OracleRoller roller) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roller = roller;
    }

    void update() {
        day++;
        if (sealed) return;
        if (day % 3 == 0) quality++;
        if (day % 7 == 0) {
            if (roller.roll() < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
