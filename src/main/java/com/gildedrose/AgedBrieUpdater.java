package com.gildedrose;

class AgedBrieUpdater extends ItemUpdater {
    static final String NAME = "Aged Brie";

    AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    void update() {
        increaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseQuality();
        }
    }
}
