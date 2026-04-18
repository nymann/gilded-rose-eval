package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20);

        stone.advanceDay();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenThirdDayWhenDayPassesThenQualityGainsByOne() {
        OracleStone stone = new OracleStone(2, 20);

        stone.advanceDay();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenSeventhDayWithFavorableOracleRollWhenDayPassesThenQualityGainsByTen() {
        OracleStone stone = new OracleStone(6, 20, () -> 0.5);

        stone.advanceDay();

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenSeventhDayWithUnfavorableOracleRollWhenDayPassesThenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, () -> 0.95);

        stone.advanceDay();

        assertEquals(7, stone.day());
        assertEquals(20, stone.quality());
        assertTrue(stone.isSealed());
    }

    @Test
    void sealedOracleStoneDoesNotGainQualityEvenOnValueUpDays() {
        OracleStone stone = new OracleStone(5, 42, true);

        stone.advanceDay();

        assertEquals(6, stone.day());
        assertEquals(42, stone.quality());
        assertTrue(stone.isSealed());
    }
}
