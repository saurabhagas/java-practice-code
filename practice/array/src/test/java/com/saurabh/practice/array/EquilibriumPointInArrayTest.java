package com.saurabh.practice.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquilibriumPointInArrayTest {
  @Test
  public void trivialArray() {
    EquilibriumPointInArray obj = new EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void smallArrayWithNoEquilibrium() {
    EquilibriumPointInArray obj = new EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2, 3);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void mediumArrayWithNoEquilibrium() {
    EquilibriumPointInArray obj = new EquilibriumPointInArray();
    int equilibrium = obj.find(1, 2, 3, 4, 5, 6);
    assertEquals(-1, equilibrium);
  }

  @Test
  public void arrayWithEquilibrium() {
    EquilibriumPointInArray obj = new EquilibriumPointInArray();
    int equilibrium = obj.find(1, 7, 3, 6, 5, 6);
    assertEquals(3, equilibrium);
  }
}