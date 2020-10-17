import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculateTester3_0 {
	
	private final Random random = new Random();

	@Test
	void testExponent() {
		double in1, out1;
		int in2;
		for (int i = 0; i < 50; i++) {
			in1 = random.nextDouble() * 100 - 50;
			in2 = random.nextInt(10);
			out1 = Math.pow(in1, in2);
			if (in1 == in2 && in1 == 0) {
				System.out.println("meow");
				continue;
			}
			
			assertEquals((int) out1,(int) Calculate.exponent(in1, in2));

		}
		assertEquals(1, Calculate.exponent(random.nextInt(10), 0));
	}
	
	@Test
	void testExpException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Calculate.exponent(0, 0);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Calculate.exponent(5, random.nextInt(40) - 41);
		});
		
	}
	
	@Test
	void testFactorial() {
		for (int i = 0; i < 10; i++) {
			assertEquals(LongStream.rangeClosed(1, i).reduce(1, (long x, long y) -> x * y), Calculate.factorial(i));
		}
		assertEquals(1, Calculate.factorial(0));
	}
	
	@Test
	void testFactorialException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Calculate.factorial(random.nextInt(40) - 41);
		});
	}
	
	@Test
	void testIsPrime() {
		for (int i = -5; i <= 100; i++) {
			int number = i;
			assertEquals(i > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(i)).noneMatch(n -> (number % n == 0)), Calculate.isPrime(i));
		}
	}
	
	@Test
	void testGCF() {
		int in1, in2, out1;
		
		for (int i = 1; i < 100; i++) {
			in1 = random.nextInt(20000) - 10000;
			in2 = random.nextInt(20000) - 10000;
			out1 = gcd(in1, in2);
			assertEquals(out1, Calculate.gcf(in1, in2));
		}
		assertEquals(105, Calculate.gcf(0, 105));
		assertEquals(1, Calculate.gcf(1, -24));
	}
	
	private static int gcd(int a, int b) {
	    BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
	@Test
	void testSqrt() {
		double in1, out1;
		for (int i = 1; i < 100; i++) {
			in1 = random.nextInt(10000);
			out1 = Math.sqrt(in1);
			assertEquals(String.format("%.2f", out1), String.format("%.2f", Calculate.sqrt(in1)));
		}
		assertEquals(0.0, Calculate.sqrt(0));
		assertEquals(1.0, Calculate.sqrt(1));
	}
	
	@Test
	void testSqrtExcep() {
		assertThrows(IllegalArgumentException.class, () -> {
			Calculate.sqrt(random.nextInt(40) - 41);
		});
	}
	
	
}
