package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDayWhenDayPassesThenOnlyDayCounterAdvances() {
        OracleStone stone = new OracleStone(/* day= */ 1, /* quality= */ 20, /* sealed= */ false);
        GildedRose gildedRose = new GildedRose(new Item[]{stone});

        gildedRose.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.sealed());
    }
}
