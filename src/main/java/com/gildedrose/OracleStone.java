package com.gildedrose;

class OracleStone extends Item {
    private int day;
    private final boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
    }

    int day() { return day; }
    int quality() { return quality; }
    boolean isSealed() { return sealed; }

    void advanceDay() { day++; }
}
