package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void unfavorableOracleBlessingOnSeventhDaySealsStoneLeavingQualityUnchanged() {
        Item item = new Item("Oracle Stone", 6, 20);
        DoubleSupplier unfavorableRoll = () -> 0.95;
        GildedRose gildedRose = new GildedRose(new Item[]{item}, unfavorableRoll);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(20, item.quality);
        assertTrue(item.name.equals("Sealed Oracle Stone"));
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        Item item = new Item("Oracle Stone", 6, 20);
        DoubleSupplier favorableRoll = () -> 0.5;
        GildedRose gildedRose = new GildedRose(new Item[]{item}, favorableRoll);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(30, item.quality);
    }

    @Test
    void unsealedOracleStoneGainsOneQualityOnEveryThirdDay() {
        Item item = new Item("Oracle Stone", 2, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(3, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void unsealedOracleStoneOnOrdinaryDayAdvancesOnlyTheDayCounter() {
        Item item = new Item("Oracle Stone", 1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(2, item.sellIn);
        assertEquals(20, item.quality);
    }
}
