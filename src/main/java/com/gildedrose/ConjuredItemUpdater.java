package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {
    ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    void update() {
        degradeBy(2);
    }
}
