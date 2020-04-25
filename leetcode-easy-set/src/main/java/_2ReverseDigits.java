import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * Reverse an integer. If the reverse integer overflows, return 0.
 *
 * Link: https://leetcode.com/problems/reverse-integer/
 */
public class _2ReverseDigits {
  public int reverseUsingJava8(int x) {
    int rev = 0;
    while (x != 0) {
      int mod = x % 10;
      x = x / 10;
      try {
        int rev10 = Math.multiplyExact(rev, 10);
        rev = Math.addExact(rev10, mod);
      } catch (ArithmeticException e) {
        return 0;
      }
    }
    return rev;
  }

  public int reverseUsingCustomAddAndMultiplu(int x) {
    int rev = 0;
    while (x != 0) {
      int mod = x % 10;
      x = x / 10;
      try {
        int rev10 = Math.multiplyExact(rev, 10);
        rev = Math.addExact(rev10, mod);
      } catch (ArithmeticException e) {
        return 0;
      }
    }
    return rev;
  }

  public int reverseWithLeetcodeStrategy(int x) {
    int rev = 0;
    while (x != 0) {
      int mod = x % 10;
      x = x / 10;
      if (rev > MAX_VALUE/10 || (rev == MAX_VALUE / 10 && mod > 7)) return 0;
      if (rev < MIN_VALUE/10 || (rev == MIN_VALUE / 10 && mod < -8)) return 0;
      rev = rev * 10 + mod;
    }
    return rev;
  }
}
