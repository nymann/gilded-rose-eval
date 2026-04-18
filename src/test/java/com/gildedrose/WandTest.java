package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WandTest {

    @Test
    void wandAgesOneDayUnderNormalConditions() {
        Item wand = new Item("Wand", 5, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{wand});

        gildedRose.updateQuality();

        assertAll(
            () -> assertEquals(4, wand.sellIn),
            () -> assertEquals(19, wand.quality)
        );
    }

    @Test
    void wandQualityDegradesTwiceAsFastOnceSellInHasPassed() {
        Item wand = new Item("Wand", 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{wand});

        gildedRose.updateQuality();

        assertAll(
            () -> assertEquals(-1, wand.sellIn),
            () -> assertEquals(18, wand.quality)
        );
    }
}
