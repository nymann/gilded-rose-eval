package com.gildedrose;

public class OracleStone {
    public int day;
    public int quality;
    public boolean sealed;

    static double nextOracleRoll = 0.5;

    public OracleStone(int day, int quality, boolean sealed) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
    }

    public void update() {
        day++;
        if (sealed) return;

        if (day % 3 == 0 && day != 7) {
            quality++;
        }

        if (day == 7) {
            if (nextOracleRoll <= 0.5) {
                quality += 10;
            } else {
                sealed = true;
            }
        }
    }
}
