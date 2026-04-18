package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnSeventhDayWithUnfavorableRollWhenDayPassesThenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);

        stone.tick();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneOnSeventhDayWithFavorableRollWhenDayPassesThenQualityIncreasesByTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);

        stone.tick();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneOnEveryThirdDayWhenDayPassesThenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false);

        stone.tick();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);

        stone.tick();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }
}
