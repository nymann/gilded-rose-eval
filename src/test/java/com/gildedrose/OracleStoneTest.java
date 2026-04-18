package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    // sellIn = -day so GildedRose's decrement maps day N → day N+1
    // sealed state indicated by item name containing "(Sealed)"

    private static Item unsealed(int day, int quality) {
        return new Item("Oracle Stone", -day, quality);
    }

    private static Item sealed(int day, int quality) {
        return new Item("Oracle Stone (Sealed)", -day, quality);
    }

    private static int day(Item item) {
        return -item.sellIn;
    }

    private static boolean isSealed(Item item) {
        return item.name.contains("(Sealed)");
    }

    @Test
    void ordinaryDayAdvancesOnlyTheDayCounter() {
        Item item = unsealed(1, 20);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(2, day(item));
        assertEquals(20, item.quality);
        assertFalse(isSealed(item));
    }

    @Test
    void gainsOneQualityOnEveryThirdDay() {
        Item item = unsealed(2, 20);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(3, day(item));
        assertEquals(21, item.quality);
        assertFalse(isSealed(item));
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        Item item = unsealed(6, 20);
        new GildedRose(new Item[]{item}, () -> 0.5).updateQuality();
        assertEquals(7, day(item));
        assertEquals(30, item.quality);
        assertFalse(isSealed(item));
    }

    @Test
    void unfavorableOracleBlessingSealsTheStoneWithoutChangingQuality() {
        Item item = unsealed(6, 20);
        new GildedRose(new Item[]{item}, () -> 0.95).updateQuality();
        assertEquals(7, day(item));
        assertEquals(20, item.quality);
        assertTrue(isSealed(item));
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        Item item = sealed(5, 42);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(6, day(item));
        assertEquals(42, item.quality);
        assertTrue(isSealed(item));
    }
}
