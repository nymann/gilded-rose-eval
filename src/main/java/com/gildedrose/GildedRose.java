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
        updateQualityBeforeSellByDate(item);

        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            updateQualityAfterSellByDate(item);
        }
    }

    private void updateQualityBeforeSellByDate(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private void updateQualityAfterSellByDate(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else if (!isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
            if (item.name.equals(CONJURED) && item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
