package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDayOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        OracleStoneUpdater updater = new OracleStoneUpdater(() -> 0.5);

        updater.update(stone);

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenEveryThirdDayOracleStoneGainsOneQuality() {
        OracleStone stone = new OracleStone(2, 20, false);
        OracleStoneUpdater updater = new OracleStoneUpdater(() -> 0.5);

        updater.update(stone);

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenFavorableOracleBlessingOnSeventhDayAddsTenQuality() {
        OracleStone stone = new OracleStone(6, 20, false);
        OracleStoneUpdater updater = new OracleStoneUpdater(() -> 0.5);

        updater.update(stone);

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnfavorableOracleBlessingSealsStoneWithoutChangingQuality() {
        OracleStone stone = new OracleStone(6, 20, false);
        OracleStoneUpdater updater = new OracleStoneUpdater(() -> 0.95);

        updater.update(stone);

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedOracleStoneDoesNotGainQualityEvenOnValueUpDays() {
        OracleStone stone = new OracleStone(5, 42, true);
        OracleStoneUpdater updater = new OracleStoneUpdater(() -> 0.5);

        updater.update(stone);

        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
