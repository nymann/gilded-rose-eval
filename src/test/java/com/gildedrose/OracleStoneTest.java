package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneWithFavorableRollOnSeventhDay_whenDayPasses_thenDayAdvancesQualityGainsTenRemainsUnsealed() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneOnEveryThirdDay_whenDayPasses_thenDayAdvancesQualityIncreasedByOneRemainsUnsealed() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDay_whenDayPasses_thenDayAdvancesQualityUnchangedRemainsUnsealed() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }
}
