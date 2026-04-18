package com.gildedrose;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;
    private final OracleRoller roller;

    public OracleStone(int day, int quality, boolean sealed, OracleRoller roller) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.roller = roller;
    }

    public void advanceDay() {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (roller.roll() < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality += 1;
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
}
