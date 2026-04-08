package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {
    ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseQuality();
        decreaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality();
            decreaseQuality();
        }
    }
}
