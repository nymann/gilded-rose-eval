package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20);

        stone.tick();

        assertEquals(2, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedOracleStoneWhenDayIsMultipleOfThreeThenQualityIncreasedByOne() {
        OracleStone stone = new OracleStone(2, 20);

        stone.tick();

        assertEquals(3, stone.getDay());
        assertEquals(21, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDaySevenWithFavorableRollWhenDayPassesThenQualityIncreasedByTen() {
        DoubleSupplier favorableRoll = () -> 0.5;
        OracleStone stone = new OracleStone(6, 20, favorableRoll);

        stone.tick();

        assertEquals(7, stone.getDay());
        assertEquals(30, stone.getQuality());
        assertFalse(stone.isSealed());
    }

    @Test
    void givenUnsealedOracleStoneOnDaySevenWithUnfavorableRollWhenDayPassesThenStoneIsSealed() {
        DoubleSupplier unfavorableRoll = () -> 0.95;
        OracleStone stone = new OracleStone(6, 20, unfavorableRoll);

        stone.tick();

        assertEquals(7, stone.getDay());
        assertEquals(20, stone.getQuality());
        assertTrue(stone.isSealed());
    }

    @Test
    void givenSealedOracleStoneWhenDayPassesThenQualityDoesNotChange() {
        OracleStone stone = new OracleStone(5, 42, true);

        stone.tick();

        assertEquals(6, stone.getDay());
        assertEquals(42, stone.getQuality());
        assertTrue(stone.isSealed());
    }
}
