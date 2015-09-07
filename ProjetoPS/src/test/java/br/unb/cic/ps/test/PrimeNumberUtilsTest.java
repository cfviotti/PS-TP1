package br.unb.cic.ps.test;

import org.junit.Test;

import br.unb.cic.ps.action.PrimeNumberUtils;
import junit.framework.TestCase;

/**
 * Classe PrimeNumberUtilsTest.
 */
public class PrimeNumberUtilsTest extends TestCase {

	/**
	 * Testa o método isPrime.
	 */
	@Test
	public void testIsPrime() {
		/* Testando para um número negativo. */
		boolean retornoRealNegativo = PrimeNumberUtils.isPrime(-1);
		assertFalse(retornoRealNegativo);
		
		/* Testando para zero. */
		boolean retornoRealZero = PrimeNumberUtils.isPrime(0);
		assertFalse(retornoRealZero);

		/* Testando para um. */
		boolean retornoRealUm = PrimeNumberUtils.isPrime(1);
		assertFalse(retornoRealUm);
		
		/* Testando para números positivos. */
		boolean retornoRealPositivo = PrimeNumberUtils.isPrime(3);
		assertTrue(retornoRealPositivo);
	}
	
	/**
	 * Testa o método nextPrime.
	 */
	@Test
	public void testNextPrime() {
		/* Testando para um número negativo. */
		Integer retornoEsperadoNegativo = 2;
		Integer retornoRealNegativo = PrimeNumberUtils.nextPrime(-1);
		assertEquals(retornoEsperadoNegativo, retornoRealNegativo);
		
		/* Testando para zero. */
		Integer retornoEsperadoZero = 2;
		Integer retornoRealZero = PrimeNumberUtils.nextPrime(0);
		assertEquals(retornoEsperadoZero, retornoRealZero);

		/* Testando para números positivos. */
		Integer retornoEsperadoPositivo = 11;
		Integer retornoRealPositivo = PrimeNumberUtils.nextPrime(7);
		assertEquals(retornoEsperadoPositivo, retornoRealPositivo);
	}

}
