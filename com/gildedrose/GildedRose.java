package com.gildedrose;

class GildedRose {
	Item[] items;

	public final static String CONJURED = "Conjured";
	public final static int MAX_QUALITY = 50;
	
	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQualityOfConjured(Item item ){
		if(item.sellIn < 0){
			item.quality = item.quality - 4;
		}else{
			item.quality = item.quality - 2;
		}
		
		if(item.quality < 0){
			item.quality = 0;
		}

		
	}
	
	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			if (items[i].name.contains("Conjured")) {
				updateQualityOfConjured(items[i]);				
			} else {
				updateQualityNotConj(items[i]);
			}
		}
	}
	
	public void updateQuality(Item item) {
		if (!item.name.equals("Aged Brie")
				&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

			if (item.quality > 0) {
				if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
					item.quality = item.quality - 1;
				}
			}
		} else {
			if (item.quality < 50) {

				item.quality = item.quality + 1;
				
				if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				 	if (item.sellIn < 11 && item.quality < 50) {
				 		item.quality = item.quality + 1;
				 	}

				 	if (item.sellIn < 6 && item.quality < 50) {
				 		item.quality = item.quality + 1;
				 	}
				}
			}
		}

	}
	
	
	public void updateSellIn(Item item) {
		if (item.sellIn < 0) {
			if (!item.name.equals("Aged Brie")) {
				if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (item.quality > 0) {
						if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
							item.quality = item.quality - 1;
						}
					}
				} else {
					item.quality = item.quality - item.quality;
				}
			} else {
				if (item.quality < 50) {
					item.quality = item.quality + 1;
				}
			}
		}
	}
	
	
	public void updateQualityNotConj(Item item) {
		updateQuality(item);
		

		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}
		
		updateSellIn(item);


	}
}
