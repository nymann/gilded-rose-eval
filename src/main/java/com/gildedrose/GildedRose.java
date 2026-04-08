package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    private static final int BACKSTAGE_TIER2_THRESHOLD = 11;
    private static final int BACKSTAGE_TIER3_THRESHOLD = 6;

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
        updateDailyQuality(item);

        if (!isSulfuras(item)) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            updateExpiredQuality(item);
        }
    }

    private void updateExpiredQuality(Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePasses(item)) {
            item.quality = 0;
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private void updateDailyQuality(Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePasses(item)) {
            updateBackstagePassQuality(item);
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < BACKSTAGE_TIER2_THRESHOLD) {
            increaseQuality(item);
        }
        if (item.sellIn < BACKSTAGE_TIER3_THRESHOLD) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = Math.min(50, item.quality + 1);
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
        item.quality = Math.max(0, item.quality - (isConjured(item) ? 2 : 1));
    }
}
