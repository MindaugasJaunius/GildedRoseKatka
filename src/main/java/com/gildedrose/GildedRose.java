package com.gildedrose;

class GildedRose {

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final int MAX_QUALITY = 50;

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(SULFURAS))
                continue;
            updateItemValues(item);
        }
    }

    private void updateItemValues(Item item) {
        updateItemQuality(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            updateExpiredItem(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQualityByOne(item);
        } else if (item.name.equals(BACKSTAGE_PASS)) {
            updateBackstagePass(item);
        } else decreaseQualityByOne(item);
    }

    private void updateBackstagePass(Item item) {
        increaseQualityByOne(item);

        if (item.sellIn < 11) {
            increaseQualityByOne(item);
        }

        if (item.sellIn < 6) {
            increaseQualityByOne(item);
        }
    }

    private void updateExpiredItem(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQualityByOne(item);
        } else if (item.name.equals(BACKSTAGE_PASS)) {
            item.quality = 0;
        } else decreaseQualityByOne(item);
    }

    private void decreaseQualityByOne(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQualityByOne(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

}
