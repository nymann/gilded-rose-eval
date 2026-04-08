package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseQualityByRate(item);
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            updateQualityAfterSellBy(item);
        }
    }

    private void updateQualityAfterSellBy(Item item) {
        if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQualityByRate(item);
                }
            } else {
                item.quality = item.quality - item.quality;
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void decreaseQualityByRate(Item item) {
        if (item.name.startsWith("Conjured")) {
            decreaseQuality(item, 2);
        } else {
            decreaseQuality(item, 1);
        }
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
