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
        if (item.name.equals("Aged Brie"))                                    return new AgedBrieUpdater();
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))                   return new SulfurasUpdater();
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))    return new BackstagePassUpdater();
        if (item.name.startsWith("Conjured"))                                 return new ConjuredItemUpdater();
        return new NormalItemUpdater();
    }
}
