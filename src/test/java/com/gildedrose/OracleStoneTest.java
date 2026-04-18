package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.0);
        stone.advanceDay();
        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenThirdDay_whenDayPasses_thenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.0);
        stone.advanceDay();
        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenSeventhDayWithFavorableRoll_whenDayPasses_thenQualityIncreasesByTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenSeventhDayWithUnfavorableRoll_whenDayPasses_thenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advanceDay();
        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityAndSealUnchanged() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.0);
        stone.advanceDay();
        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
