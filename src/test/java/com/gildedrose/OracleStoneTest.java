package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OracleStoneTest {

    @Test
    void givenUnsealedOracleStoneOnOrdinaryDay_whenDayPasses_thenDayAdvancesAndQualityAndSealedAreUnchanged() {
        OracleStone stone = new OracleStone(1, 20, false);
        GildedRose app = new GildedRose(new Item[]{stone});

        app.updateQuality();

        assertEquals(2, stone.day());
        assertEquals(20, stone.quality());
        assertFalse(stone.isSealed());
    }
}
