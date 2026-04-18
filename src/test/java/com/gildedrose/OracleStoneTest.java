package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.5);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(30, item.quality);
        assertFalse(item.name.contains("Sealed"));
    }

    @Test
    void unfavorableOracleBlessingOnSeventhDaySealsStoneLeavingQualityUnchanged() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.95);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(20, item.quality);
        assertTrue(item.name.contains("Sealed"));
    }

    @Test
    void unsealedOracleStoneGainsOneQualityOnEveryThirdDay() {
        Item item = new Item("Oracle Stone", 2, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(3, item.sellIn);
        assertEquals(21, item.quality);
        assertFalse(item.name.contains("Sealed"));
    }

    @Test
    void sealedOracleStoneDoesNotGainQualityEvenOnValueUpDays() {
        Item item = new Item("Sealed Oracle Stone", 5, 42);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(6, item.sellIn);
        assertEquals(42, item.quality);
        assertTrue(item.name.contains("Sealed"));
    }

    @Test
    void unsealedOracleStoneOnOrdinaryDayAdvancesDayCounterWithoutChangingQuality() {
        Item item = new Item("Oracle Stone", 1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(2, item.sellIn);
        assertEquals(20, item.quality);
        assertFalse(item.name.contains("Sealed"));
    }
}
