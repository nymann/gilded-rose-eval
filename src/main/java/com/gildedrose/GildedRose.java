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
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
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
        if (item.quality > 0) {
            item.quality--;
            if (isConjured(item) && item.quality > 0) {
                item.quality--;
            }
        }
    }
}
