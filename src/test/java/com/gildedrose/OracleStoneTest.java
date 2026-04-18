package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        var stone = new OracleStone(1, 20, false);
        new OracleStoneUpdater().update(stone);
        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenThirdDay_whenDayPasses_thenQualityIncreasesBy1() {
        var stone = new OracleStone(2, 20, false);
        new OracleStoneUpdater().update(stone);
        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenSeventhDayWithFavorableRoll_whenDayPasses_thenQualityIncreasesBy10() {
        var stone = new OracleStone(6, 20, false);
        new OracleStoneUpdater(() -> 0.5).update(stone);
        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenSeventhDayWithUnfavorableRoll_whenDayPasses_thenStoneSealed() {
        var stone = new OracleStone(6, 20, false);
        new OracleStoneUpdater(() -> 0.95).update(stone);
        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityUnchanged() {
        var stone = new OracleStone(5, 42, true);
        new OracleStoneUpdater().update(stone);
        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
