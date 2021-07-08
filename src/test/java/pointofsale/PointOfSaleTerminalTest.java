package pointofsale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;
import java.math.BigDecimal;


public class PointOfSaleTerminalTest {

	private static PointOfSaleTerminal testTerminal;
	private static Logger logger;

	@BeforeAll
	public static void init () {
		logger = Logger.getLogger(PointOfSaleTerminalTest.class.getName());
		logger.info("***** Initializing testTerminal *****\n");
		testTerminal = new PointOfSaleTerminal();
	}

	@AfterEach
	void teardown() {
		logger.info("***** Clearing pickList *****\n");
		testTerminal.pickList.clear();
	}

	@Test
	public void testCaseOne() {
		testTerminal.scanAll("ABCDABA");
		BigDecimal testTotalPrice = testTerminal.calculateTotal();
		assertEquals(testTotalPrice, BigDecimal.valueOf(13.25), "***** Test Case 1: \"ABCDABA\" FAILED *****\n");
		logger.info("***** Test Case 1: \"ABCDABA\" PASSED *****\n");
	}

	@Test
	public void testCaseTwo() {
		testTerminal.scanAll("CCCCCCC");
		BigDecimal testTotalPrice = testTerminal.calculateTotal();
		assertEquals(testTotalPrice, BigDecimal.valueOf(6.00), "***** Test Case 2: \"CCCCCCC\" FAILED *****\n");
		logger.info("***** Test Case 2: \"CCCCCCC\" PASSED *****\n");
	}

	@Test
	public void testCaseThree() {
		testTerminal.scanAll("ABCD");
		BigDecimal testTotalPrice = testTerminal.calculateTotal();
		assertEquals(testTotalPrice, BigDecimal.valueOf(7.25), "***** Test Case 3: \"ABCD\" FAILED *****\n");
		logger.info("***** Test Case 3: \"ABCD\" PASSED *****\n");
	}

	@Test
	public void testCaseFour() {
		testTerminal.scanAll("");
		BigDecimal testTotalPrice = testTerminal.calculateTotal();
		assertEquals(testTotalPrice, BigDecimal.valueOf(0.00), "***** Test Case 4: \"\" FAILED *****\n");
		logger.info("***** Test Case 4: \"\" PASSED *****\n");
	}

	@Test
	public void testCaseFive() {
		testTerminal.scanAll("AAABBBBBCCCCCCCD");
		BigDecimal testTotalPrice = testTerminal.calculateTotal();
		assertEquals(testTotalPrice, BigDecimal.valueOf(31.00), "***** Test Case 3: \"ABCD\" FAILED *****\n");
		logger.info("***** Test Case 3: \"ABCD\" PASSED *****\n");
	}
}
