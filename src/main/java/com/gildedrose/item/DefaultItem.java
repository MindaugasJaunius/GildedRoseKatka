package com.gildedrose.item;

public class DefaultItem implements ItemCategory {

    public Item item;

    public DefaultItem(Item item) {
        this.item = item;
    }

    public void updateValues() {
        decreaseQualityByOne(item);

        item.sellIn--;

        if (hasExpired(item.sellIn)) {
            decreaseQualityByOne(item);
        }
    }
}
