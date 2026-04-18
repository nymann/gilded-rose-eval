package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleStoneTest {

    @Test
    void unfavorableOracleBlessingOnSeventhDaySealsStoneLeavingQualityUnchanged() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);

        stone.advanceDay();

        assertAll(
            () -> assertEquals(7, stone.day()),
            () -> assertEquals(20, stone.quality()),
            () -> assertTrue(stone.sealed())
        );
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);

        stone.advanceDay();

        assertAll(
            () -> assertEquals(7, stone.day()),
            () -> assertEquals(30, stone.quality()),
            () -> assertFalse(stone.sealed())
        );
    }

    @Test
    void unsealedOracleStoneGainsOneQualityOnEveryThirdDay() {
        OracleStone stone = new OracleStone(2, 20, false);

        stone.advanceDay();

        assertAll(
            () -> assertEquals(3, stone.day()),
            () -> assertEquals(21, stone.quality()),
            () -> assertFalse(stone.sealed())
        );
    }

    @Test
    void unsealedOracleStoneOnOrdinaryDayAdvancesOnlyTheDayCounter() {
        OracleStone stone = new OracleStone(1, 20, false);

        stone.advanceDay();

        assertAll(
            () -> assertEquals(2, stone.day()),
            () -> assertEquals(20, stone.quality()),
            () -> assertFalse(stone.sealed())
        );
    }
}
