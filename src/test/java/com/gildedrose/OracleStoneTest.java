package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.5);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenDayTwoWhenDayPassesThenQualityIncreasesOnThirdDay() {
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.5);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenDaySixWithFavorableRollWhenDayPassesThenQualityGainsTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenDaySixWithUnfavorableRollWhenDayPassesThenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStoneWhenDayPassesThenQualityDoesNotChange() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.5);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
