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

    @Test
    void givenWandWithSellIn0AndQuality20_whenDayPasses_thenSellInIsNeg1AndQualityIs18() {
        Item wand = new Item("Wand", 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{wand});

        gildedRose.updateQuality();

        assertAll(
            () -> assertEquals(-1, wand.sellIn),
            () -> assertEquals(18, wand.quality)
        );
    }

    @Test
    void givenWandWithQuality0_whenDayPasses_thenQualityRemainsAt0() {
        Item wand = new Item("Wand", 5, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{wand});

        gildedRose.updateQuality();

        assertEquals(0, wand.quality);
    }
}
