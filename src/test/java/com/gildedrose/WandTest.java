package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WandTest {
    @Test
    void wand_ages_one_day_under_normal_conditions() {
        Item wand = new Item("Wand", 5, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{wand});

        gildedRose.updateQuality();

        assertAll(
            () -> assertEquals(4, wand.sellIn),
            () -> assertEquals(19, wand.quality)
        );
    }
}
