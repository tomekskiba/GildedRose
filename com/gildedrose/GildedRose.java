package com.gildedrose;

class GildedRose {
	Item[] items;

	public final static int MAX_QUALITY = 50;

	/**
	 * This method will initialize the list variable with the passed argument.
	 * @param items		This represents an array of items.
	 */
	public GildedRose(Item[] items) {
		this.items = items;
	}

	/**
	 * This method updates the quality of conjured items.
	 *
	 * @param item		This represents the item to be conjured and quality to be updated.
	 */
	private void updateQualityOfConjured(Item item ){
		if(item.sellIn < 0){
			item.quality = item.quality - 4;
		}else{
			item.quality = item.quality - 2;
		}

		if(item.quality < 0){
			item.quality = 0;
		}
	}


	/**
	 * Updates quality of items by delegating to item specific method.
	 */
	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (items[i].name.contains("Conjured")) {
				updateQualityOfConjured(items[i]);
			} else {
				updateQualityNotConj(items[i]);
			}
		}
	}


	/**
	 * This method updates the quality of non-conjured item.
	 *
	 * @param item 	This is the item whose quality is to be updated.
	 */
	private void updateQuality(Item item) {
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


	/**
	 * This method updates the quality of an item whose sell in date has passed (negative value).
	 * @param item		This is the item whose quality is to be updated.
	 */
	public void updateQualityBasedOnSellIn(Item item) {
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


	/**
	 * Updates the quality and sell in date of non-conjured items.
	 *
	 * @param item		This is the item whose quality and sell in date is to be updated.
	 */
	public void updateQualityNotConj(Item item) {
		updateQuality(item);

		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}

		updateQualityBasedOnSellIn(item);
	}
}
