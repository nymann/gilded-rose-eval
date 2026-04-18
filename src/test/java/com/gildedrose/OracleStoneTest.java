package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenUnsealedStoneOnOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        var stone = new OracleStone(1, 20, false);
        new OracleStoneUpdater(() -> 0.5).update(stone);
        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedStoneBeforeThirdDay_whenDayPasses_thenQualityIncreasesByOne() {
        var stone = new OracleStone(2, 20, false);
        new OracleStoneUpdater(() -> 0.5).update(stone);
        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedStoneBeforeSeventhDay_andFavorableRoll_whenDayPasses_thenQualityIncreasesBy10() {
        var stone = new OracleStone(6, 20, false);
        new OracleStoneUpdater(() -> 0.5).update(stone);
        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedStoneBeforeSeventhDay_andUnfavorableRoll_whenDayPasses_thenStoneIsSealed() {
        var stone = new OracleStone(6, 20, false);
        new OracleStoneUpdater(() -> 0.95).update(stone);
        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityDoesNotChange() {
        var stone = new OracleStone(5, 42, true);
        new OracleStoneUpdater(() -> 0.5).update(stone);
        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
