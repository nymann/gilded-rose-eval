package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenUnsealedStoneOnOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedStoneOnDayBeforeThird_whenDayPasses_thenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenFavorableOracleRoll_whenSeventhDayPasses_thenQualityIncreasesByTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnfavorableOracleRoll_whenSeventhDayPasses_thenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedStone_whenValueUpDayPasses_thenQualityDoesNotChange() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.5);
        stone.advanceDay();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
