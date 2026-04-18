package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.DoubleSupplier;

public class OracleStoneTest {

    @Test
    void givenSeventhDayWithUnfavorableOracleRollUnsealedOracleStoneBecomesSealed() {
        DoubleSupplier fixedRoll = () -> 0.95;
        OracleStone stone = new OracleStone(6, 20, false, fixedRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSeventhDayWithFavorableOracleRollUnsealedOracleStoneGainsTenQuality() {
        DoubleSupplier fixedRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, fixedRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenEveryThirdDayUnsealedOracleStoneGainsOneQuality() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenOrdinaryDayUnsealedOracleStoneAdvancesOnlyTheDayCounter() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }
}
