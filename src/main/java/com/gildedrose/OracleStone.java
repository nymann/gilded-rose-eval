package com.gildedrose;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final OracleRandom oracle;

    OracleStone(int day, int quality, boolean sealed, OracleRandom oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    void update() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (oracle.nextRoll() < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }
}
