package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    record Case(int startDay, int startQuality, boolean startSealed,
                double oracleRoll, int expectedDay, int expectedQuality, boolean expectedSealed) {}

    static Stream<Case> ordinaryDayCases() {
        return Stream.of(
            new Case(1, 20, false, 0.0, 2, 20, false),  // S1: non-multiple day, quality unchanged
            new Case(2, 20, false, 0.0, 3, 21, false)   // S2: every third day gains one quality
        );
    }

    @ParameterizedTest
    @MethodSource("ordinaryDayCases")
    void advancesCorrectlyOnOrdinaryDays(Case c) {
        var stone = new OracleStone(c.startDay(), c.startQuality(), c.startSealed(), () -> c.oracleRoll());
        stone.advanceDay();
        assertAll(
            () -> assertEquals(c.expectedDay(), stone.getDay()),
            () -> assertEquals(c.expectedQuality(), stone.getQuality()),
            () -> assertEquals(c.expectedSealed(), stone.isSealed())
        );
    }

    static Stream<Case> seventhDayCases() {
        return Stream.of(
            new Case(6, 20, false, 0.5,  7, 30, false),  // S3: favorable blessing adds ten quality
            new Case(6, 20, false, 0.95, 7, 20, true)    // S4: unfavorable blessing seals the stone
        );
    }

    @ParameterizedTest
    @MethodSource("seventhDayCases")
    void handlesSeventhDayOracleBlessingCorrectly(Case c) {
        var stone = new OracleStone(c.startDay(), c.startQuality(), c.startSealed(), () -> c.oracleRoll());
        stone.advanceDay();
        assertAll(
            () -> assertEquals(c.expectedDay(), stone.getDay()),
            () -> assertEquals(c.expectedQuality(), stone.getQuality()),
            () -> assertEquals(c.expectedSealed(), stone.isSealed())
        );
    }

    static Stream<Case> sealedStoneCases() {
        return Stream.of(
            new Case(5, 42, true, 0.0, 6, 42, true)  // S5: sealed stone ignores value-up days
        );
    }

    @ParameterizedTest
    @MethodSource("sealedStoneCases")
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays(Case c) {
        var stone = new OracleStone(c.startDay(), c.startQuality(), c.startSealed(), () -> c.oracleRoll());
        stone.advanceDay();
        assertAll(
            () -> assertEquals(c.expectedDay(), stone.getDay()),
            () -> assertEquals(c.expectedQuality(), stone.getQuality()),
            () -> assertEquals(c.expectedSealed(), stone.isSealed())
        );
    }
}
