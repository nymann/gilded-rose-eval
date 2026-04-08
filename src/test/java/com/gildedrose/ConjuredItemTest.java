package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    @Test
    void whenUpdatingConjuredItemQualityDecreasedByTwoBeforeSellByDate() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(8, item.quality);
    }

    @Test
    void whenUpdatingConjuredItemSellInDecreasedByOne() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.sellIn);
    }
}
