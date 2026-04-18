package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        new OracleStoneUpdater().update(stone);
        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenThirdDayWhenDayPassesThenQualityGainedByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        new OracleStoneUpdater().update(stone);
        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenFavorableOracleBlessingOnSeventhDayWhenDayPassesThenQualityAddsTen() {
        OracleStone stone = new OracleStone(6, 20, false);
        new OracleStoneUpdater(() -> 0.5).update(stone);
        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnfavorableOracleBlessingWhenDayPassesThenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false);
        new OracleStoneUpdater(() -> 0.95).update(stone);
        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStoneWhenDayPassesThenQualityUnchanged() {
        OracleStone stone = new OracleStone(5, 42, true);
        new OracleStoneUpdater().update(stone);
        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
