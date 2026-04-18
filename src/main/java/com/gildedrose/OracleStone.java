package com.gildedrose;

public class OracleStone extends Item {

    private int day;
    private boolean sealed;

    public OracleStone(int day, int quality, boolean sealed) {
        super("Oracle Stone", 0, quality);
        this.day = day;
        this.sealed = sealed;
    }

    public int day() {
        return day;
    }

    public boolean isSealed() {
        return sealed;
    }

    void incrementDay() {
        day++;
    }
}
