package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2019-12-01.
 *
 * <p><a
 * href=https://leetcode.com/problems/maximum-subarray>https://leetcode.com/problems/maximum-subarray</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: optimisation problem, so greedy approach. Also storing 'best' to make single pass
 * possible.
 */
class P53MaximumSubarray {

  public int maxSubArray(int[] nums) {

    int best = nums[0];
    int current = 0;
    for (int num : nums) {
      if (current < 0) {
        // restart the sum from a position which begins with a positive sum (greedy)
        // the sum may contain negative nums!
        current = 0;
      }
      current += num;
      best = Math.max(best, current);
    }
    return best;
  }
}
