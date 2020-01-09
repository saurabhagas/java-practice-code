package com.saurabh.interview.strings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _11_AtoITest {
  @Test
  public void testAtoI(){
    _11_AtoI atoi = new _11_AtoI();
    int i = atoi.getAtoI("23");
    assertThat(i).isEqualTo(23);
  }

  @Test
  public void testAtoIOneAlphabet(){
    _11_AtoI atoi = new _11_AtoI();
    int i = atoi.getAtoI("23a");
    assertThat(i).isEqualTo(-1);
  }

  @Test
  public void testAtoIAllAlphabets(){
    _11_AtoI atoi = new _11_AtoI();
    int i = atoi.getAtoI("abc");
    assertThat(i).isEqualTo(-1);
  }
}
