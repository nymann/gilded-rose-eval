package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenUnsealedStoneOnOrdinaryDay_whenDayPasses_thenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.5);

        stone.update();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedStoneOnDayBeforeMultipleOfThree_whenDayPasses_thenQualityIncreasesByOne() {
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.5);

        stone.update();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedStoneWithFavorableOracleRollOnSeventhDay_whenDayPasses_thenQualityIncreasesByTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);

        stone.update();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnsealedStoneWithUnfavorableOracleRollOnSeventhDay_whenDayPasses_thenStoneIsSealed() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);

        stone.update();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStone_whenDayPasses_thenQualityDoesNotChange() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.5);

        stone.update();

        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
