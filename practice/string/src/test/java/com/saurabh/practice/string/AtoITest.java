package com.saurabh.practice.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtoITest {
  @Test
  public void testAtoI(){
    AtoI atoi = new AtoI();
    int i = atoi.getAtoI("23");
    assertThat(i).isEqualTo(23);
  }

  @Test
  public void testAtoIOneAlphabet(){
    AtoI atoi = new AtoI();
    int i = atoi.getAtoI("23a");
    assertThat(i).isEqualTo(-1);
  }

  @Test
  public void testAtoIAllAlphabets(){
    AtoI atoi = new AtoI();
    int i = atoi.getAtoI("abc");
    assertThat(i).isEqualTo(-1);
  }
}
