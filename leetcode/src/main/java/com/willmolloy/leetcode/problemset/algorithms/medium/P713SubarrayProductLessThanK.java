package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/subarray-product-less-than-k>https://leetcode.com/problems/subarray-product-less-than-k/</a>
 *
 * <p>Runtime: O(n) (reuse {@code start} from previous iteration, so amortised is O(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: For each {@code end}, find smallest {@code start} such that the window nums[{@code
 * start}, {@code end}] is valid.
 *
 * <p>Intuition: think of the case where the whole array is valid.
 *
 * <p>E.g. [1, 2, 3] with k = 7. First count [[1]], then [[1, 2], [2]] and then [[1, 2, 3], [2, 3],
 * [3]]
 *
 * <p>N.B. this only works because {@code nums[i]} > 0.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P713SubarrayProductLessThanK {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int n = nums.length;

    int count = 0;

    // two pointers: start, end
    // find window [start, end] for each end: [0, n) such that:
    // - window product is < k
    // - window is as large as possible (for given end)
    // (allow empty windows)

    int product = 1;
    int start = 0;

    for (int end = 0; end < n; end++) {
      // update end
      product *= nums[end];

      while (product >= k && start <= end) {
        // product too big, move in start of window
        product /= nums[start];
        start++;
      }

      // count each interval [[left, right], [left + 1, right], ..., [right, right]]
      count += end - start + 1;
    }

    return count;
  }
}
