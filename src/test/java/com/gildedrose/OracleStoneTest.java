package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(1, 20, false);

        stone.tick();

        assertAll(
            () -> assertEquals(2, stone.day()),
            () -> assertEquals(20, stone.quality()),
            () -> assertFalse(stone.sealed())
        );
    }

    @Test
    void givenUnsealedOracleStoneOnDayBeforeMultipleOfThreeWhenDayPassesThenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false);

        stone.tick();

        assertAll(
            () -> assertEquals(3, stone.day()),
            () -> assertEquals(21, stone.quality()),
            () -> assertFalse(stone.sealed())
        );
    }
}
