# PercentChallenge

## Getting Started:
A package has already been provided. However, in the event certain dependencies are missing, please run the following command in the terminal:
```
mvn package
```
In order to run the test suite, run the following command in the terminal:
```
mvn test
```
The package can be run to the output of the test cases provided in the test sutie. To run the package from the entry point, run the following command in the terminal:
```
java -jar target/point-of-sale-0.1.0.jar
```

The following assumptions and design choices were made in order to complete the challenge:
- The logic of the volume discount price applies to multiples of the minimum required quantity. For example, if there are 4 units, that unit will take the normal price. Alternatively, if there are 6 units the discount will be applied for all 6 (2 * 3 units).
- The pricing data is stored in a JSON file that is parsed by the readPriceList.java API. The readPriceList API reads the JSON object and stores the data in a local cache that can then be accessed by getter methods built into the API without having to re-parse the JSON document every time a getter is invoked.
- The PointOfSaleTerminal scans one or all of the characters in the string provided by the test cases and stores the quantity of each character in a hash map.
- The PointOfSaleTerminal interfaces with readPriceList by invoking the priceList's getter methods when calculating the total cost of the order. The calculateTotal method iterates through the hash map and uses each key to retrieve pricing data from the JSON document to calculate the total. Additional calculations are performed to apply the volume discounts specified.
- The following dependencies were added:
	- JSON-simple - parse JSON files
	- JUnit - java testing library