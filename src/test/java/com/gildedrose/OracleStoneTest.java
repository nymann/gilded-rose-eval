package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void givenUnseaedOracleStoneOnOrdinaryDayOnlyTheDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneQualityIncreasesByOneOnEveryThirdDay() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneOnSeventhDayFavorableRollAddstenQuality() {
        DoubleSupplier favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, favorableRoll);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }
}
