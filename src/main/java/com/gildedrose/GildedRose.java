package com.gildedrose;

import java.util.Map;

class GildedRose {
    Item[] items;

    private static final Map<String, ItemUpdater> UPDATERS = Map.of(
        "Aged Brie",                                    new AgedBrieUpdater(),
        "Backstage passes to a TAFKAL80ETC concert",    new BackstagePassUpdater(),
        "Sulfuras, Hand of Ragnaros",                   new SulfurasUpdater()
    );
    private static final ItemUpdater DEFAULT_UPDATER = new NormalItemUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UPDATERS.getOrDefault(item.name, DEFAULT_UPDATER).update(item);
        }
    }
}
