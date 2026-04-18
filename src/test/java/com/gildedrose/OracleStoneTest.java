package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnDaySixWithUnfavorableOracleRoll_whenSeventhDayPasses_thenStoneIsSealedAndQualityUnchanged() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(20, stone.quality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDaySixWithFavorableOracleRoll_whenSeventhDayPasses_thenQualityIncreasedByTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDayBeforeThirdDay_whenDayPasses_thenQualityIncreasedByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDay_whenDayPasses_thenDayAdvancesAndQualityAndSealedAreUnchanged() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.isSealed());
    }
}
