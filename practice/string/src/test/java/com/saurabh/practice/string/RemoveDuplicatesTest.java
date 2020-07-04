package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesTest {
  @Test
  public void testRemoveDuplicatesNoSpaceString() {
    RemoveDuplicates removeDup = new RemoveDuplicates();
    String answer = removeDup.removeDuplicates("geeksforgeeks");
    assertThat(answer).isEqualTo("geksfor");
  }

  @Test
  public void testRemoveDuplicatesSpaceString() {
    RemoveDuplicates removeDup = new RemoveDuplicates();
    String answer = removeDup.removeDuplicates("geeks for geeks");
    assertThat(answer).isEqualTo("geks for");
  }

  @Test
  public void testRemoveDuplicatesNoDuplicates() {
    RemoveDuplicates removeDup = new RemoveDuplicates();
    String answer = removeDup.removeDuplicates("Hi!What's up?");
    assertThat(answer).isEqualTo("Hi!What's up?");
  }
}
