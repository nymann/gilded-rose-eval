package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

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

    @Test
    void givenUnsealedOracleStoneWithFavorableRollWhenAdvancingToMultipleOfSevenThenQualityIncreasesByTen() {
        Supplier<Double> favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, false, favorableRoll);

        stone.tick();

        assertAll(
            () -> assertEquals(7, stone.day()),
            () -> assertEquals(30, stone.quality()),
            () -> assertFalse(stone.sealed())
        );
    }
}
