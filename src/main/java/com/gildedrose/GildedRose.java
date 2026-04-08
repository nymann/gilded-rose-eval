package com.gildedrose;

import java.util.Map;
import java.util.function.Function;

class GildedRose {
    Item[] items;

    private static final Map<String, Function<Item, ItemUpdater>> UPDATERS = Map.of(
        AgedBrieUpdater.NAME,      AgedBrieUpdater::new,
        BackstagePassUpdater.NAME, BackstagePassUpdater::new,
        SulfurasUpdater.NAME,      SulfurasUpdater::new
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updaterFor(item).update();
        }
    }

    private ItemUpdater updaterFor(Item item) {
        return UPDATERS.getOrDefault(item.name, NormalItemUpdater::new).apply(item);
    }
}
