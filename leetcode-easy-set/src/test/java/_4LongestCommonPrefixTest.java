import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _4LongestCommonPrefixTest {
  private static final _4LongestCommonPrefix OBJ = new _4LongestCommonPrefix();

  @Test
  public void testNoCommonPrefix() {
    String lcf = OBJ.longestCommonPrefix("dog", "racecar", "car");
    assertEquals("", lcf);
  }

  @Test
  public void testNoCommonPrefix_emptyStrings() {
    String lcf = OBJ.longestCommonPrefix("", "", "", "");
    assertEquals("", lcf);
  }

  @Test
  public void testCommonPrefix_sameStrings() {
    String lcf = OBJ.longestCommonPrefix("dog", "dog", "dog", "dog");
    assertEquals("dog", lcf);
  }

  @Test
  public void testCommonPrefix_oneStringFull() {
    String lcf = OBJ.longestCommonPrefix("dogger", "doggist", "dog", "doggy");
    assertEquals("dog", lcf);
  }

  @Test
  public void testCommonPrefix_subsStringSame() {
    String lcf = OBJ.longestCommonPrefix("dogger", "doggist", "dogma", "doggy");
    assertEquals("dog", lcf);
  }
}