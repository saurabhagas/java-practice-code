package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class _4_RemoveAdjacentDuplicatesTest {
  @Test
  public void testRemoveAdjacentDuplicates() {
    _4_RemoveAdjacentDuplicates removeDuplicates = new _4_RemoveAdjacentDuplicates();
    String uniqueAdjacentAlphabetString = removeDuplicates.removeAdjacentDuplicates("geeksforgeek");
    assertThat(uniqueAdjacentAlphabetString).isEqualTo("gksforgk");
  }

  @Test
  public void testRemoveAdjacentDuplicates1() {
    _4_RemoveAdjacentDuplicates removeDuplicates = new _4_RemoveAdjacentDuplicates();
    String uniqueAdjacentAlphabetString = removeDuplicates.removeAdjacentDuplicates("mississipie");
    assertThat(uniqueAdjacentAlphabetString).isEqualTo("mpie");
  }
}
