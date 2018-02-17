package com.gildedrose.item;

import com.gildedrose.Constants;

public class ItemFactory {

    public ItemCategory categorizeItem(Item item) {
        if (item.name.startsWith(Constants.AGED_BRIE)) {
            return new AgedBrie(item);
        } else if (item.name.startsWith(Constants.BACKSTAGE_PASS)) {
            return new BackstagePass(item);
        } else if (item.name.startsWith(Constants.SULFURAS)) {
            return new Sulfuras(item);
        } else if (item.name.startsWith(Constants.CONJURED)) {
            return new Conjured(item);
        } else {
            return new DefaultItem(item);
        }
    }

}
