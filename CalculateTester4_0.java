/*
 * Calculate.java Part 0-1 library checker
 * 
 * @author burturt
 * @version 4.0
 */
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculateTester4_0 {

	@Test
	void testIsDivisibleException() {

		assertThrows(IllegalArgumentException.class, () -> {
			Calculate.isDivisibleBy((int) Math.random() * 100, 0);
		});
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/zQuad.csv")
	void testToMixedNum(int in1, int in2, int in3, String out1) {
		assertEquals(out1, Calculate.quadForm(in1, in2, in3));
	}

}
