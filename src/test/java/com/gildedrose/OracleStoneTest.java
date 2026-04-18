package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenDayBeforeThirdDayWhenDayPassesThenQualityIncreasedByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenFavorableOracleRollOnSeventhDayWhenDayPassesThenQualityIncreasedByTen() {
        OracleStone stone = new OracleStone(6, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone}, () -> 0.5);

        gildedRose.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnfavorableOracleRollOnSeventhDayWhenDayPassesThenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone}, () -> 0.95);

        gildedRose.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStoneWhenDayPassesThenQualityDoesNotChange() {
        OracleStone stone = new OracleStone(5, 42, true);
        GildedRose gildedRose = new GildedRose(new Item[]{stone}, () -> 0.5);

        gildedRose.updateQuality();

        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
