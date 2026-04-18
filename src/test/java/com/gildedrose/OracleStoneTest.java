package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenOrdinaryDay_whenDayPasses_thenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone("Oracle", 20, 1, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenDayBeforeMultipleOfThree_whenDayPasses_thenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone("Oracle", 20, 2, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenFavorableOracleRollOnSeventhDay_whenDayPasses_thenQualityIncreasesByTen() {
        OracleStone stone = new OracleStone("Oracle", 20, 6, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnfavorableOracleRollOnSeventhDay_whenDayPasses_thenStoneIsSealed() {
        OracleStone stone = new OracleStone("Oracle", 20, 6, false, () -> 0.95);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityDoesNotChange() {
        OracleStone stone = new OracleStone("Oracle", 42, 5, true, () -> 0.5);
        stone.advanceDay();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
