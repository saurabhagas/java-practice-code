package com.saurabh.algorithms.sorting;

import java.util.Comparator;

public class BucketSorter<T extends Number & Comparable> {
  private static final int BUCKET_SIZE = 10;

  public T[] sort(T[] items) {
    T[] sortedArray = items.clone();
    int[] bucketIndex = new int[BUCKET_SIZE];
    Object[][] buckets = new Object[BUCKET_SIZE][items.length];
    sortArray(items, sortedArray, bucketIndex, buckets);
    return sortedArray;
  }

  private void sortArray(T[] items, Object[] sortedArray, int[] bucketIndex, Object[][] buckets) {
    for (T item : items) {
      int bucket = getBucket(item);
      buckets[bucket][bucketIndex[bucket]] = item;
      bucketIndex[bucket]++;
    }

    int k = 0;
    int bucketNo = 0;
    for (Object[] bucketList : buckets) {
      if (bucketList != null && bucketIndex[bucketNo] > 0) {
        bucketList = sortBucket(bucketList);
        for (int i = 0; i < bucketIndex[bucketNo]; i++) {
          sortedArray[k] = bucketList[i];
          k++;
        }
      }
      bucketNo++;
    }
  }

  private int getBucket(Number data) {
    int bucket = data.intValue() / BUCKET_SIZE;
    if (bucket < 0) {
      return 0;
    } else if (bucket >= BUCKET_SIZE) {
      return BUCKET_SIZE - 1;
    } else {
      return bucket;
    }
  }

  private Object[] sortBucket(Object[] bucket) {
    InsertionSorter bSort = new InsertionSorter<>();
    return bSort.sort(bucket, Comparator.naturalOrder());
  }
}
