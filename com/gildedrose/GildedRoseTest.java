package com.gildedrose;

import static org.junit.Assert.*;
import org.junit.*;

public class GildedRoseTest {

	Item[] items;
	GildedRose app;
	
	@Before
	public void loadingItemList() {
		items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80),
        		new Item("Aged Brie", 2, 0),
        		new Item("Elixir of the Mongoose", 5, 7),
        		new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
                new Item("Aged BrieSS", -5, 15),
                new Item("Aged Brie", -5, 15),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49),
                new Item("Testing", -1, 20),
                new Item("Conjured test", 10, 18),
                new Item("Conjured test 1", -2, 1)                
        };
        app = new GildedRose(items);
        app.updateQuality();
	}
	
	@Test
	public void sulfurasQualityTest() {
		assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
	}
	
	@Test
	public void agedBrieQualityTest() {
		assertEquals("Aged Brie", app.items[1].name);
        assertEquals(1, app.items[1].quality);
	}
	
	@Test
	public void elixirQualityTest() {
		assertEquals("Elixir of the Mongoose", app.items[2].name);
        assertEquals(6, app.items[2].quality);
	}
	
	@Test
	public void backstageQualityTest() {
		assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[3].name);
        assertEquals(21, app.items[3].quality);
        assertEquals(50, app.items[4].quality);
        assertEquals(50, app.items[5].quality);
        assertEquals(50, app.items[8].quality);
	}
	
	@Test
	public void qualityDegradeTwiceTest() {
		assertEquals(13, app.items[6].quality);
		assertEquals(18,items[9].quality);
	}
	
	@Test
	public void printInventoryTest() {
		assertTrue(items[4].toString() != null);
	}
	
    @Test
    public void conjuredQualityTest() {
        assertEquals(16,items[10].quality);
        assertEquals(0,items[11].quality); //Testing quality never goes below 0
    }   
}
