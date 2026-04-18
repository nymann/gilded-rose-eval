package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    private static final ItemUpdater NORMAL = new NormalItemUpdater();
    private static final Map<String, ItemUpdater> UPDATERS = new HashMap<>();

    static {
        UPDATERS.put("Aged Brie", new AgedBrieUpdater());
        UPDATERS.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        UPDATERS.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        UPDATERS.put("Oracle Stone", new OracleStoneUpdater());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UPDATERS.getOrDefault(item.name, NORMAL).update(item);
        }
    }
}
