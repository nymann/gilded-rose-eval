package com.gildedrose;

class OracleStoneUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        OracleStone stone = (OracleStone) item;
        stone.day++;
        if (stone.day % 3 == 0) {
            stone.quality++;
        }
    }
}
