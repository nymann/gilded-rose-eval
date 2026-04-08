package com.gildedrose;

class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }
        item.sellIn -= 1;
    }
}
