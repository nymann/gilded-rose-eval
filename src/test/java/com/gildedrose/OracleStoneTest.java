package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OracleStoneTest {

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
