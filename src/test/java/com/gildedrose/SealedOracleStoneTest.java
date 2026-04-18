package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SealedOracleStoneTest {

    @Test
    void sealedOracleStoneDoesNotGainQualityEvenOnValueUpDays() {
        Item item = new Item("Sealed Oracle Stone", 5, 42);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(6, item.sellIn);
        assertEquals(42, item.quality);
        assertTrue(item.name.equals("Sealed Oracle Stone"));
    }
}
