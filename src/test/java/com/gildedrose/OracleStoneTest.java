package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.function.DoubleSupplier;

public class OracleStoneTest {

    @Test
    void sealedOracleStoneDoesNotGainQualityEvenOnValueUpDays() {
        Item item = new Item("Oracle Stone", 13, 42);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.95);
        gildedRose.updateQuality(); // seals on day 14 (14 % 7 == 0, unfavorable roll)

        gildedRose.updateQuality(); // day 15 is a multiple of 3 — quality would normally increase

        assertEquals(15, item.sellIn);
        assertEquals(42, item.quality);
        assertTrue(gildedRose.isSealed(item));
    }

    @Test
    void unfavorableOracleBlessingOnTheSeventhDaySealsStoneLeavingQualityUnchanged() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.95);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(20, item.quality);
        assertTrue(gildedRose.isSealed(item));
    }

    @Test
    void favorableOracleBlessingOnTheSeventhDayAddsTenQuality() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.5);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(30, item.quality);
    }

    @Test
    void unsealedOracleStoneGainsOneQualityWhenDayCounterReachesAMultipleOfThree() {
        Item item = new Item("Oracle Stone", 2, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(3, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void unseakedOracleStoneOnOrdinaryDayAdvancesOnlyTheDayCounter() {
        Item item = new Item("Oracle Stone", 1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(2, item.sellIn);
        assertEquals(20, item.quality);
    }
}
