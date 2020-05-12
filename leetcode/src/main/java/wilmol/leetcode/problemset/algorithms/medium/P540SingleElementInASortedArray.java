package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-05-12.
 *
 * <p><a
 * href=https://leetcode.com/problems/single-element-in-a-sorted-array>https://leetcode.com/problems/single-element-in-a-sorted-array/</a>
 *
 * <p>Runtime: O(log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Duplicate pairings are [even, odd] indices before the target and [odd, even] after.
 */
class P540SingleElementInASortedArray {

  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;

    // binary search
    int l = 0;
    int r = n - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;

      // will be [even, odd] before the target (left half) [odd, even] after (right half)
      if (m >= 1 && nums[m - 1] == nums[m]) {
        if (isEven(m - 1)) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      } else if (m <= n - 2 && nums[m] == nums[m + 1]) {
        if (isEven(m)) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      } else {
        return nums[m];
      }
    }
    throw new IllegalArgumentException(Arrays.toString(nums));
  }

  private boolean isEven(int i) {
    return i % 2 == 0;
  }
}
