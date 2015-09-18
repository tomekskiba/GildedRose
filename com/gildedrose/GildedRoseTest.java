package com.gildedrose;

import static org.junit.Assert.*;
import org.junit.*;

public class GildedRoseTest {

	@Test
	public void sulfurasQualityTest() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0,
				80) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
		assertEquals(80, app.items[0].quality);
	}

	@Test
	public void agedBrieQualityTest() {

		Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(1, app.items[0].quality);
	}
	
	
	@Test
	public void agedBrieQualityPastSellInTest() {
		Item[] items = new Item[] { new Item("Aged Brie", -10, 0) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(2, app.items[0].quality);
	}
	
	

	@Test
	public void elixirQualityTest() {

		Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals("Elixir of the Mongoose", app.items[0].name);
		assertEquals(6, app.items[0].quality);
	}

	@Test
	public void backstageQualityTest() {

		Item[] items = new Item[] {
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49), };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[3].name);
		assertEquals(21, app.items[0].quality);
		assertEquals(50, app.items[1].quality);
		assertEquals(50, app.items[2].quality);
		assertEquals(50, app.items[3].quality);
	}

	@Test
	public void qualityDegradeTwiceTest() {

		Item[] items = new Item[] { new Item("Aged BrieSS", -5, 15),
				new Item("Testing", -1, 20) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(13, app.items[0].quality);
		assertEquals(18, items[1].quality);
	}

	@Test
	public void printInventoryTest() {

		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 10, 48), };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertTrue(items[0].toString() != null);
	}

	@Test
	public void conjuredQualityTest() {

		Item[] items = new Item[] { new Item("Conjured test", 10, 18),
				new Item("Conjured test 1", -2, 1) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertEquals(16, items[0].quality);
		assertEquals(0, items[1].quality); // Testing quality never goes below 0
	}
}
