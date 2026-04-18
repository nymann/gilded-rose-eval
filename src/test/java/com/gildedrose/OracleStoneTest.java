package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class OracleStoneTest {

    @Test
    void ordinaryDayAdvancesDayCounterOnly() {
        var stone = new OracleStone(1, 20, false);
        stone.tick();
        assertThat(stone.getDay()).isEqualTo(2);
        assertThat(stone.getQuality()).isEqualTo(20);
        assertThat(stone.isSealed()).isFalse();
    }

    @Test
    void gainsOneQualityOnEveryThirdDay() {
        var stone = new OracleStone(2, 20, false);
        stone.tick();
        assertThat(stone.getDay()).isEqualTo(3);
        assertThat(stone.getQuality()).isEqualTo(21);
        assertThat(stone.isSealed()).isFalse();
    }

    @Test
    void favorableOracleBlessingOnSeventhDayAddsTenQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.5);
        stone.tick();
        assertThat(stone.getDay()).isEqualTo(7);
        assertThat(stone.getQuality()).isEqualTo(30);
        assertThat(stone.isSealed()).isFalse();
    }

    @Test
    void unfavorableOracleBlessingSealsStoneWithoutChangingQuality() {
        var stone = new OracleStone(6, 20, false, () -> 0.95);
        stone.tick();
        assertThat(stone.getDay()).isEqualTo(7);
        assertThat(stone.getQuality()).isEqualTo(20);
        assertThat(stone.isSealed()).isTrue();
    }

    @Test
    void sealedStoneDoesNotGainQualityEvenOnValueUpDays() {
        var stone = new OracleStone(5, 42, true);
        stone.tick();
        assertThat(stone.getDay()).isEqualTo(6);
        assertThat(stone.getQuality()).isEqualTo(42);
        assertThat(stone.isSealed()).isTrue();
    }
}
