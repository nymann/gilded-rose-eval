package com.gildedrose;

abstract class ItemUpdater {
    protected final Item item;

    ItemUpdater(Item item) {
        this.item = item;
    }

    abstract void update();

    protected void degradeBy(int rate) {
        for (int i = 0; i < rate; i++) decreaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            for (int i = 0; i < rate; i++) decreaseQuality();
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) item.quality--;
    }

    protected void increaseQuality() {
        if (item.quality < 50) item.quality++;
    }
}
