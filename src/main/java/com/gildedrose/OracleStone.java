package com.gildedrose;

public class OracleStone {
    private int day;
    private int quality;
    private boolean sealed;

    public OracleStone(int day, int quality) {
        this(day, quality, false);
    }

    public OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
    }

    public void update(double roll) {
        day++;
        if (sealed) return;
        if (day % 7 == 0) {
            if (roll < 0.9) {
                quality += 10;
            } else {
                sealed = true;
            }
        } else if (day % 3 == 0) {
            quality++;
        }
    }

    public int getDay() { return day; }
    public int getQuality() { return quality; }
    public boolean isSealed() { return sealed; }
}
