package com.gildedrose;

class GildedRose {
    Item[] items;
    OracleRoller oracleRoller;

    public GildedRose(Item[] items) {
        this.items = items;
        this.oracleRoller = Math::random;
    }

    public void setOracleRoller(OracleRoller oracleRoller) {
        this.oracleRoller = oracleRoller;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof OracleStone) {
                updateOracleStone((OracleStone) items[i]);
                continue;
            }

            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private void updateOracleStone(OracleStone stone) {
        stone.sellIn++;
        if (!stone.sealed) {
            if (stone.sellIn % 7 == 0) {
                if (oracleRoller.roll() <= 0.5) {
                    stone.quality += 10;
                } else {
                    stone.sealed = true;
                }
            } else if (stone.sellIn % 3 == 0) {
                stone.quality += 1;
            }
        }
    }
}
