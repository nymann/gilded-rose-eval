package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        Item item = new Item("Oracle Stone", 1, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(2, item.sellIn, "day");
        assertEquals(20, item.quality, "quality");
        assertFalse(item.quality == 0, "sealed");
    }
}
