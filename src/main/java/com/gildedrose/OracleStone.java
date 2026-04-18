package com.gildedrose;

public class OracleStone extends Item {
    private boolean sealed = false;

    public OracleStone(int sellIn, int quality) {
        super("Oracle Stone", sellIn, quality);
    }

    public boolean isSealed() {
        return sealed;
    }

    public void seal() {
        sealed = true;
    }
}
