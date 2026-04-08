package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {

    @Test
    void conjuredItemsDegradeInQualityTwiceAsFastAsNormalItems() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(8, item.quality);
    }

    @Test
    void conjuredItemSellInDecreasesBy1PerDay() {
        Item item = new Item("Conjured Mana Cake", 5, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.sellIn);
    }

    @Test
    void onceSellByDateHasPassedQualityDegradesTwiceAsFastAgain() {
        Item item = new Item("Conjured Mana Cake", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(6, item.quality);
    }

    @Test
    void qualityOfAConjuredItemCanNeverBecomeNegative() {
        Item item = new Item("Conjured Mana Cake", 5, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }
}
