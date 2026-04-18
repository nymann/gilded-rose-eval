package com.gildedrose;

import org.junit.jupiter.api.Test;
import java.util.function.DoubleSupplier;
import static org.junit.jupiter.api.Assertions.*;

class OracleStone {
    int day;
    int quality;
    boolean sealed;
    private final DoubleSupplier oracle;

    OracleStone(int day, int quality, boolean sealed, DoubleSupplier oracle) {
        this.day = day;
        this.quality = quality;
        this.sealed = sealed;
        this.oracle = oracle;
    }

    void advance() {
        day++;
        if (!sealed) {
            if (day % 3 == 0) quality++;
            if (day % 7 == 0) {
                if (oracle.getAsDouble() < 0.9) quality += 10;
                else sealed = true;
            }
        }
    }
}

class OracleStoneTest {

    @Test
    void ordinaryDayAdvancesOnlyDayCounter() {
        var stone = new OracleStone(1, 20, false, () -> 0.5);
        stone.advance();
        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void gainsOneQualityOnEveryThirdDay() {
        var stone = new OracleStone(2, 20, false, () -> 0.5);
        stone.advance();
        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advance();
        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void unfavorableOracleBlessingSealsStoneWithoutChangingQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advance();
        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        var stone = new OracleStone(5, 42, true, () -> 0.5);
        stone.advance();
        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
