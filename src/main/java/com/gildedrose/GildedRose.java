package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updaterFor(item).update(item);
        }
    }

    private ItemUpdater updaterFor(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrieUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassUpdater();
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasUpdater();
            default -> new NormalItemUpdater();
        };
    }
}
