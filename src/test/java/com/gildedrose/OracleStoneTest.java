package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnDaySixWithFavorableRoll_whenDayPasses_thenOracleBlessingAddsTenQuality() {
        OracleStone oracleStone = new OracleStone(6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{oracleStone}, () -> 0.5);

        gildedRose.updateQuality();

        assertEquals(7, oracleStone.sellIn, "day counter should advance by one");
        assertEquals(30, oracleStone.quality, "favorable oracle blessing on the seventh day adds ten quality");
        assertFalse(oracleStone.isSealed(), "stone should remain unsealed after a favorable blessing");
    }

    @Test
    void givenUnsealedOracleStoneOnDaySixWithUnfavorableRoll_whenDayPasses_thenStoneIsSealedAndQualityUnchanged() {
        OracleStone oracleStone = new OracleStone(6, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{oracleStone}, () -> 0.95);

        gildedRose.updateQuality();

        assertEquals(7, oracleStone.sellIn, "day counter should advance by one");
        assertEquals(20, oracleStone.quality, "unfavorable blessing should not change quality");
        assertTrue(oracleStone.isSealed(), "stone should be sealed after an unfavorable blessing");
    }

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
