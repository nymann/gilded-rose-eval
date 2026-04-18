package com.gildedrose;

public class OracleStone extends Item {
    public boolean sealed;

    public OracleStone(String name, int day, int quality) {
        super(name, day, quality);
        this.sealed = false;
    }
}
