package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20);

        stone.update(0.5);

        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenThirdDayWhenDayPassesThenQualityGainsByOne() {
        OracleStone stone = new OracleStone(2, 20);

        stone.update(0.5);

        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenSeventhDayWithFavorableOracleRollWhenDayPassesThenQualityGainsByTen() {
        OracleStone stone = new OracleStone(6, 20);

        stone.update(0.5);

        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenSeventhDayWithUnfavorableOracleRollWhenDayPassesThenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20);

        stone.update(0.95);

        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedStoneWhenDayPassesThenQualityIsUnchanged() {
        OracleStone stone = new OracleStone(5, 42, true);

        stone.update(0.5);

        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
