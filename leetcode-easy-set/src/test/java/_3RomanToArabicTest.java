import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _3RomanToArabicTest {
  private final _3RomanToArabic obj = new _3RomanToArabic();

  @Test
  public void testAllIs() {
    assertEquals(3, obj.romanToArabic("III"));
  }

  @Test
  public void testIsWithV() {
    assertEquals(4, obj.romanToArabic("IV"));
  }

  @Test
  public void testIsWithX() {
    assertEquals(9, obj.romanToArabic("IX"));
  }

  @Test
  public void testLWithVAndIs() {
    assertEquals(58, obj.romanToArabic("LVIII"));
  }

  @Test
  public void testComplex() {
    assertEquals(1994, obj.romanToArabic("MCMXCIV"));
  }
}