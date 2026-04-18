package com.gildedrose;

public class OracleStoneUpdater {
    private OracleRoll oracle;

    public OracleStoneUpdater(OracleRoll oracle) {
        this.oracle = oracle;
    }

    public void update(OracleStone stone) {
        stone.day++;

        if (stone.sealed) {
            return;
        }

        if (stone.day == 7) {
            if (oracle.roll() < 0.75) {
                stone.quality += 10;
            } else {
                stone.sealed = true;
            }
        } else if (stone.day % 3 == 0) {
            stone.quality++;
        }
    }
}
