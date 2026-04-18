package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OracleStoneTest {

    @Test
    void s1_oracle_stone_on_ordinary_day_advances_only_day_counter() {
        OracleStone stone = new OracleStone("Oracle Stone", 1, 20);
        GildedRose gilded = new GildedRose(new Item[] { stone });
        gilded.updateQuality();

        assertEquals(2, stone.sellIn);
        assertEquals(20, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void s2_oracle_stone_gains_one_quality_on_every_third_day() {
        OracleStone stone = new OracleStone("Oracle Stone", 2, 20);
        GildedRose gilded = new GildedRose(new Item[] { stone });
        gilded.updateQuality();

        assertEquals(3, stone.sellIn);
        assertEquals(21, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void s3_favorable_oracle_blessing_on_seventh_day_adds_ten_quality() {
        OracleStone stone = new OracleStone("Oracle Stone", 6, 20);
        GildedRose gilded = new GildedRose(new Item[] { stone });
        gilded.setOracleRoller(() -> 0.5);
        gilded.updateQuality();

        assertEquals(7, stone.sellIn);
        assertEquals(30, stone.quality);
        assertFalse(stone.sealed);
    }

    @Test
    void s4_unfavorable_oracle_blessing_seals_stone_without_changing_quality() {
        OracleStone stone = new OracleStone("Oracle Stone", 6, 20);
        GildedRose gilded = new GildedRose(new Item[] { stone });
        gilded.setOracleRoller(() -> 0.95);
        gilded.updateQuality();

        assertEquals(7, stone.sellIn);
        assertEquals(20, stone.quality);
        assertTrue(stone.sealed);
    }

    @Test
    void s5_sealed_oracle_stone_does_not_gain_quality_even_on_value_up_days() {
        OracleStone stone = new OracleStone("Oracle Stone", 5, 42);
        stone.sealed = true;
        GildedRose gilded = new GildedRose(new Item[] { stone });
        gilded.updateQuality();

        assertEquals(6, stone.sellIn);
        assertEquals(42, stone.quality);
        assertTrue(stone.sealed);
    }
}
