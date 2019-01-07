package code.collections.custom.test;

import code.collections.custom.impl.KStacks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KStacksTest {
  @Test
  void pushAndPopForOneStack() {
    KStacks ks = new KStacks(1, 3);

    ks.push(100, 0);
    assertEquals(ks.pop(0), 100);

    ks.push(100, 0);
    ks.push(200, 0);
    ks.push(300, 0);
    assertEquals(assertThrows(IllegalStateException.class, () -> ks.push(400, 0)).getMessage(), "No space in array to hold anymore items");

    assertEquals(ks.pop(0), 300);
    assertEquals(ks.pop(0), 200);
    assertEquals(ks.pop(0), 100);
    assertEquals(assertThrows(IllegalStateException.class, () -> ks.pop(0)).getMessage(), "No items to pop");
  }

  @Test
  void pushAndPopForTwoStacks() {
    KStacks ks = new KStacks(2, 5);

    ks.push(100, 0);
    ks.push(100, 1);
    assertEquals(ks.pop(0), 100);
    assertEquals(ks.pop(1), 100);

    ks.push(100, 0);
    ks.push(200, 0);
    ks.push(300, 0);

    ks.push(100, 1);
    ks.push(200, 1);

    assertEquals(assertThrows(IllegalStateException.class, () -> ks.push(400, 0)).getMessage(), "No space in array to hold anymore items");
    assertEquals(assertThrows(IllegalStateException.class, () -> ks.push(300, 1)).getMessage(), "No space in array to hold anymore items");

    assertEquals(ks.pop(0), 300);
    assertEquals(ks.pop(0), 200);
    assertEquals(ks.pop(1), 200);
    assertEquals(ks.pop(1), 100);
    assertEquals(ks.pop(0), 100);

    assertEquals(assertThrows(IllegalStateException.class, () -> ks.pop(0)).getMessage(), "No items to pop");
    assertEquals(assertThrows(IllegalStateException.class, () -> ks.pop(1)).getMessage(), "No items to pop");
  }
}
