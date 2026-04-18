package com.gildedrose;

public class OracleStone extends Item {
    public int day;
    public boolean sealed;

    public OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", day, quality);
        this.day = day;
        this.sealed = sealed;
    }
}
