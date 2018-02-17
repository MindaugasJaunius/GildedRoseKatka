package com.gildedrose;

import static org.junit.Assert.assertEquals;

import com.gildedrose.item.Item;
import org.junit.Test;

public class GildedRoseTest {

    private GildedRose inn;

    @Test
    public void item_lowers_in_quality_and_sellin_by_one_after_updateQuality_call() {
        Item[] items = {new Item("foo", 10, 10)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    @Test
    public void item_name_never_changes() throws Exception {
        Item[] items = {new Item("foo", 10, 10)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals("foo", items[0].name);
    }

    @Test
    public void when_sellin_becomes_zero_quality_degrades_by_two() throws Exception {
        Item[] items = {new Item("foo", 0, 10)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    public void item_quality_does_not_become_negative_with_sellin_change() throws Exception {
        Item[] items = {new Item("foo", 10, 0)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void item_quality_does_not_become_negative_with_zero_sellin() throws Exception {
        Item[] items = {new Item("foo", 0, 1)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void aged_brie_increases_quality_by_one_with_positive_sellin() throws Exception {
        Item[] items = {new Item(Constants.AGED_BRIE, 10, 10)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    @Test
    public void aged_brie_increases_quality_by_two_with_negative_sellin() throws Exception {
        Item[] items = {new Item(Constants.AGED_BRIE, -1, 10)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(-2, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    public void item_does_not_increase_in_quality_after_reaching_fifty() throws Exception {
        Item[] items = {new Item(Constants.AGED_BRIE, 10, Constants.MAX_QUALITY)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(Constants.MAX_QUALITY, items[0].quality);
    }

    @Test
    public void sulfuras_does_not_change_values_after_updateQuality_call() throws Exception {
        Item[] items = {new Item(Constants.SULFURAS, 10, 80)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(Constants.SULFURAS, items[0].name);
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    public void backstage_passes_increases_quality_by_two_when_sellin_is_ten_or_less() throws Exception {
        Item[] items = {new Item(Constants.BACKSTAGE_PASS, 10, 20),
                new Item(Constants.BACKSTAGE_PASS, 8, 49)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
        assertEquals(7, items[1].sellIn);
        assertEquals(Constants.MAX_QUALITY, items[1].quality);
    }

    @Test
    public void backstage_passes_increases_quality_by_three_when_sellin_is_five_or_less() throws Exception {
        Item[] items = {new Item(Constants.BACKSTAGE_PASS, 5, 20),
                new Item(Constants.BACKSTAGE_PASS, 3, 49)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
        assertEquals(2, items[1].sellIn);
        assertEquals(Constants.MAX_QUALITY, items[1].quality);
    }

    @Test
    public void backstage_passes_drops_quality_to_zero_after_concert() throws Exception {
        Item[] items = {new Item(Constants.BACKSTAGE_PASS, 0, Constants.MIN_QUALITY),
                new Item(Constants.BACKSTAGE_PASS, -1, Constants.MAX_QUALITY)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(Constants.MIN_QUALITY, items[0].quality);
        assertEquals(-2, items[1].sellIn);
        assertEquals(Constants.MIN_QUALITY, items[1].quality);
    }

    @Test
    public void item_toString_preserved() {
        Item[] items = {new Item("foo", 0, 0)};
        inn = new GildedRose(items);

        assertEquals("foo, 0, 0", items[0].toString());
    }

    @Test
    public void conjured_item_drops_quality_by_two_with_positive_sellin() throws Exception {
        Item[] items = {new Item(Constants.CONJURED, 2, 5)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    public void conjured_item_drops_quality_by_four_when_expires() throws Exception {
        Item[] items = {new Item(Constants.CONJURED, 0, 5)};
        inn = new GildedRose(items);

        inn.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

}
