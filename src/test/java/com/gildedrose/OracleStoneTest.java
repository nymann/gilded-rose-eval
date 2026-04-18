package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDayBeforeMultipleOfThreeWhenDayPassesThenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenFavorableOracleRollOnSeventhDayWhenDayPassesThenQualityIncreasesByTen() {
        DoubleSupplier favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, favorableRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnfavorableOracleRollOnSeventhDayWhenDayPassesThenStoneIsSealedAndQualityUnchanged() {
        DoubleSupplier unfavorableRoll = () -> 0.95;
        OracleStone stone = new OracleStone(6, 20, false, unfavorableRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(20, stone.quality());
        assertTrue(stone.sealed());
    }

    @Test
    void givenSealedOracleStoneOnDayBeforeMultipleOfThreeWhenDayPassesThenQualityDoesNotChange() {
        OracleStone stone = new OracleStone(5, 42, true);
        GildedRose gildedRose = new GildedRose(new Item[]{stone.toItem()});

        gildedRose.updateQuality();

        assertEquals(6, stone.day());
        assertEquals(42, stone.quality());
        assertTrue(stone.sealed());
    }
}
