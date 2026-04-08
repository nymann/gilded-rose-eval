package com.gildedrose;

abstract class ItemUpdater {
    protected final Item item;

    ItemUpdater(Item item) {
        this.item = item;
    }

    abstract void update();

    protected void decreaseQuality() {
        if (item.quality > 0) item.quality--;
    }

    protected void increaseQuality() {
        if (item.quality < 50) item.quality++;
    }
}
