package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class OracleStoneTest {

    @Test
    void ordinaryDayAdvancesOnlyDayCounter() {
        OracleStone stone = new OracleStone(1, 20, false, () -> 0.0);
        stone.advanceDay();
        assertThat(stone.day).isEqualTo(2);
        assertThat(stone.quality).isEqualTo(20);
        assertThat(stone.sealed).isFalse();
    }

    @Test
    void gainsOneQualityEveryThirdDay() {
        OracleStone stone = new OracleStone(2, 20, false, () -> 0.0);
        stone.advanceDay();
        assertThat(stone.day).isEqualTo(3);
        assertThat(stone.quality).isEqualTo(21);
        assertThat(stone.sealed).isFalse();
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.advanceDay();
        assertThat(stone.day).isEqualTo(7);
        assertThat(stone.quality).isEqualTo(30);
        assertThat(stone.sealed).isFalse();
    }

    @Test
    void unfavorableOracleBlessingSealsStoneWithoutChangingQuality() {
        OracleStone stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.advanceDay();
        assertThat(stone.day).isEqualTo(7);
        assertThat(stone.quality).isEqualTo(20);
        assertThat(stone.sealed).isTrue();
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        OracleStone stone = new OracleStone(5, 42, true, () -> 0.0);
        stone.advanceDay();
        assertThat(stone.day).isEqualTo(6);
        assertThat(stone.quality).isEqualTo(42);
        assertThat(stone.sealed).isTrue();
    }
}
