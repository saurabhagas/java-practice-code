# Notes

1. Default sort behavior in Java is ascending. Use `Comparator.reverseOrder` to get descending order.
 
1. `PriorityQueue` uses a min heap by default. Use a custom `Comparator` in the constructor to override this behavior.

1. Arrays and `List`s can be sorted using built-in APIs.
`Arrays.sort` is the one for arrays, and accepts a comparator for generic arrays (and no `Comparator` for primitive arrays).
`List::sort` mandates you to pass a `Comparator`.

1. `Comparator` chaining:
    ```
    Comparator.comparing(Map.Entry<String, Integer>::getValue)
        .reversed()
        .thenComparing(Map.Entry<String, Integer>::getKey))
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
    - `Collections.min` and `Collections.max` (work on all colections)
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

1. Swapping without extra variable using XOR:
    ```
    array[j] = array[j] ^ array[j + 1];
    array[j + 1] = array[j] ^ array[j + 1];
    array[j] = array[j] ^ array[j + 1];
    ```

1. DFS in a graph:
   ```
   public List<String> depthFirstSearch(List<String> array) {	
     Deque<Node> stack = new ArrayDeque<>();
     stack.push(this);

     while (!stack.isEmpty()) {
       Node element = stack.pop();
       array.add(element.name);

       for (int i = element.children.size() - 1; i >= 0; i--) {
         stack.push(element.children.get(i));
       }
     }
     return array;
   }
   ```

1. BFS in a graph:
   ```
   public List<String> breadthFirstSearch(List<String> array) {	
     Deque<Node> queue = new ArrayDeque<>();
     stack.offer(this);

     while (!queue.isEmpty()) {
       Node element = stack.poll();
       array.add(element.name);

       for (int i = element.children.size() - 1; i >= 0; i--) {
         stack.offer(element.children.get(i));
       }
     }
     return array;
   }
   ```
   
1. Binary search:
   ```
   public int binarySearch(int[] array, int start, int end, int target) {
      if (start > end) return -1;
      int mid = (start + end) / 2;
      int midElement = array[mid];
      if (midElement == target) return mid;
      else if (target < midElement) return binarySearch(array, start, mid - 1, target);
      else return binarySearch(array, mid + 1, end, target);
   }
   ```

1. To convert a `List` of `Integer`s to a list of `int`s:
   ```
   list.stream().mapToInt(value -> value).toArray() 
   ``` 
   
1. Use `Arrays.toString()` and `Arrays.deepToString()` to print one and multi-dimensional arrays respectively.

1. Java Operators
- `|` (OR), `&` (AND), `^` (XOR), `~` (NOT).
- Bitwise operators have pretty low priority. Use `()` appropriately.

1. Java bit manipulation:
- A number `n` needs `logn` bits. Any operation which is linear in the number of bits will take `logn` time.
- `~` performs `NOT` operation. Thus, `~num` will be `-num - 1`.
- `>>` is signed right-shift operator. `>>>` is the unsigned variant.
- `<<` is signed left-shift operator. There's no `<<<` variant, as there's no need for it.
