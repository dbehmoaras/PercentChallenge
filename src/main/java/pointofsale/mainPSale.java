package pointofsale;

import java.math.BigDecimal;

public class mainPSale {
	public static void main(String[] args) {
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		terminal.scanAll("ABCD");

		BigDecimal totalPrice = terminal.calculateTotal();
		System.out.println("Total price:");
		System.out.println(totalPrice);

	}
};