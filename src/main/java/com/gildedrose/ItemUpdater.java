package com.gildedrose;

abstract class ItemUpdater {

    protected final Item item;

    ItemUpdater(Item item) {
        this.item = item;
    }

    static ItemUpdater forItem(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrieUpdater(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassUpdater(item);
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasUpdater(item);
            case "Conjured Mana Cake" -> new ConjuredItemUpdater(item);
            default -> new NormalItemUpdater(item);
        };
    }

    abstract void update();

    protected void decrementSellIn() {
        item.sellIn -= 1;
    }

    protected void increaseQuality(int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    protected void decreaseQuality(int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}

abstract class LinearItemUpdater extends ItemUpdater {
    LinearItemUpdater(Item item) { super(item); }

    @Override
    void update() {
        decrementSellIn();
        int amount = item.sellIn < 0 ? 2 : 1;
        applyQualityChange(amount);
    }

    abstract void applyQualityChange(int amount);
}

class NormalItemUpdater extends LinearItemUpdater {
    NormalItemUpdater(Item item) { super(item); }

    @Override
    void applyQualityChange(int amount) { decreaseQuality(amount); }
}

class AgedBrieUpdater extends LinearItemUpdater {
    AgedBrieUpdater(Item item) { super(item); }

    @Override
    void applyQualityChange(int amount) { increaseQuality(amount); }
}

class BackstagePassUpdater extends ItemUpdater {
    BackstagePassUpdater(Item item) { super(item); }

    @Override
    void update() {
        decrementSellIn();
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            increaseQuality(3);
        } else if (item.sellIn < 10) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }
}

class ConjuredItemUpdater extends ItemUpdater {
    ConjuredItemUpdater(Item item) { super(item); }

    @Override
    void update() {
        decrementSellIn();
        decreaseQuality(2);
    }
}

class SulfurasUpdater extends ItemUpdater {
    SulfurasUpdater(Item item) { super(item); }

    @Override
    void update() {
        // Sulfuras never changes
    }
}
