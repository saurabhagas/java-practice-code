package code.collections.custom.test;

import code.collections.custom.impl.AvlTree;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class AvlTreeTest {
  private static final Set<Integer> uniqueKeys = new HashSet<>(Arrays.asList(9, 5, 10, 0, 6, 11, -1, 1, 2));
  private static final Set<Integer> nonExistentKeys = new HashSet<>(Arrays.asList(100, 200, 300));
  private static final Set<Integer> toDelete = new HashSet<>(Arrays.asList(9, 1, 10));
  private static final Set<Integer> toDelete2 = new HashSet<>(Arrays.asList(5, 0, 6, 11, -1, 2));
  private final AvlTree<Integer> avlTree = new AvlTree<>();

  @Before
  public void setUp() {
    uniqueKeys.forEach(uniqueKey -> assertThat(avlTree.insert(uniqueKey)).isTrue());
    /* The constructed AVL Tree would be:
            9
           / \
          1  10
        / \    \
       0   5    11
          /    / \
       -1     2   6
    */
    assertThat(avlTree.size()).isEqualTo(uniqueKeys.size());
  }

  @Test
  public void testInOrderTraversal() {
    List<Integer> uniqueKeysCopy = new ArrayList<>(uniqueKeys);
    Collections.sort(uniqueKeysCopy);
    assertThat(avlTree.inOrder()).hasSameElementsAs(uniqueKeysCopy);
  }

  @Test
  public void testSearch() {
    uniqueKeys.forEach(uniqueKey -> assertThat(avlTree.search(uniqueKey)).isTrue());
    nonExistentKeys.forEach(nonExistentKey -> assertThat(avlTree.search(nonExistentKey)).isFalse());
  }

  @Test
  public void testDelete() {
    toDelete.forEach(toDeleteKey -> assertThat(avlTree.remove(toDeleteKey)).isTrue());
    assertThat(avlTree.size()).isEqualTo(uniqueKeys.size() - toDelete.size());
    assertThat(avlTree.height()).isEqualTo(3);

    toDelete2.forEach(toDeleteKey -> assertThat(avlTree.remove(toDeleteKey)).isTrue());
    assertThat(avlTree.size()).isZero();
    assertThat(avlTree.height()).isZero();

    uniqueKeys.forEach(nonExistentKey -> assertThat(avlTree.remove(nonExistentKey)).isFalse());
  }

  @Test
  public void testDeleteAndReinsert() {
    toDelete.forEach(toDeleteKey -> assertThat(avlTree.remove(toDeleteKey)).isTrue());
    toDelete2.forEach(toDeleteKey -> assertThat(avlTree.remove(toDeleteKey)).isTrue());
    assertThat(avlTree.size()).isZero();

    uniqueKeys.forEach(nonExistentKey -> assertThat(avlTree.insert(nonExistentKey)).isTrue());
    assertThat(avlTree.size()).isEqualTo(uniqueKeys.size());
  }

  @Test
  public void testClear() {
    avlTree.clear();
    assertThat(avlTree.size()).isEqualTo(0);
    assertThat(avlTree.height()).isEqualTo(0);
  }
}
