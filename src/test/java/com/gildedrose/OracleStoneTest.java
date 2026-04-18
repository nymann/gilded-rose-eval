package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenUnsealedOnOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        var stone = new OracleStone(1, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedOnDayBeforeThird_whenDayPasses_thenQualityIncreasesByOne() {
        var stone = new OracleStone(2, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedWithFavorableRollOnSeventhDay_whenDayPasses_thenQualityIncreasesByTen() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedWithUnfavorableRollOnSeventhDay_whenDayPasses_thenStoneSealedAndQualityUnchanged() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advanceDay();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedOnValueUpDay_whenDayPasses_thenQualityUnchangedAndRemainsSealed() {
        var stone = new OracleStone(5, 42, true, () -> 0.5);
        stone.advanceDay();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
