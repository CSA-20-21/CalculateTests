/*
 * Calculate.java Part 2 library checker
 * 
 * @author burturt
 * @version 2.1
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculateTester2_1 {

	@ParameterizedTest
	@CsvFileSource(resources = "/zDivisibleValues.csv")
	void testIsDivisibleBy(int in1, int in2, boolean out1) {
		assertEquals(out1, Calculate.isDivisibleBy(in1, in2));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zAbsValue.csv")
	void testAbsValue(double in1, double out1) {
		assertEquals(String.format("%.4f",out1), String.format("%.4f", Calculate.absValue(in1)));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zMinMax.csv")
	void testMax(double in1, double in2, double out1, double out2) {
		assertEquals(String.format("%.4f",out1), String.format("%.4f",Calculate.max(in1, in2)));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zMinMax.csv")
	void testMin(double in1, double in2, double out1, double out2) {
		int iin1 = (int) Math.round(in1);
		int iin2 = (int) Math.round(in2);
		int iout2 = (int) Math.round(out2);
		assertEquals(iout2, Calculate.min(iin1, iin2));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zRound2.csv")
	void testRound2t(double in1, double out1) {
		assertEquals(out1, Calculate.round2(in1));
	}

}