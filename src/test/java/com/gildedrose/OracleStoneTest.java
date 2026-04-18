package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void unsealedOracleStoneOnOrdinaryDayAdvancesOnlyTheDayCounter() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void unsealedOracleStoneGainsOneQualityOnEveryThirdDay() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void unfavorableOracleBlessingOnSeventhDaySealsTheStoneWithoutChangingQuality() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day());
        assertEquals(20, stone.quality());
        assertTrue(stone.isSealed());
    }
}
