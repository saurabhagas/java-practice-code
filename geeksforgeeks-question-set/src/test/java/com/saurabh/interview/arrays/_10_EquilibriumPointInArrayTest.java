package com.saurabh.interview.arrays;

import com.saurabh.interview.arrays._10_EquilibriumPointInArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _10_EquilibriumPointInArrayTest {
  @Test
  public void trivialArray() {
    _10_EquilibriumPointInArray obj = new _10_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void smallArrayWithNoEquilibrium() {
    _10_EquilibriumPointInArray obj = new _10_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2, 3);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void mediumArrayWithNoEquilibrium() {
    _10_EquilibriumPointInArray obj = new _10_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2, 3, 4, 5, 6);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void arrayWithEquilibrium() {
    _10_EquilibriumPointInArray obj = new _10_EquilibriumPointInArray();
    int equilibrium = obj.find(1, 7, 3, 6, 5, 6);
    assertEquals(3, equilibrium);
  }
}