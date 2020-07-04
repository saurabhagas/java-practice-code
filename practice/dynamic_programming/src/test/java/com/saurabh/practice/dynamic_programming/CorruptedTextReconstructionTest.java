package com.saurabh.practice.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CorruptedTextReconstructionTest {
  @Test
  public void testWithInput1() {
    String text = "itwasthebestoftimes";
    CorruptedTextReconstruction obj = new CorruptedTextReconstruction(text);
    assertTrue(obj.isReconstructionPossible());
  }

  @Test
  public void testWithInput2() {
    String text = "itwasthenestoftimes";
    CorruptedTextReconstruction obj = new CorruptedTextReconstruction(text);
    assertFalse(obj.isReconstructionPossible());
  }

  @Test
  public void testWithInput3() {
    String text = "blah";
    CorruptedTextReconstruction obj = new CorruptedTextReconstruction(text);
    assertFalse(obj.isReconstructionPossible());
  }
}