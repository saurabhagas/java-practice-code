package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RemoveAdjacentDuplicatesTest {
  @Test
  public void testRemoveAdjacentDuplicates() {
    RemoveAdjacentDuplicates removeDuplicates = new RemoveAdjacentDuplicates();
    String uniqueAdjacentAlphabetString = removeDuplicates.removeAdjacentDuplicates("geeksforgeek");
    assertThat(uniqueAdjacentAlphabetString).isEqualTo("gksforgk");
  }

  @Test
  public void testRemoveAdjacentDuplicates1() {
    RemoveAdjacentDuplicates removeDuplicates = new RemoveAdjacentDuplicates();
    String uniqueAdjacentAlphabetString = removeDuplicates.removeAdjacentDuplicates("mississipie");
    assertThat(uniqueAdjacentAlphabetString).isEqualTo("mpie");
  }
}
