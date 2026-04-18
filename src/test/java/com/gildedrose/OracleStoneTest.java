package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnSeventhDayWithUnfavorableRoll_whenDayPasses_thenStoneIsSealedAndQualityUnchanged() {
        DoubleSupplier unfavorableRoll = () -> 0.95;
        OracleStone stone = new OracleStone(6, 20, false, unfavorableRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(20, stone.quality());
        assertTrue(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnSeventhDayWithFavorableRoll_whenDayPasses_thenQualityIncreasesByTen() {
        DoubleSupplier favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, favorableRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDayBeforeMultipleOfThree_whenDayPasses_thenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.sealed());
    }
}
