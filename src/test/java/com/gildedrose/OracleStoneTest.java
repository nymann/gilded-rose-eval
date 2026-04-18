package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        Item item = new Item("Oracle Stone", 1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(2, item.sellIn);
        assertEquals(20, item.quality);
    }

    @Test
    void givenUnsealedOracleStoneOnDaySevenWithUnfavorableRollWhenDayPassesThenStoneIsSealedAndQualityUnchanged() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.95);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(20, item.quality);
        assertEquals("Sealed Oracle Stone", item.name);
    }

    @Test
    void givenUnsealedOracleStoneOnDaySevenWithFavorableRollWhenDayPassesThenQualityIncreasesByTen() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item}, () -> 0.5);

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(30, item.quality);
    }

    @Test
    void givenUnsealedOracleStoneOnDayTwoWhenDayPassesThenQualityIncreasesOnThirdDay() {
        Item item = new Item("Oracle Stone", 2, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(3, item.sellIn);
        assertEquals(21, item.quality);
    }
}
