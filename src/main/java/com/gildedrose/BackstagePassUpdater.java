package com.gildedrose;

class BackstagePassUpdater implements ItemUpdater {
    public void update(Item item) {
        item.quality = Math.min(50, item.quality + 1);
        if (item.sellIn < 11) {
            item.quality = Math.min(50, item.quality + 1);
        }
        if (item.sellIn < 6) {
            item.quality = Math.min(50, item.quality + 1);
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
