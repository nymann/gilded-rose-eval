package com.gildedrose;

class OracleStoneUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        OracleStone stone = (OracleStone) item;
        stone.day++;
    }
}
