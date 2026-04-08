package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

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
        switch (item.name) {
            case SULFURAS         -> { /* never changes */ }
            case AGED_BRIE        -> updateAgedBrie(item);
            case BACKSTAGE_PASSES -> updateBackstagePass(item);
            case CONJURED             -> updateConjured(item);
            default               -> updateNormal(item);
        }
    }

    private void updateConjured(Item item) {
        updateNormal(item, 2);
    }

    private void updateNormal(Item item) {
        updateNormal(item, 1);
    }

    private void updateNormal(Item item, int degradeRate) {
        item.sellIn--;
        item.quality = clampQuality(item.quality - (item.sellIn < 0 ? degradeRate * 2 : degradeRate));
    }

    private void updateAgedBrie(Item item) {
        item.sellIn--;
        item.quality = clampQuality(item.quality + (item.sellIn < 0 ? 2 : 1));
    }

    private void updateBackstagePass(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality = clampQuality(item.quality + 3);
        } else if (item.sellIn < 10) {
            item.quality = clampQuality(item.quality + 2);
        } else {
            item.quality = clampQuality(item.quality + 1);
        }
    }

    private int clampQuality(int quality) {
        return Math.max(0, Math.min(50, quality));
    }
}
