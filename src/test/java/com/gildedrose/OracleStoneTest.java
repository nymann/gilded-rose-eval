package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void ordinaryDayOnlyAdvancesDayCounter() {
        var stone = new OracleStone(1, 20, false, () -> 0.5);
        stone.advance();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void gainsOneQualityOnEveryThirdDay() {
        var stone = new OracleStone(2, 20, false, () -> 0.5);
        stone.advance();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advance();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void unfavorableOracleBlessingSealsStoneWithoutChangingQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advance();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        var stone = new OracleStone(5, 42, true, () -> 0.5);
        stone.advance();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
