import java.util.HashMap;
import java.util.Map;

/**
 * Convert Roman numerals to Arabic.
 * Link: https://leetcode.com/problems/roman-to-integer/
 */
public class _3RomanToArabic {
  private static final Map<Character, Integer> charToValue = new HashMap<>();
  private static final Map<String, Integer> specialStringToValue = new HashMap<>();

  static {
    charToValue.put('I', 1);
    charToValue.put('V', 5);
    charToValue.put('X', 10);
    charToValue.put('L', 50);
    charToValue.put('C', 100);
    charToValue.put('D', 500);
    charToValue.put('M', 1000);

    specialStringToValue.put("IV", 4);
    specialStringToValue.put("IX", 9);
    specialStringToValue.put("XL", 40);
    specialStringToValue.put("XC", 90);
    specialStringToValue.put("CD", 400);
    specialStringToValue.put("CM", 900);
  }

  public int romanToArabic(String s) {
    char[] chars = s.toCharArray();
    int arabic = 0;
    for (int i = 0; i < chars.length; i++) {
      String specialString = (i + 2) <= chars.length ? s.substring(i, i + 2) : null;
      if (specialStringToValue.containsKey(specialString)) {
        arabic += specialStringToValue.get(specialString);
        i++;
      } else {
        arabic += charToValue.get(chars[i]);
      }
    }
    return arabic;
  }
}
