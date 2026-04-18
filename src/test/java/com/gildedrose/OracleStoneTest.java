package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);

        stone.tick();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneWhenDayAdvancesToMultipleOfThreeThenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false);

        stone.tick();

        assertEquals(3, stone.day());
        assertEquals(21, stone.quality());
        assertFalse(stone.sealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDaySevenWhenOracleBlessingIsFavorableThenQualityIncreasesByTen() {
        OracleStone stone = new OracleStone(6, 20, false);

        stone.tick(0.5);

        assertEquals(7, stone.day());
        assertEquals(30, stone.quality());
        assertFalse(stone.sealed());
    }
}
