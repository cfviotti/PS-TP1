package br.unb.cic.ps.action;

/**
 * Classe PrimeNumberUtils.
 */
public class PrimeNumberUtils {

	/**
	 * Checa se um número é primo.
	 * 
	 * @param número
	 *            o número
	 * @return um boolean
	 */
	public static boolean isPrime(Integer numero) {
		if (numero == null) {
			return false;
		}
		int numeroPrimitivo = numero.intValue();
		if (numeroPrimitivo <= 1) {
			return false;
		} else {
			for (int i = 2; i <= numeroPrimitivo; i++) {
				if (numeroPrimitivo % i == 0) {
					if (i != numeroPrimitivo) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Busca o primeiro número primo após o número passado como parâmetro.
	 * 
	 * @param número
	 *            o número
	 * @return um objeto do tipo Integer
	 */
	public static Integer nextPrime(Integer numero) {
		while (true) {
			if (isPrime(++numero)) {
				return numero;
			}
		}
	}
	
}
