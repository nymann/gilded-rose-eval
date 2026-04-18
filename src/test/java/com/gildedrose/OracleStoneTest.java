package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void givenOrdinaryDayWhenDayPassesThenOnlyDayAdvances() {
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.5);

        stone.update();

        assertEquals(2, stone.day);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenEveryThirdDayWhenDayPassesThenQualityIncreasedByOne() {
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.5);

        stone.update();

        assertEquals(3, stone.day);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenFavorableOracleBlessingOnSeventhDayWhenDayPassesThenQualityAddsTen() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);

        stone.update();

        assertEquals(7, stone.day);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void givenUnfavorableOracleBlessingWhenDayPassesThenStoneSealedWithoutQualityChange() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);

        stone.update();

        assertEquals(7, stone.day);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void givenSealedStoneWhenDayPassesThenQualityUnchangedEvenOnValueUpDays() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.5);

        stone.update();

        assertEquals(6, stone.day);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
