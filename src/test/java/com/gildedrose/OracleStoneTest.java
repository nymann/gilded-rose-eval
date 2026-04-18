package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertAll(
            () -> assertEquals(2, stone.day()),
            () -> assertEquals(20, stone.quality),
            () -> assertFalse(stone.isSealed())
        );
    }

    @Test
    void givenUnsealedOracleStoneWhenFavorableOracleBlessingOnSeventhDayThenQualityIncreasesByTen() {
        DoubleSupplier favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, favorableRoll);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertAll(
            () -> assertEquals(7, stone.day()),
            () -> assertEquals(30, stone.quality),
            () -> assertFalse(stone.isSealed())
        );
    }

    @Test
    void givenUnsealedOracleStoneWhenDayAdvancesToAMultipleOfThreeThenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertAll(
            () -> assertEquals(3, stone.day()),
            () -> assertEquals(21, stone.quality),
            () -> assertFalse(stone.isSealed())
        );
    }
}
