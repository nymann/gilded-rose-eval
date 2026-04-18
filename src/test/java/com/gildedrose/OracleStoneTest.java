package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        // oracle roll = 0.5 → favorable blessing (requires injectable randomness seam)
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(30, item.quality);
        assertFalse(item.name.contains("Sealed"));
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
    void unsealedOracleStoneOnOrdinaryDayAdvancesDayCounterWithoutChangingQuality() {
        Item item = new Item("Oracle Stone", 1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(2, item.sellIn);
        assertEquals(20, item.quality);
        assertFalse(item.name.contains("Sealed"));
    }
}
