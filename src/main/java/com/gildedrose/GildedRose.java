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

//    private void updateAgedBrie(Item item) {
//        increaseQualityByOne(item);
//
//        item.sellIn--;
//
//        if (hasExpired(item.sellIn)) {
//            increaseQualityByOne(item);
//        }
//    }
//
//    private void updateBackstagePass(Item item) {
//        increaseQualityByOne(item);
//
//        item.sellIn--;
//
//        if (item.sellIn < Constants.BACKSTAGE_PASS_TEN_DAYS) {
//            increaseQualityByOne(item);
//        }
//
//        if (item.sellIn < Constants.BACKSTAGE_PASS_FIVE_DAYS) {
//            increaseQualityByOne(item);
//        }
//
//        if (hasExpired(item.sellIn)) {
//            item.quality = Constants.MIN_QUALITY;
//        }
//    }
//
//    private void updateDefaultItem(Item item) {
//        decreaseQualityByOne(item);
//
//        item.sellIn--;
//
//        if (hasExpired(item.sellIn)) {
//            decreaseQualityByOne(item);
//        }
//
//    }
//
//    private void updateSulfuras(Item item) {
//
//    }
//
//    private void updateConjured(Item item) {
//        decreaseQualityByOne(item);
//        decreaseQualityByOne(item);
//
//        item.sellIn--;
//
//        if (hasExpired(item.sellIn)) {
//            decreaseQualityByOne(item);
//            decreaseQualityByOne(item);
//        }
//    }
//
//    private boolean hasExpired(int sellIn) {
//        return sellIn < Constants.EXPIRED_SELL;
//    }
//
//    private void decreaseQualityByOne(Item item) {
//        if (item.quality > Constants.MIN_QUALITY) {
//            item.quality--;
//        }
//    }
//
//    private void increaseQualityByOne(Item item) {
//        if (item.quality < Constants.MAX_QUALITY) {
//            item.quality++;
//        }
//    }

}
