package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, () -> 0.0);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.getDay());
        assertEquals(20, stone.quality);
        assertFalse(stone.isSealed());
    }

    @Test
    void givenEveryThirdDay_whenDayPasses_thenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, () -> 0.0);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.getDay());
        assertEquals(21, stone.quality);
        assertFalse(stone.isSealed());
    }

    @Test
    void givenFavorableOracleBlessingOnSeventhDay_whenDayPasses_thenQualityAddsTen() {
        OracleStone stone = new OracleStone(6, 20, () -> 0.5);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.getDay());
        assertEquals(30, stone.quality);
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnfavorableOracleBlessingOnSeventhDay_whenDayPasses_thenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, () -> 0.95);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.getDay());
        assertEquals(20, stone.quality);
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityDoesNotChangeEvenOnValueUpDay() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.0);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(6, stone.getDay());
        assertEquals(42, stone.quality);
        assertTrue(stone.isSealed());
    }
}
