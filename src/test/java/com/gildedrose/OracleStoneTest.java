package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.DoubleSupplier;

class OracleStoneTest {

    private static boolean isSealed(Item item) {
        return item.name.startsWith("Sealed");
    }

    @Test
    void givenSealedOracleStoneOnValueUpDayWhenDayPassesThenDayAdvancesAndQualityAndSealedAreUnchanged() {
        Item item = new Item("Sealed Oracle Stone", 5, 42);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(6, item.sellIn, "day");
        assertEquals(42, item.quality, "quality");
        assertTrue(isSealed(item), "sealed");
    }

    @Test
    void givenUnsealedOracleStoneOnSeventhDayWhenUnfavorableOracleBlessingThenStoneIsSealedAndQualityUnchanged() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose app = new GildedRose(new Item[]{item}, () -> 0.95);

        app.updateQuality();

        assertEquals(7, item.sellIn, "day");
        assertEquals(20, item.quality, "quality");
        assertTrue(isSealed(item), "sealed");
    }

    @Test
    void givenUnsealedOracleStoneOnSeventhDayWhenFavorableOracleBlessingThenQualityAddsTen() {
        Item item = new Item("Oracle Stone", 6, 20);
        GildedRose app = new GildedRose(new Item[]{item}, () -> 0.5);

        app.updateQuality();

        assertEquals(7, item.sellIn, "day");
        assertEquals(30, item.quality, "quality");
        assertFalse(item.quality == 0, "sealed");
    }

    @Test
    void givenUnsealedOracleStoneOnEveryThirdDayWhenDayPassesThenQualityIncreasesByOne() {
        Item item = new Item("Oracle Stone", 2, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(3, item.sellIn, "day");
        assertEquals(21, item.quality, "quality");
        assertFalse(item.quality == 0, "sealed");
    }

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
