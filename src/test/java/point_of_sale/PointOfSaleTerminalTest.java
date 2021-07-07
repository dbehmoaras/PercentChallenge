package point_of_sale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PointOfSaleTerminalTest {
	@Test
	public void testerOne() {
		System.out.println("*****TESTER ONE PRINT*****");
		assertEquals(7, 3+4, "***** 1. testerOne *****");
	}

	@Test
	public void testerTwo() {
		assertEquals(8, 3 + 5, "***** 2. testerTwo *****");
		System.out.println("*****TESTER TWO PRINT*****");
	}

	@Test
	public void testerThree() {
		System.out.println("*****TESTER THREE PRINT*****");
		assertEquals(9, 3 + 6, "***** 3. testerThree *****");
	}
}
