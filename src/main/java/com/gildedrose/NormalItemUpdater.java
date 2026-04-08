package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {
    NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }
}
