package code.collections.custom.test;

import code.collections.custom.impl.BST;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class BstTest {
  private static final List<String> uniqueKeys = Arrays.asList("the", "a", "there", "answer", "any", "by", "bye", "their", "abc");
  private static final List<String> duplicateKeys = Arrays.asList("the", "a", "any", "by");
  private static final List<String> nonExistentKeys = Arrays.asList("foo", "bar", "therefore", "answered", "an", "ab");
  private static final List<String> toDelete = Arrays.asList("the", "a", "by");
  private static final List<String> toDelete2 = Arrays.asList("there", "answer", "any", "bye", "their", "abc");
  private final BST<String> bst = new BST<>();

  @Before
  public void setUp() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(bst.insert(uniqueKey)));
    assertThat(bst.size(), is(uniqueKeys.size()));
  }

  @Test
  public void testInsertDuplicateWords() {
    duplicateKeys.forEach(duplicateKey -> assertFalse(bst.insert(duplicateKey)));
    assertThat(bst.size(), is(uniqueKeys.size()));
    assertThat(bst.height(), is(6));
  }

  @Test
  public void testInOrderTraversal() {
    List<String> uniqueKeysCopy = new ArrayList<>(uniqueKeys);
    Collections.sort(uniqueKeysCopy);
    assertThat(bst.inOrder(), is(uniqueKeysCopy));
  }

  @Test
  public void testSearch() {
    uniqueKeys.forEach(uniqueKey -> assertNotNull(bst.search(uniqueKey)));
    nonExistentKeys.forEach(nonExistentKey -> assertNull(bst.search(nonExistentKey)));
  }

  @Test
  public void testDelete() {
    toDelete.forEach(toDeleteKey -> assertTrue(bst.remove(toDeleteKey)));
    assertThat(bst.size(), is(uniqueKeys.size() - toDelete.size()));
    assertThat(bst.height(), is(4));

    toDelete2.forEach(toDeleteKey -> assertTrue(bst.remove(toDeleteKey)));
    assertThat(bst.size(), is(0));
    assertThat(bst.height(), is(0));

    nonExistentKeys.forEach(nonExistentKey -> assertFalse(bst.remove(nonExistentKey)));
  }

  @Test
  public void testDeleteAndReinsert() {
    toDelete.forEach(toDeleteKey -> assertTrue(bst.remove(toDeleteKey)));
    toDelete2.forEach(toDeleteKey -> assertTrue(bst.remove(toDeleteKey)));
    assertThat(bst.size(), is(0));

    uniqueKeys.forEach(uniqueKey -> assertTrue(bst.insert(uniqueKey)));
    assertThat(bst.size(), is(uniqueKeys.size()));
  }

  @Test
  public void testClear() {
    bst.clear();
    assertThat(bst.size(), is(0));
    assertThat(bst.height(), is(0));
  }
}
