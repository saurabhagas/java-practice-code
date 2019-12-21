package com.saurabh.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _8_EquilibriumPointInArrayTest {
  @Test
  public void trivialArray() {
    _8_EquilibriumPointInArray obj = new _8_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void smallArrayWithNoEquilibrium() {
    _8_EquilibriumPointInArray obj = new _8_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2, 3);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void mediumArrayWithNoEquilibrium() {
    _8_EquilibriumPointInArray obj = new _8_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2, 3, 4, 5, 6);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void arrayWithEquilibrium() {
    _8_EquilibriumPointInArray obj = new _8_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 7, 3, 6, 5, 6);
    assertEquals(3, equilibrium);
  }
}