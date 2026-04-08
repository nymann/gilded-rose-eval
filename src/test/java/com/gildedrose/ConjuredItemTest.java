package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {

    @Test
    void givenConjuredItemBeforeSellByDate_whenUpdatingQuality_thenQualityDecreasesByTwo() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(8, item.quality);
    }

    @Test
    void givenConjuredItemBeforeSellByDate_whenUpdatingQuality_thenSellInDecreasesByOne() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.sellIn);
    }

    @Test
    void givenConjuredItemOnSellByDate_whenUpdatingQuality_thenQualityDecreasesByFour() {
        Item item = new Item("Conjured Mana Cake", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(6, item.quality);
    }

    @Test
    void givenConjuredItemWithQualityLessThanDegradeAmount_whenUpdatingQuality_thenQualityDoesNotGoBelowZero() {
        Item item = new Item("Conjured Mana Cake", 5, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }

    @Test
    void givenConjuredItemAfterSellByDateWithQualityLessThanDegradeAmount_whenUpdatingQuality_thenQualityDoesNotGoBelowZero() {
        Item item = new Item("Conjured Mana Cake", 0, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }
}
