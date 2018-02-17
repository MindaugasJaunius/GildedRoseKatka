package com.gildedrose.item;

import com.gildedrose.Constants;

public class BackstagePass implements ItemCategory {

    public Item item;

    public BackstagePass(Item item) {
        this.item = item;
    }

    public void updateValues() {
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
}
