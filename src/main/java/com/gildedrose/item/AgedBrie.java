package com.gildedrose.item;

public class AgedBrie implements ItemCategory {

    public Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    public void updateValues() {
        increaseQualityByOne(item);

        item.sellIn--;

        if (hasExpired(item.sellIn)) {
            increaseQualityByOne(item);
        }
    }
}
