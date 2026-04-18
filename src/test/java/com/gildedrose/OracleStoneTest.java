package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void givenUnfavorableOracleRollOnSeventhDayWhenDayPassesThenStoneIsSealedWithUnchangedQuality() {
        DoubleSupplier fixedRoll = () -> 0.95;
        OracleStone stone = new OracleStone(/* day= */ 6, /* quality= */ 20, /* sealed= */ false, fixedRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(20, stone.quality());
        assertTrue(stone.sealed());
    }

    @Test
    void givenFavorableOracleRollOnSeventhDayWhenDayPassesThenQualityGainsTen() {
        DoubleSupplier fixedRoll = () -> 0.5;
        OracleStone stone = new OracleStone(/* day= */ 6, /* quality= */ 20, /* sealed= */ false, fixedRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnEveryThirdDayWhenDayPassesThenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(/* day= */ 2, /* quality= */ 20, /* sealed= */ false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(/* day= */ 1, /* quality= */ 20, /* sealed= */ false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.sealed());
    }
}
