package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int BACKSTAGE_DOUBLE_BONUS_THRESHOLD = 11;
    private static final int BACKSTAGE_TRIPLE_BONUS_THRESHOLD = 6;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            advanceOneDay(item);
        }
    }

    private void advanceOneDay(Item item) {
        if (isSulfuras(item)) return;

        updateDailyQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            updateExpiredQuality(item);
        }
    }

    private void updateExpiredQuality(Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePasses(item)) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void updateDailyQuality(Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePasses(item)) {
            updateBackstagePassQuality(item);
        } else {
            decreaseQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < BACKSTAGE_DOUBLE_BONUS_THRESHOLD) {
            increaseQuality(item);
        }
        if (item.sellIn < BACKSTAGE_TRIPLE_BONUS_THRESHOLD) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = Math.min(MAX_QUALITY, item.quality + 1);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isConjured(Item item) {
        return item.name.equals(CONJURED);
    }

    private void decreaseQuality(Item item) {
        item.quality = Math.max(MIN_QUALITY, item.quality - (isConjured(item) ? 2 : 1));
    }
}
