package point_of_sale;

import org.json.simple.JSONArray; //may not need
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
// import java.io.File;
import java.util.Iterator;


/**
 * Reads price list from JSON file
 */

public class readPriceList {
	private static final String PRICELIST = "priceList.json";
	private static final JSONParser parser = new JSONParser();
	private static final JSONObject priceList = storeJSON();


	/**
	 *
	 * @return reads the priceList.json file and stores the data in a local cache so that it can be used by the readPriceList class's methods
	 */
	private static JSONObject storeJSON () {
		try {
			/* parse the PRICELIST json */
			Object parsedObj = parser.parse(new FileReader(PRICELIST));

			/* convert JSON String to JSON Object and access the price double nested in the */
			JSONObject jsonObject = (JSONObject) parsedObj;

			return jsonObject;
		} catch (Exception err) {
			err.printStackTrace();
			return null;
		}

	}

	/**
	 *
	 * @param item: String that represents which item to inspect in the JSON file
	 * @return double: value of the item's price
	 */
	public static double getPrice (String item){

		/* access the price double nested in the priceObj */
		JSONObject priceObj = (JSONObject) priceList.get(item);
		double price = (double) priceObj.get("price");

		return price;
	}

	/**
	 *
	 * @param item: String that represents which item to inspect in the JSON file
	 * @return long: minimum quantity required for a volume deal
	 */
	public static long getVolumeQty (String item) {
		/* access the volume nested in the priceObj */
		JSONObject priceObj = (JSONObject) priceList.get(item);
		JSONArray volume = (JSONArray) priceObj.get("volume");

		long qty = (long) volume.get(0);
		return qty;
	}

	/**
	 *
	 * @param item: String that represents which item to inspect in the JSON file
	 * @return double: value of the item's price when the minimum quantity for a volume discount is reached
	 */
	public static double getVolumePrice(String item) {
		/* access the volume nested in the priceObj */
		JSONObject priceObj = (JSONObject) priceList.get(item);
		JSONArray volume = (JSONArray) priceObj.get("volume");

		double price = (double) volume.get(1);
		return price;
	}
}