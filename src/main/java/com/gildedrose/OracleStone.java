package com.gildedrose;

class OracleStone extends Item {
    int day;
    boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
    }
}
