package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void ordinaryDayAdvancesOnlyTheDayCounter() {
        // GIVEN day 1, quality 20, unsealed; WHEN a day passes (day 2, not a multiple of 3 or 7)
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.5);
        stone.update();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void gainsOneQualityOnEveryThirdDay() {
        // GIVEN day 2, quality 20, unsealed; WHEN a day passes → day 3 (3 % 3 == 0)
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.5);
        stone.update();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        // GIVEN day 6, quality 20, unsealed, roll 0.5 (favorable); WHEN a day passes → day 7
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.update();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void unfavorableOracleBlessingSealsStoneWithoutChangingQuality() {
        // GIVEN day 6, quality 20, unsealed, roll 0.95 (unfavorable); WHEN a day passes → day 7
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.update();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        // GIVEN day 5, quality 42, sealed; WHEN a day passes → day 6
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.5);
        stone.update();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
