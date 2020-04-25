import java.util.HashMap;
import java.util.Map;

/**
 * Find the indices of the elements in array totalling up to a given sum.
 *
 * Link: https://leetcode.com/problems/two-sum/
 */
public class _1TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hash = new HashMap<>(nums.length);
    for(int i = 0; i < nums.length; i++) {
      Integer previousKeyIndex = hash.put(nums[i], i);
      if (nums[i] * 2 == target && previousKeyIndex != null) {
        return new int[] {previousKeyIndex, i};
      }

      int other = target - nums[i];
      Integer foundIndex = hash.get(other);
      if(foundIndex != null && foundIndex != i) {
        return new int[] {i, foundIndex};
      }
    }
    throw new IllegalStateException();
  }
}
