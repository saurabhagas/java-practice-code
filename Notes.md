# Notes

1. Default sort behavior in Java is ascending. Use `Comparator.reverseOrder` to get descending order.
 
1. `PriorityQueue` uses a min heap as well. Use a custom `Comparator` in the constructor to override this behavior.

1. Arrays and `List`s can be sorted used built-in APIs.
`Arrays.sort` is the one for arrays, and accepts a comparator for generic arrays (and no `Comparator` for primitive arrays).
`List::sort` mandates you to pass a `Comparator`.

1. Comparator using Comparator APIs on a map storing keys to their frequency of occurrence:
    ```
    return wordCounts.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                .thenComparing(Map.Entry<String, Integer>::getKey))
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    ```

1. Making classes Comparable:
    ```
    class Tuple implements Comparable<Tuple> {
      ...
      @Override
      public int compareTo(Tuple other) {
        return this.something - other.something; // ascending order
        return other.something - this.something; // descending order
      }
    }
    ```

1. Useful `Collections` APIs:
    - `Collections.min` and `Collections.max`
    - `Collections.swap`
    - `Collections.sort`
    - `Collections.reverse`
    - `Collections.rotate`
    - `Collections.binarySearch`

1. Bubble sort code:
    ```
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length - i - 1; j++) { // subtract i because i elements are "bubbled up" in each iteration
        if (array[j] > array[j + 1]) { // Swaps in ascending order. Equality sign can be reversed
          swap(array, j, j + 1);
        }
      }
    }
    ```
1. 