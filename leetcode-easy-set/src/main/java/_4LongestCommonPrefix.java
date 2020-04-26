public class _4LongestCommonPrefix {
  public String longestCommonPrefix(String... strs) {
    Character currentChar = null;
    int match = 1;
    StringBuilder longestCommonPrefix = new StringBuilder();
    for (int j = 0; ; j++) {
      for (String str : strs) {
        if (j >= str.length()) {
          return longestCommonPrefix.toString();
        }

        if (currentChar == null) {
          currentChar = str.charAt(j);
        } else {
          if (str.charAt(j) != currentChar) {
            return longestCommonPrefix.toString();
          } else {
            match++;
          }
        }
      }

      if (match == strs.length ) {
        longestCommonPrefix.append(currentChar);
      }
      // Reset currentChar at the end of the loop
      currentChar = null;
      match = 1;
    }
  }
}
