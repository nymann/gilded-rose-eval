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
}
