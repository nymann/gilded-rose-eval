package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OracleStoneTest {

    @Test
    void unsealed_oracle_stone_on_ordinary_day_advances_only_day_counter() {
        OracleStone oracle = new OracleStone(1, 20, false);
        oracle.update();

        assertEquals(2, oracle.day);
        assertEquals(20, oracle.quality);
        assertFalse(oracle.sealed);
    }

    @Test
    void oracle_stone_gains_one_quality_on_every_third_day() {
        OracleStone oracle = new OracleStone(2, 20, false);
        oracle.update();

        assertEquals(3, oracle.day);
        assertEquals(21, oracle.quality);
        assertFalse(oracle.sealed);
    }

    @Test
    void favorable_oracle_blessing_on_seventh_day_adds_ten_quality() {
        OracleStone oracle = new OracleStone(6, 20, false);
        OracleStone.nextOracleRoll = 0.5;
        oracle.update();

        assertEquals(7, oracle.day);
        assertEquals(30, oracle.quality);
        assertFalse(oracle.sealed);
    }

    @Test
    void unfavorable_oracle_blessing_seals_stone_without_changing_quality() {
        OracleStone oracle = new OracleStone(6, 20, false);
        OracleStone.nextOracleRoll = 0.95;
        oracle.update();

        assertEquals(7, oracle.day);
        assertEquals(20, oracle.quality);
        assertTrue(oracle.sealed);
    }

    @Test
    void sealed_oracle_stone_does_not_gain_quality_even_on_value_up_days() {
        OracleStone oracle = new OracleStone(5, 42, true);
        oracle.update();

        assertEquals(6, oracle.day);
        assertEquals(42, oracle.quality);
        assertTrue(oracle.sealed);
    }
}
