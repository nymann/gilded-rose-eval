package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WandTest {
    @Test
    void givenWandWithSellIn5AndQuality20_whenDayPasses_thenSellInIs4AndQualityIs19() {
        Item wand = new Item("Wand", 5, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{wand});

        gildedRose.updateQuality();

        assertAll(
            () -> assertEquals(4, wand.sellIn),
            () -> assertEquals(19, wand.quality)
        );
    }
}
