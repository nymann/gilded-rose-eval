package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) return;

        if (item.name.equals("Aged Brie"))
            updateAgedBrie(item);
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            updateBackstagePasses(item);
        else if (item.name.startsWith("Conjured"))
            updateConjured(item);
        else
            updateNormal(item);

        item.sellIn--;
    }

    private void updateNormal(Item item) {
        item.quality = clamp(item.quality - (isPastSellByDate(item) ? 2 : 1));
    }

    private void updateAgedBrie(Item item) {
        item.quality = clamp(item.quality + (isPastSellByDate(item) ? 2 : 1));
    }

    private void updateConjured(Item item) {
        item.quality = clamp(item.quality - (isPastSellByDate(item) ? 4 : 2));
    }

    private void updateBackstagePasses(Item item) {
        if (isPastSellByDate(item)) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = clamp(item.quality + 3);
        } else if (item.sellIn <= 10) {
            item.quality = clamp(item.quality + 2);
        } else {
            item.quality = clamp(item.quality + 1);
        }
    }

    private boolean isPastSellByDate(Item item) {
        return item.sellIn <= 0;
    }

    private int clamp(int quality) {
        return Math.max(0, Math.min(50, quality));
    }
}
