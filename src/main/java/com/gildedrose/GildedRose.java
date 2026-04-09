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
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassUpdater();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdater();
            case "Conjured Mana Cake":
                return new ConjuredUpdater();
            default:
                return new NormalUpdater();
        }
    }

    private interface ItemUpdater {
        void update(Item item);
    }

    private static class NormalUpdater implements ItemUpdater {
        public void update(Item item) {
            if (item.quality > 0) {
                item.quality--;
            }
            item.sellIn--;
            if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
            }
        }
    }

    private static class AgedBrieUpdater implements ItemUpdater {
        public void update(Item item) {
            if (item.quality < 50) {
                item.quality++;
            }
            item.sellIn--;
            if (item.sellIn < 0 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    private static class BackstagePassUpdater implements ItemUpdater {
        public void update(Item item) {
            if (item.quality < 50) {
                item.quality++;
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
            item.sellIn--;
            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }

    private static class SulfurasUpdater implements ItemUpdater {
        public void update(Item item) {
            // Sulfuras never changes
        }
    }

    private static class ConjuredUpdater implements ItemUpdater {
        public void update(Item item) {
            item.quality -= 2;
            item.sellIn--;
        }
    }
}
