package com.gildedrose;

class ConjuredItemUpdater implements ItemUpdater {
    public void update(Item item) {
        item.quality = Math.max(0, item.quality - 2);
        item.sellIn--;
    }
}
