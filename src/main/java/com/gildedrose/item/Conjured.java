package com.gildedrose.item;

public class Conjured implements ItemCategory {

    public Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    public void updateValues() {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);

        item.sellIn--;

        if (hasExpired(item.sellIn)) {
            decreaseQualityByOne(item);
            decreaseQualityByOne(item);
        }
    }
}
