package com.gildedrose;

class OracleStone {
    static final String NAME = "Oracle Stone";

    private final Item item;
    private final boolean sealed;

    OracleStone(int day, int quality, boolean sealed) {
        this.item = new Item(NAME, -day, quality);
        this.sealed = sealed;
    }

    int day() {
        return -item.sellIn;
    }

    int quality() {
        return item.quality;
    }

    boolean sealed() {
        return sealed;
    }

    Item toItem() {
        return item;
    }
}
