package point_of_sale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class pointOfSaleTest {
	@Test
	@DisplayName("*****TESTER ONE*****")
	public void testerOne() {
		assertEquals(7, 3+4, "***** 1. testerOne *****");
	}

	@Test
	public void testerTwo() {
		assertEquals(8, 3 + 5, "***** 2. testerTwo *****");
	}

	@Test
	public void testerThree() {
		assertEquals(9, 3 + 6, "***** 3. testerThree *****");
	}
}
