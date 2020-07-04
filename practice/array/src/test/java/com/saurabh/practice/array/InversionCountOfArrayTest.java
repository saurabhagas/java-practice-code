package com.saurabh.practice.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InversionCountOfArrayTest {
  @Test
  public void testInversionCountOddArray() {
    InversionCountOfArray inversionCountOfArray = new InversionCountOfArray();
    int[] array = new int[]{2, 4, 1, 0, 5, 6};
    int count = inversionCountOfArray.getInversionCount(array);
    assertThat(count).isEqualTo(5);
  }

  @Test
  public void testInversionCountOddArrayWithRepeatedElements() {
    InversionCountOfArray inversionCountOfArray = new InversionCountOfArray();
    int[] array = new int[]{12, 3, 5, 6, 2, 12};
    int count = inversionCountOfArray.getInversionCount(array);
    assertThat(count).isEqualTo(7);
  }

  @Test
  public void testInversionCountSequentialArray() {
    InversionCountOfArray inversionCountOfArray = new InversionCountOfArray();
    int[] array = new int[]{1, 2, 3, 4, 5, 6};
    int count = inversionCountOfArray.getInversionCount(array);
    assertThat(count).isEqualTo(0);
  }

  @Test
  public void testEmptyArray() {
    InversionCountOfArray inversionCountOfArray = new InversionCountOfArray();
    int[] array = new int[]{};
    assertThatIllegalArgumentException().isThrownBy(() -> {
      inversionCountOfArray.getInversionCount(array);
    });
  }
}
