package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    record NonOracleCase(int startDay, int startQuality, boolean startSealed, int expectedQuality) {}

    static Stream<NonOracleCase> nonOracleDayCases() {
        return Stream.of(
            new NonOracleCase(1, 20, false, 20),
            new NonOracleCase(2, 20, false, 21),
            new NonOracleCase(5, 42, true, 42)
        );
    }

    @ParameterizedTest
    @MethodSource("nonOracleDayCases")
    void dayAdvancesAndQualityUpdatesAccordingToRules(NonOracleCase c) {
        var stone = new OracleStone(c.startDay(), c.startQuality(), c.startSealed(), () -> 0.5);
        stone.update();
        assertEquals(c.startDay() + 1, stone.day);
        assertEquals(c.expectedQuality(), stone.quality);
        assertEquals(c.startSealed(), stone.sealed);
    }

    record OracleBlessingCase(double roll, int expectedQuality, boolean expectedSealed) {}

    static Stream<OracleBlessingCase> oracleBlessingCases() {
        return Stream.of(
            new OracleBlessingCase(0.5, 30, false),
            new OracleBlessingCase(0.95, 20, true)
        );
    }

    @ParameterizedTest
    @MethodSource("oracleBlessingCases")
    void oracleBlessingOnSeventhDayEitherAddsQualityOrSeals(OracleBlessingCase c) {
        var stone = new OracleStone(6, 20, false, () -> c.roll());
        stone.update();
        assertEquals(7, stone.day);
        assertEquals(c.expectedQuality(), stone.quality);
        assertEquals(c.expectedSealed(), stone.sealed);
    }
}
