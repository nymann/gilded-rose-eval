package com.gildedrose;

public class OracleStone {
    private final Item item;

    public OracleStone(int day, int quality, boolean sealed) {
        this.item = new Item("Oracle Stone", day, quality);
    }

    public Item toItem() {
        return item;
    }

    public int day() {
        return item.sellIn;
    }

    public int quality() {
        return item.quality;
    }

    public boolean sealed() {
        return false;
    }
}
