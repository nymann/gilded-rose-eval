package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnDayBeforeMultipleOfThree_whenDayPasses_thenQualityIncreasesByOne() {
        Item oracleStone = new Item("Oracle Stone", 2, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{oracleStone});

        gildedRose.updateQuality();

        assertEquals(3, oracleStone.sellIn, "day counter should advance by one");
        assertEquals(21, oracleStone.quality, "quality should increase by one on every third day");
    }

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDay_whenDayPasses_thenDayCounterAdvancesAndQualityIsUnchanged() {
        Item oracleStone = new Item("Oracle Stone", 1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{oracleStone});

        gildedRose.updateQuality();

        assertEquals(2, oracleStone.sellIn, "day counter should advance by one");
        assertEquals(20, oracleStone.quality, "quality should be unchanged on an ordinary day");
    }
}
