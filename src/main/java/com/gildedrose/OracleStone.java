package com.gildedrose;

import java.util.function.DoubleSupplier;

public class OracleStone extends Item {

    private final int initialDay;
    private final int initialQuality;
    private final boolean ownSealed;
    private final DoubleSupplier oracleRoll;

    public OracleStone(int day, int quality, boolean sealed) {
        this(day, quality, sealed, Math::random);
    }

    public OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracleRoll) {
        super("Oracle Stone", -day, quality);
        this.initialDay = day;
        this.initialQuality = quality;
        this.ownSealed = sealed;
        this.oracleRoll = oracleRoll;
    }

    public int day() {
        return -sellIn;
    }

    public int quality() {
        int thirdDayBonus = (day() / 3) - (initialDay / 3);
        int oracleBonus = 0;
        for (int d = initialDay + 1; d <= day(); d++) {
            if (d % 7 == 0 && oracleRoll.getAsDouble() <= 0.5) {
                oracleBonus += 10;
            }
        }
        return initialQuality + thirdDayBonus + oracleBonus;
    }

    public boolean sealed() {
        return ownSealed;
    }
}
