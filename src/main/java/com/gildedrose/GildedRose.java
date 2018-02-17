package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemFactory;

class GildedRose {

    private final ItemFactory itemFactory;
    private Item[] items;

    public GildedRose(Item[] items) {
        this.itemFactory = new ItemFactory();
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            itemFactory.categorizeItem(item).updateValues();
        }
    }

}
