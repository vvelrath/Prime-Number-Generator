package primegen.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import primegen.PrimeNumberGenerator;
import primegen.PrimeNumberGeneratorImpl;

public class PrimeNumberGeneratorImplTest {

	private List<Integer> expected;
	private List<Integer> emptyList;
	
	PrimeNumberGenerator primegen = null;
	
	@Before
	public void setUp() throws Exception {
		
		primegen = new PrimeNumberGeneratorImpl();
		
		emptyList = new ArrayList<Integer>();
		expected = new ArrayList<Integer>();
		
		expected.add(7901);
		expected.add(7907);
		expected.add(7919);
	}

	@Test
	public void testGenerate() {
		assertEquals(expected, primegen.generate(7900, 7920));
		assertEquals(expected, primegen.generate(7920, 7900));
	}
	
	@Test
	public void testGenerateForEmptyList() {
		assertEquals(emptyList, primegen.generate(-3, 1));
		assertEquals(emptyList, primegen.generate(602, 606));
	}

	@Test
	public void testIsPrimeForNegative() {
		assertEquals(false, primegen.isPrime(-5));
	}

	@Test
	public void testIsPrimeFor0and1() {
		assertEquals(false, primegen.isPrime(0));
		assertEquals(false, primegen.isPrime(1));
	}

	@Test
	public void testIsPrimeForNonPrime() {
		assertEquals(false, primegen.isPrime(7902));
		assertEquals(false, primegen.isPrime(142883));
	}

	@Test
	public void testIsPrimeForPrimeNos() {
		assertEquals(true, primegen.isPrime(2));
		assertEquals(true, primegen.isPrime(131));
	}
}
