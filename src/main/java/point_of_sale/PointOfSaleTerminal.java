package point_of_sale;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class PointOfSaleTerminal {

	/* stores the total pickList scanned through the terminal */
	public final HashMap<String, Integer> pickList = new HashMap<>();

	/**
	 * Iterates through the keys of the hashMap and stores the running
	 * total value of the quantity of each item after multiplying it by
	 * the item's corresponding quantity. Uses modular arithmetic to
	 * apply the volume discounts.
	 * @return BigDecimal: value of the total price of the items in the pickList
	 */
	public BigDecimal calculateTotal() {
		double totalPrice = 0.00;

		/* pull the keys out of the pickList into an iterable cart */
		Set<String> itemKeys = pickList.keySet();
		Iterator<String> cart = itemKeys.iterator();


		/**
		 * Iterate through the keys in the cart. Store the item key as a string and
		 * and its corresponding quantity as an int in order to check the pickList
		 * for items that meet the requirements for a volume discounted price.
		 */
		/* */
		while (cart.hasNext()) {
			Object currentItem = cart.next();
			String itemStr = currentItem.toString();
			int currentQty = pickList.get(currentItem);


			/**
			 * If the item offers a volume discount and the currentQty exceeds the
			 * minimum quantity, use the volume price to calculate the volume discounted
			 * price and modular arithmetic to calculate the cost of the remaining qty.
			 * Otherwise just multiply the currentQty by the item's price.
			 */
			if (getVolumeQty(itemStr) > 0 && currentQty >= getVolumeQty(itemStr)) {
				totalPrice += (currentQty / getVolumeQty(itemStr)) * getVolumePrice(itemStr);
				totalPrice += currentQty % getVolumeQty(itemStr) * getPrice(itemStr);
			} else {
				totalPrice += currentQty * getPrice(itemStr);
			}


		}
		return BigDecimal.valueOf(totalPrice);
	}

	/**
	 * Scans the entire items string, checking if the item exists in
	 * the pickList. If it exists, its quantity value is incremented by 1.
	 * If it does not exist, the item is added with a quantity of one.
	 *
	 * @param items: String, the entire customer order
	 */
	public void scanAll(String items) {
		for (int i = 0; i < items.length(); i += 1) {
			if (pickList.containsKey(items.substring(i,i+1))) {
				pickList.replace(items.substring(i,i+1), pickList.get(items.substring(i,i+1)) + 1);
			} else {
				pickList.put(items.substring(i,i+1), 1);
			}
		}
	}

	/**
	 * Stores one item in the pickList hashmap. If the item exists in
	 * the pickList, its quantity value is incremented by 1.
	 *
	 * @param item: String, single item being scanned into the purchaseOrder
	 *
	 */
	public void scanOne(String item) {
		if (pickList.containsKey(item)) {
			pickList.replace(item, pickList.get(item) + 1);
		} else {
			pickList.put(item, 1);
		}
	}

	/**
	 *
	 * @param item
	 * @return double: the price of the item stored in
	 * the picklist by calling the readPriceList API
	 */
	public double getPrice(String item) {
		return readPriceList.getPrice(item);
	}

	/**
	 *
	 * @param item
	 * @return double: returns the price for a volume discount by calling the readPriceList API
	 */
	public double getVolumePrice(String item) {
		return readPriceList.getVolumePrice(item);
	}

	/**
	 *
	 * @param item
	 * @return long: returns the minimum qty for a volume discount by calling the readPriceList API
	 */
	public int getVolumeQty(String item) {
		return readPriceList.getVolumeQty(item);
	}
}
