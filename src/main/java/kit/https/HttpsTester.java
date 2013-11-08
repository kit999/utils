/**
 * Ackermann function in Java.
 */

package kit.https;

import java.math.BigInteger;

/**
 * http://en.wikipedia.org/wiki/Ackerman_function
 */
public class HttpsTester {
	public static int a(int m, int n) {
		if ((m < 0) || (n < 0)) {
			throw new IllegalArgumentException();
		}
		if (m == 0) {
			return n + 1;
		}
		if (n == 0) {
			return a(m - 1, 1);
		}
		return a(m - 1, a(m, n - 1));
	}
	
	public static BigInteger a(BigInteger m, BigInteger n) {
		if ((m.compareTo(BigInteger.ZERO) < 0) || (n.compareTo(BigInteger.ZERO) < 0)) {
			throw new IllegalArgumentException();
		}
		if (m.equals(BigInteger.ZERO)) {
			return n.add(BigInteger.ONE);
		}
		if (n.equals(BigInteger.ZERO)) {
			return a(m.subtract(BigInteger.ONE), BigInteger.ONE);
		}
		return a(m.subtract(BigInteger.ONE), a(m, n.subtract(BigInteger.ONE)));
	}
}
