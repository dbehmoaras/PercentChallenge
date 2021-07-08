package pointofsale;

import java.math.BigDecimal;

public class mainPSale {
	public static void main(String[] args) {

		/* Declare array of testCases */
		String[] testCases = new String[] {
			"ABCDABA", 					// 13.25
			"CCCCCCC", 					// 6.00
			"ABCD",							// 7.25
			"",									// 0
			"AAABBBBBCCCCCCCD"	// 31.00
		};

		/* initialize the terminal */
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();

		for (int i = 0; i < testCases.length; i += 1){
			/* Scan the entire string, calculate the total, and
			clear the pickList in the terminal */
			terminal.scanAll(testCases[i]);
			BigDecimal totalPrice = terminal.calculateTotal();
			terminal.clearPickList();

			System.out.print("Pick List: ");
			System.out.println(testCases[i]);
			System.out.print("Total price: $");
			System.out.println(totalPrice);
			System.out.println("********************************");
		}



	}
};