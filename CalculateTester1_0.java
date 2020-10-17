/*
 * Calculate.java Part 0-1 library checker
 * 
 * @author burturt
 * @version 1.0
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculateTester1_0 {
	
	@Test
	void testToImproperFrac() {
		assertEquals(Calculate.toImproperFrac(5, 2, 3), "17/3");
		assertEquals(Calculate.toImproperFrac(-2, 5, 6), "-17/6");
		assertEquals(Calculate.toImproperFrac(0, 5, 2), "5/2");
		assertEquals(Calculate.toImproperFrac(4, 0, 1), "4/1");
		assertEquals(Calculate.toImproperFrac(3, 1, 2), "7/2");
		assertEquals(Calculate.toImproperFrac(0, -8, 3), "-8/3");
		assertEquals(Calculate.toImproperFrac(5, 3, 0),"NaN");
	}
	
	@Test
	void testToMixedNum() {
		assertEquals(Calculate.toMixedNum(17, 3), "5_2/3");
		assertEquals(Calculate.toMixedNum(-17, 6), "-2_5/6");
		assertEquals(Calculate.toMixedNum(5,2), "2_1/2");
		assertEquals(Calculate.toMixedNum(4,1), "4");
		assertEquals(Calculate.toMixedNum(-1, 2), "-1/2");
	}
	
	@Test
	void testFOIL() {
		assertEquals(Calculate.foil(2, 3, 6, -7, "n"), "12n^2 + 4n - 21");
		assertEquals(Calculate.foil(4, 2, 5, 6, "h"), "20h^2 + 34h + 12");
		assertEquals(Calculate.foil(-2, 1, 8, 12, "deltaX"), "-16deltaX^2 - 16deltaX + 12");
		assertEquals(Calculate.foil(0, 1, 4, 0, "X"), "4X");
		assertEquals(Calculate.foil(0, 1, -4, 0, "X"), "-4X");
		assertEquals(Calculate.foil(-2, 5, 0, 3, "z"), "-6z + 15");
		assertEquals(Calculate.foil(-3, 0, -6, 4, "c"), "18c^2 - 12c");
		assertEquals(Calculate.foil(4, 0, 5, 0, "∆"), "20∆^2");
		assertEquals(Calculate.foil(-4, 0, 5, 0, "∆"), "-20∆^2");
		assertEquals(Calculate.foil(0, 5, 0, 8, "t"), "40");
		assertEquals(Calculate.foil(0, 5, 0, -8, "t"), "-40");
	}
	
	@Test
	void testSquare() {
	    Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int randomInt = random.nextInt(5000) - 2500;
			assertEquals(Calculate.square(randomInt), randomInt * randomInt);
		}
	}
	
	@Test
	void testCube() {
	    Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int randomInt = random.nextInt(5000) - 2500;
			assertEquals(Calculate.cube(randomInt), randomInt * randomInt * randomInt);
		}
	}
	
	// CSV file: 5 columns, 3 of random numbers, 4th first 2 avg, 5th first 3 avg
	@ParameterizedTest
	@CsvFileSource(resources = "/avgValues.csv")
	void testAvg2FromCSV(double num1, double num2, double num3, double out1, double out2) {
		assertEquals(String.format("%.2f", Calculate.average(num1, num2)),
				String.format("%.2f", out1));
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/avgValues.csv")
	void testAvg3FromCSV(double num1, double num2, double num3, double out1, double out2) {
		assertEquals(String.format("%.2f", Calculate.average(num1, num2, num3)),
				String.format("%.2f", out2));
	}
	
	// CSV: 2 columns, first column random numbers, second convert to degrees
	@ParameterizedTest
	@CsvFileSource(resources = "/D-GValues.csv")
	void testR2DFromCSV(double degrees, double radians) {
		assertEquals(String.format("%.2f", Calculate.toDegrees(radians)),
				String.format("%.2f", degrees));
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/D-GValues.csv")
	void testD2RFromCSV(double degrees, double radians) {
		assertEquals(String.format("%.2f", Calculate.toRadians(degrees)),
				String.format("%.2f", radians));
	}
	
	@Test
	void testDiscriminent() {
		assertEquals(Calculate.discriminant(2.0, 3.0, 4.0), -23.0);
		assertEquals(String.format("%.4f",Calculate.discriminant(-3.2, 3.6, -23.0)), String.format("%.4f",-281.44));
		assertEquals(String.format("%.4f",Calculate.discriminant(-3.2, 0, 5.1)), String.format("%.4f",65.28));
		assertEquals(String.format("%.4f",Calculate.discriminant(0, 4.1, -3.4)), String.format("%.4f",16.81));
	}
	
}
