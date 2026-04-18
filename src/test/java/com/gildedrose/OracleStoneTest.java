package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenSealedOracleStoneQualityDoesNotIncreaseEvenOnValueUpDay() {
        OracleStone stone = new OracleStone(5, 42, true);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenUnfavorableOracleRollOnSeventhDayStoneSealedWithQualityUnchanged() {
        DoubleSupplier unfavorableRoll = () -> 0.95;
        OracleStone stone = new OracleStone(6, 20, false, unfavorableRoll);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenFavorableOracleRollOnSeventhDayQualityIncreasesByTen() {
        DoubleSupplier favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, favorableRoll);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneQualityIncreasesByOneOnEveryThirdDay() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }
}
