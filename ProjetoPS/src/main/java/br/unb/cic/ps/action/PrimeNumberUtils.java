package br.unb.cic.ps.action;

/**
 * Classe PrimeNumberUtils.
 */
public class PrimeNumberUtils {

	/**
	 * Checa se um n�mero � primo.
	 * 
	 * @param n�mero
	 *            o n�mero
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
	 * Busca o primeiro n�mero primo ap�s o n�mero passado como par�metro.
	 * 
	 * @param n�mero
	 *            o n�mero
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
