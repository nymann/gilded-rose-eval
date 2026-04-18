package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenUnsealed_onOrdinaryDay_advancesOnlyDayCounter() {
        var stone = new OracleStone(1, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealed_onEveryThirdDay_gainsOneQuality() {
        var stone = new OracleStone(2, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealed_onSeventhDayWithFavorableRoll_addsTenQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealed_onSeventhDayWithUnfavorableRoll_sealsWithoutChangingQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealed_onValueUpDay_doesNotGainQuality() {
        var stone = new OracleStone(5, 42, true, () -> 0.5);
        stone.advanceDay();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
