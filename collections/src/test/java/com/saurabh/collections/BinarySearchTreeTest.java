package com.saurabh.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {
  private static final List<String> uniqueKeys = Arrays.asList("the", "a", "there", "answer", "any", "by", "bye", "their", "abc");
  private static final List<String> duplicateKeys = Arrays.asList("the", "a", "any", "by");
  private static final List<String> nonExistentKeys = Arrays.asList("foo", "bar", "therefore", "answered", "an", "ab");
  private static final List<String> toDelete = Arrays.asList("the", "a", "by");
  private static final List<String> toDelete2 = Arrays.asList("there", "answer", "any", "bye", "their", "abc");
  private final BinarySearchTree<String> bst = new BinarySearchTree<>();

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

  @Test(expected = RuntimeException.class)
  public void testAncestors_nonExistentNode() {
    bst.getAncestors("blah");
  }

  @Test
  public void testAncestors_existingNodes() {
    //Root node
    assertThat(bst.getAncestors("the").size(), is(0));

    // Level 1 nodes
    assertThat(bst.getAncestors("a"), hasItem("the"));
    assertThat(bst.getAncestors("there"), hasItem("the"));

    // Level 2 nodes
    assertThat(bst.getAncestors("answer"), hasItems("a", "the"));
    assertThat(bst.getAncestors("their"), hasItems("the", "there"));

    // Level 3 nodes
    assertThat(bst.getAncestors("abc"), hasItems("a", "the", "answer"));
    assertThat(bst.getAncestors("any"), hasItems("a", "the", "answer"));

    // Level 4 node
    assertThat(bst.getAncestors("by"), hasItems("the", "a", "answer", "any"));

    // Level 5 node
    assertThat(bst.getAncestors("bye"), hasItems("the", "a", "answer", "any", "by"));
  }

  @Test
  public void testClear() {
    bst.clear();
    assertThat(bst.size(), is(0));
    assertThat(bst.height(), is(0));
  }
}
