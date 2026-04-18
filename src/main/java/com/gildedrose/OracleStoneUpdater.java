package com.gildedrose;

class OracleStoneUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        OracleStone stone = (OracleStone) item;
        stone.day++;
        if (stone.sealed) {
            return;
        }
        if (stone.day % 3 == 0) {
            stone.quality++;
        }
        if (stone.day % 7 == 0) {
            double roll = stone.roller.getAsDouble();
            if (roll <= 0.5) {
                stone.quality += 10;
            } else {
                stone.sealed = true;
            }
        }
    }
}
