package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _8_RemoveDuplicatesTest {
  @Test
  public void testRemoveDuplicatesNoSpaceString() {
    _8_RemoveDuplicates removeDup = new _8_RemoveDuplicates();
    String answer = removeDup.removeDuplicates("geeksforgeeks");
    assertThat(answer).isEqualTo("geksfor");
  }

  @Test
  public void testRemoveDuplicatesSpaceString() {
    _8_RemoveDuplicates removeDup = new _8_RemoveDuplicates();
    String answer = removeDup.removeDuplicates("geeks for geeks");
    assertThat(answer).isEqualTo("geks for");
  }

  @Test
  public void testRemoveDuplicatesNoDuplicates() {
    _8_RemoveDuplicates removeDup = new _8_RemoveDuplicates();
    String answer = removeDup.removeDuplicates("Hi!What's up?");
    assertThat(answer).isEqualTo("Hi!What's up?");
  }
}
