package com.gildedrose.item;

import com.gildedrose.Constants;

public interface ItemCategory {
    void updateValues();

    default void increaseQualityByOne(Item item) {
        if (item.quality < Constants.MAX_QUALITY) {
            item.quality++;
        }
    }

    default void decreaseQualityByOne(Item item) {
        if (item.quality > Constants.MIN_QUALITY) {
            item.quality--;
        }
    }

    default boolean hasExpired(int sellIn) {
        return sellIn < Constants.EXPIRED_SELL;
    }
}
