package com.gildedrose;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(Constants.AGED_BRIE)) {
                updateAgedBrie(item);
            } else if (item.name.equals(Constants.BACKSTAGE_PASS)) {
                updateBackstagePass(item);
            } else if (item.name.equals(Constants.SULFURAS)) {
                updateSulfuras(item);
            } else if (item.name.equals(Constants.CONJURED)) {
                updateConjured(item);
            } else {
                updateDefaultItem(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQualityByOne(item);

        item.sellIn--;

        if (hasExpired(item.sellIn)) {
            increaseQualityByOne(item);
        }
    }

    private void updateBackstagePass(Item item) {
        increaseQualityByOne(item);

        item.sellIn--;

        if (item.sellIn < Constants.BACKSTAGE_PASS_TEN_DAYS) {
            increaseQualityByOne(item);
        }

        if (item.sellIn < Constants.BACKSTAGE_PASS_FIVE_DAYS) {
            increaseQualityByOne(item);
        }

        if (hasExpired(item.sellIn)) {
            item.quality = Constants.MIN_QUALITY;
        }
    }

    private void updateDefaultItem(Item item) {
        decreaseQualityByOne(item);

        item.sellIn--;

        if (hasExpired(item.sellIn)) {
            decreaseQualityByOne(item);
        }

    }

    private void updateSulfuras(Item item) {

    }

    private void updateConjured(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);

        item.sellIn--;

        if (hasExpired(item.sellIn)) {
            decreaseQualityByOne(item);
            decreaseQualityByOne(item);
        }
    }

    private boolean hasExpired(int sellIn) {
        return sellIn < Constants.EXPIRED_SELL;
    }

    private void decreaseQualityByOne(Item item) {
        if (item.quality > Constants.MIN_QUALITY) {
            item.quality--;
        }
    }

    private void increaseQualityByOne(Item item) {
        if (item.quality < Constants.MAX_QUALITY) {
            item.quality++;
        }
    }

}
