package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TexttestFixtureTest {

    private GildedRose inn;

    //might need to change to \n or \r based on your system
    private String lineBreak = "\r\n";

    private String expected = "OMGHAI!" + lineBreak +
            "-------- day 0 --------" + lineBreak +
            "name, sellIn, quality" + lineBreak +
            "+5 Dexterity Vest, 10, 20" + lineBreak +
            "Aged Brie, 2, 0" + lineBreak +
            "Elixir of the Mongoose, 5, 7" + lineBreak +
            "Sulfuras, Hand of Ragnaros, 0, 80" + lineBreak +
            "Sulfuras, Hand of Ragnaros, -1, 80" + lineBreak +
            "Backstage passes to a TAFKAL80ETC concert, 15, 20" + lineBreak +
            "Backstage passes to a TAFKAL80ETC concert, 10, 49" + lineBreak +
            "Backstage passes to a TAFKAL80ETC concert, 5, 49" + lineBreak +
            "Conjured Mana Cake, 3, 6" + lineBreak +
            lineBreak +
            "-------- day 1 --------" + lineBreak +
            "name, sellIn, quality" + lineBreak +
            "+5 Dexterity Vest, 9, 19" + lineBreak +
            "Aged Brie, 1, 1" + lineBreak +
            "Elixir of the Mongoose, 4, 6" + lineBreak +
            "Sulfuras, Hand of Ragnaros, 0, 80" + lineBreak +
            "Sulfuras, Hand of Ragnaros, -1, 80" + lineBreak +
            "Backstage passes to a TAFKAL80ETC concert, 14, 21" + lineBreak +
            "Backstage passes to a TAFKAL80ETC concert, 9, 50" + lineBreak +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50" + lineBreak +
            "Conjured Mana Cake, 2, 5" + lineBreak +
            lineBreak;

    @Test
    public void text_fixture() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream console = new PrintStream(output);

        console.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        inn = new GildedRose(items);

        int days = 2;

        for (int i = 0; i < days; i++) {
            console.println("-------- day " + i + " --------");
            console.println("name, sellIn, quality");
            for (Item item : items) {
                console.println(item);
            }
            console.println();
            inn.updateQuality();
        }

        assertEquals(expected, output.toString());
    }

}