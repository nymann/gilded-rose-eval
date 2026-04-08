package com.gildedrose;

class BackstagePassUpdater extends ItemUpdater {
    static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    void update() {
        increaseQuality();
        if (item.sellIn < 11) increaseQuality();
        if (item.sellIn < 6) increaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
