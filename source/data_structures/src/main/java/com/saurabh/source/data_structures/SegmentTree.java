package com.saurabh.source.data_structures;

import java.util.function.BiFunction;

/*
  Segment tree is a tree-based data structure which specializes in range queries.
  Performance:
    1. Construction O(n) time
    2. Query O(logn)
    3. Update O(logn)
  Properties:
    1. Leaf nodes are the original nodes
    2. Segment tree is a full binary tree (each node has 0 or 2 nodes). Heap is a complete binary tree
    3. If n is not a power of 2, segment tree will contain dummy nodes.
    4. Children of parent at index i -> 2 * i + 1 and 2 * i + 2
    5. Parent of child at index i -> floor(i - 1 / 2)
    6. Nodes in segment tree = 2 * n - 1, if n is a power of 2. If not, use the next greater power of 2 which is greater than n.
 */
public class SegmentTree {
  private final int[] nodes;
  private final Operation operation;
  private final int originalSize;

  public static class Operation {
    private final BiFunction<Integer, Integer, Integer> function;
    private final int identityOperand;

    public static Operation of(BiFunction<Integer, Integer, Integer> function, int identityOperand) {
      return new Operation(function, identityOperand);
    }

    private Operation(BiFunction<Integer, Integer, Integer> function, int identityOperand) {
      this.function = function;
      this.identityOperand = identityOperand;
    }

    Integer apply(Integer one, Integer two) {
      return function.apply(one, two);
    }

    int identity() {
      return identityOperand;
    }
  }

  public SegmentTree(int[] array, Operation operation) {
    int height = (int) Math.ceil(Math.log(array.length) / Math.log(2));
    int size = (int) (2 * Math.pow(2, height) - 1);
    this.originalSize = array.length;
    this.nodes = new int[size];
//    Arrays.fill(nodes, Integer.MAX_VALUE);
    construct(array, 0, array.length - 1, nodes, 0, operation);
    this.operation = operation;
  }

  public int rangeQuery(int start, int end) {
    return query(start, end, 0, originalSize - 1, 0);
  }

  private int query(int start, int end, int treeStart, int treeEnd, int treeCurr) {
    // If segment of this node is a part of given range, then return the current position in tree
    if (start <= treeStart && end >= treeEnd) return nodes[treeCurr];

    // If segment of this node is outside the given range
    if (treeEnd < start || treeStart > end) return operation.identity();

    int treeMid = (treeStart + treeEnd) / 2;
    return operation.apply(query(start, end, treeStart, treeMid, lChild(treeCurr)), query(start, end, treeMid + 1, treeEnd, rChild(treeCurr)));
  }

  /**
   *
   * @param src input array
   * @param srcBegin current begin position in the input
   * @param srcEnd current end position in the input
   * @param dest the array containing the constructed segment tree
   * @param destCurr the current position in the array being constructed
   * @param operation the operation (e.g. sum, max, min etc.) to perform on the nodes
   * @return the value stored at {@code destCurr}
   */
  private static int construct(int[] src, int srcBegin, int srcEnd, int[] dest, int destCurr, Operation operation) {
    if (srcBegin == srcEnd) {
      dest[destCurr] = src[srcBegin];
      return dest[destCurr];
    }

    int mid = (srcBegin + srcEnd) / 2;
    dest[destCurr] = operation.apply(
        construct(src, srcBegin, mid, dest, lChild(destCurr), operation),
        construct(src, mid + 1, srcEnd, dest, rChild(destCurr), operation));
    return dest[destCurr];
  }

  private static int lChild(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private static int rChild(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private static int parent(int childIndex) {
    return (childIndex - 1) >> 1;
  }
}
