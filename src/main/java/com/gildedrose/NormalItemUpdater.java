package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {
    NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void update() {
        degradeBy(1);
    }
}
