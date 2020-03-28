package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-03-28.
 *
 * <p><a
 * href=https://leetcode.com/problems/range-sum-query-immutable>https://leetcode.com/problems/range-sum-query-immutable</a>
 *
 * <p>Runtime: See methods
 *
 * <p>Space: O(n)
 *
 * <p>Key: knowledge of ranges/intervals, pre-computing
 */
class P303RangeSumQueryImmutable {

  static class NumArray {
    // O(n) space
    private final int[] frontSums;

    // O(n) time
    NumArray(int[] nums) {
      // pre compute 'front sums'
      // i.e. all sums [0..i] where i = [0..n]
      // then in sum method can compute in O(1):
      // i.e. sumRange[i..j] = sumRange[0..j] - sumRange[0..i)

      frontSums = new int[nums.length];
      if (frontSums.length == 0) {
        return;
      }
      frontSums[0] = nums[0];
      for (int i = 1; i < frontSums.length; i++) {
        frontSums[i] = frontSums[i - 1] + nums[i];
      }
    }

    // O(1) time
    int sumRange(int i, int j) {
      // [0..j]
      int zeroToJ = frontSums[j];
      // [0..i) (empty range if i = 0)
      int zeroUntilI = i > 0 ? frontSums[i - 1] : 0;
      return zeroToJ - zeroUntilI;
    }
  }
}
