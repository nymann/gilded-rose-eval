package com.gildedrose;

class DegradingItemUpdater extends ItemUpdater {
    private final int rate;

    DegradingItemUpdater(Item item, int rate) {
        super(item);
        this.rate = rate;
    }

    @Override
    void update() {
        degradeBy(rate);
    }
}
