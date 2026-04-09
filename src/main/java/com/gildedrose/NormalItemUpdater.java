package com.gildedrose;

class NormalItemUpdater implements ItemUpdater {
    public void update(Item item) {
        item.quality = Math.max(0, item.quality - 1);
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = Math.max(0, item.quality - 1);
        }
    }
}
