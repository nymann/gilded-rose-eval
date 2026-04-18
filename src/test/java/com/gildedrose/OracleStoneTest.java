package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        stone.update();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenThirdDay_whenDayPasses_thenQualityIncreasedByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        stone.update();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenSeventhDayWithFavorableRoll_whenDayPasses_thenQualityAddsTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.update();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenSeventhDayWithUnfavorableRoll_whenDayPasses_thenStoneSealedWithoutQualityChange() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.update();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityUnchanged() {
        OracleStone stone = new OracleStone(5, 42, true);
        stone.update();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
