package com.gildedrose;

class OracleStone {
    static final String NAME = "Oracle Stone";

    int day;
    int quality;
    boolean sealed;
    private final Item item;

    OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.item = new Item(NAME, day, quality);
    }

    Item toItem() {
        return item;
    }

    void sync() {
        day++;
        quality = item.quality;
    }
}
