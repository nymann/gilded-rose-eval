package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        var stone = new OracleStone(1, 20, false, () -> 0.0);
        stone.update();
        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenThirdDay_whenDayPasses_thenQualityIncreasesByOne() {
        var stone = new OracleStone(2, 20, false, () -> 0.0);
        stone.update();
        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenFavorableOracleRollOnSeventhDay_whenDayPasses_thenQualityIncreasesByTen() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.update();
        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnfavorableOracleRollOnSeventhDay_whenDayPasses_thenStoneIsSealed() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.update();
        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityDoesNotChange() {
        var stone = new OracleStone(5, 42, true, () -> 0.0);
        stone.update();
        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
