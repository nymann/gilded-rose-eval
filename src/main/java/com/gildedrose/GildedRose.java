package com.gildedrose;

import java.util.Map;

class GildedRose {
    Item[] items;

    private static final ItemUpdater NORMAL = new NormalItemUpdater();
    private static final Map<String, ItemUpdater> UPDATERS = Map.of(
        "Aged Brie", new AgedBrieUpdater(),
        "Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater(),
        "Sulfuras, Hand of Ragnaros", new SulfurasUpdater()
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UPDATERS.getOrDefault(item.name, NORMAL).update(item);
        }
    }
}
