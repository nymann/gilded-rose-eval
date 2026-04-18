package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void ordinaryDayAdvancesDayCounterOnly() {
        var stone = new OracleStone(1, 20, false, () -> { throw new AssertionError("no oracle expected"); });
        stone.update();
        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void gainsOneQualityOnEveryThirdDay() {
        var stone = new OracleStone(2, 20, false, () -> { throw new AssertionError("no oracle expected"); });
        stone.update();
        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.update();
        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void unfavorableOracleBlessingSealsStonWithoutChangingQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.update();
        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        var stone = new OracleStone(5, 42, true, () -> { throw new AssertionError("no oracle expected"); });
        stone.update();
        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
