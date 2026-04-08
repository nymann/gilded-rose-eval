package com.gildedrose;

class GildedRose {
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String CONJURED = "Conjured Mana Cake";

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
            case SULFURAS -> { /* never changes */ }
            case AGED_BRIE -> updateAgedBrie(item);
            case BACKSTAGE_PASSES -> updateBackstagePasses(item);
            case CONJURED -> updateConjuredItem(item);
            default -> updateNormalItem(item);
        }
    }

    private void updateAgedBrie(Item item) {
        item.sellIn--;
        item.quality = item.sellIn < 0
                ? increaseQuality(item.quality, 2)
                : increaseQuality(item.quality, 1);
    }

    private void updateBackstagePasses(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality = increaseQuality(item.quality, 3);
        } else if (item.sellIn < 10) {
            item.quality = increaseQuality(item.quality, 2);
        } else {
            item.quality = increaseQuality(item.quality, 1);
        }
    }

    private void updateConjuredItem(Item item) {
        item.sellIn--;
        item.quality = decreaseQuality(item.quality, 2);
    }

    private void updateNormalItem(Item item) {
        item.sellIn--;
        int degradeBy = item.sellIn < 0 ? 2 : 1;
        item.quality = decreaseQuality(item.quality, degradeBy);
    }

    private int increaseQuality(int quality, int amount) {
        return Math.min(50, quality + amount);
    }

    private int decreaseQuality(int quality, int amount) {
        return Math.max(0, quality - amount);
    }
}
