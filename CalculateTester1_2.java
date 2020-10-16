/*
 * Calculate.java Part 0-1 library checker
 * 
 * @author burturt (A M)
 * @version 1.2
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculateTester1_2 {
	
	private final Random random = new Random();
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zToImproperFracValues.csv")
	void testToImproperFrac(int in1, int in2, int in3, String out1) {
		assertEquals(Calculate.toImproperFrac(in1, in2, in3), out1);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zToMixedNumValues.csv")
	void testToMixedNum(int in1, int in2, String out1) {
		assertEquals(Calculate.toMixedNum(in1, in2), out1);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zFOILValues.csv")
	void testFOIL(int in1, int in2, int in3, int in4, String in5, String out1) {
		assertEquals(Calculate.foil(in1, in2, in3, in4, in5), out1);
	}
	
	@Test
	void testSquare() {
		for (int i = 0; i < 50; i++) {
			int randomInt = random.nextInt(5000) - 2500;
			assertEquals(Calculate.square(randomInt), Math.pow(randomInt, 2));
		}
	}
	
	@Test
	void testCube() {
		for (int i = 0; i < 50; i++) {
			int randomInt = random.nextInt(1000) - 500;
			assertEquals(Calculate.cube(randomInt), Math.pow(randomInt, 3));
		}
	}
	
	// CSV file: 5 columns, 3 of random numbers, 4th first 2 avg, 5th first 3 avg
	@ParameterizedTest
	@CsvFileSource(resources = "/zAvgValues.csv")
	void testAvg2FromCSV(double num1, double num2, double num3, double out1, double out2) {
		assertEquals(String.format("%.2f", Calculate.average(num1, num2)),
				String.format("%.2f", out1));
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/zavgValues.csv")
	void testAvg3FromCSV(double num1, double num2, double num3, double out1, double out2) {
		assertEquals(String.format("%.2f", Calculate.average(num1, num2, num3)),
				String.format("%.2f", out2));
	}
	
	// CSV: 2 columns, first column random numbers, second convert to degrees
	@ParameterizedTest
	@CsvFileSource(resources = "/zD-GValues.csv")
	void testR2DFromCSV(double degrees, double radians) {
		assertEquals(String.format("%.2f", Calculate.toDegrees(radians)),
				String.format("%.2f", degrees));
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/zD-GValues.csv")
	void testD2RFromCSV(double degrees, double radians) {
		assertEquals(String.format("%.2f", Calculate.toRadians(degrees)),
				String.format("%.2f", radians));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zDiscriminentValues.csv")
	void testDiscriminent(double in1, double in2, double in3, double out1) {
		assertEquals(String.format("%.4f",Calculate.discriminant(in1, in2, in3)), String.format("%.4f",out1));
	}
	
}
