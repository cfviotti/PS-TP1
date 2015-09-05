package br.unb.cic.ps.test;

import org.junit.Test;

import br.unb.cic.ps.action.PrimeNumberUtils;
import junit.framework.TestCase;

/**
 * Classe PrimeNumberUtilsTest.
 */
public class PrimeNumberUtilsTest extends TestCase {

	/**
	 * Testa o m�todo isPrime.
	 */
	@Test
	public void testIsPrime() {
		/* Testando para um n�mero negativo. */
		boolean retornoRealNegativo = PrimeNumberUtils.isPrime(-1);
		assertFalse(retornoRealNegativo);
		
		/* Testando para zero. */
		boolean retornoRealZero = PrimeNumberUtils.isPrime(0);
		assertFalse(retornoRealZero);

		/* Testando para um. */
		boolean retornoRealUm = PrimeNumberUtils.isPrime(1);
		assertFalse(retornoRealUm);
		
		/* Testando para n�meros positivos. */
		boolean retornoRealPositivo = PrimeNumberUtils.isPrime(3);
		assertTrue(retornoRealPositivo);
	}
	
	/**
	 * Testa o m�todo nextPrime.
	 */
	@Test
	public void testNextPrime() {
		/* Testando para um n�mero negativo. */
		Integer retornoEsperadoNegativo = 2;
		Integer retornoRealNegativo = PrimeNumberUtils.nextPrime(-1);
		assertEquals(retornoEsperadoNegativo, retornoRealNegativo);
		
		/* Testando para zero. */
		Integer retornoEsperadoZero = 2;
		Integer retornoRealZero = PrimeNumberUtils.nextPrime(0);
		assertEquals(retornoEsperadoZero, retornoRealZero);

		/* Testando para n�meros positivos. */
		Integer retornoEsperadoPositivo = 11;
		Integer retornoRealPositivo = PrimeNumberUtils.nextPrime(7);
		assertEquals(retornoEsperadoPositivo, retornoRealPositivo);
	}

}
