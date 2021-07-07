package point_of_sale;

import java.lang.ref.Cleaner;

public class mainPSale {
	public static void main(String[] args) {
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		System.out.println(terminal.sayHello());
		double price = readPriceList.getPrice("A");
		System.out.println(price);
	}
}