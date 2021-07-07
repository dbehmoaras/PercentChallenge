package point_of_sale;

import java.math.BigDecimal;

public class mainPSale {
	public static void main(String[] args) {
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		terminal.scanAll("ABCD");

		BigDecimal totalPrice = terminal.calculateTotal();
		System.out.println("Total price:");
		System.out.println(totalPrice);

		// int termA = terminal.getQty("A");
		// int termB = terminal.getQty("B");
		// System.out.println("Terminal get qty");
		// System.out.println(termA);
		// System.out.println(termB);

		// double price = readPriceList.getPrice("A");
		// System.out.println(price);

		// int minQty = readPriceList.getVolumeQty("A");
		// System.out.println(minQty);
		// System.out.println(minQty*2);
	}
};