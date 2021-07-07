package point_of_sale;

import org.json.simple.JSONArray; //may not need
import org.json.simple.JSONObject;
import org.json.simple.JSONParser;

import java.io.FileReader;
import java.util.Iterator;


/**
 * Reads price list from JSON file
 */

public class readPriceList {
	private static final String PRICELIST = "./../../../../priceList.xml";

	public static void main(String[] args){

		try {
			//parse the PRICELIST json
			Object parsedObj = parser.parse(new FileReader(PRICELIST));

			// convert JSON String to Object
			JSONObject jsonObject = (JSONObject) parsedObj;

			for (String key : jsonObject) {
				System.out.println(key);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}