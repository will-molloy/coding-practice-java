package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wilmol on 2020-06-05.
 *
 * <p><a
 * href=https://leetcode.com/problems/random-pick-with-weight>https://leetcode.com/problems/random-pick-with-weight/</a>
 *
 * <p>Runtime: O(n) {@code Solution} constructor; O(log n) {@code pickIndex}
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Represent probability weights with ranges.
 */
class P528RandomPickWithWeight {

  static class Solution {

    private final int[] prefixSum;

    Solution(int[] w) {
      int n = w.length;

      // compute cumulative sum (prefix sum)
      // e.g. w = [2, 5, 3] then prefixSum = [2, 7, 10]
      prefixSum = new int[n];
      prefixSum[0] = w[0];
      for (int i = 1; i < n; i++) {
        prefixSum[i] = w[i] + prefixSum[i - 1];
      }
    }

    public int pickIndex() {
      int n = prefixSum.length;
      int bound = prefixSum[n - 1];

      // pick random number in range [0, bound)
      // e.g. w = [2, 5, 3] (prefixSum = [2, 7, 10])
      // so we pick uniformly random number in range [0, 10)
      // [0, 1] -> 0 (2/10 -> 20% chance)
      // [2, 6] -> 1 (5/10 -> 50% chance)
      // [7, 9] -> 2 (3/10 -> 30% chance)
      // i.e. the weights translate to ranges, which represent the correct probabilities
      // so we return the index of the range we land in

      // because prefix sum is always sorted binary search can be used
      int target = ThreadLocalRandom.current().nextInt(bound);
      int index = Arrays.binarySearch(prefixSum, target);

      if (index >= 0) {
        // found target (i.e. target was a specific cumulative weight)
        // return next index because its actually the start of the next range (see above)
        return index + 1;
      } else {
        // didn't find target (i.e. target was some value in a range other than the start of a range
        // (other than 0))
        // java.util.Arrays.binarySearch returns -(insertion point) - 1
        // we want this insertion point because this is the index of the range the target lies in
        // (see above)
        // so we need to invert this return value by multiplying by -1 and then adding -1
        // i.e. return value: -i - 1; multiply -1: i + 1; add -1: i
        return -index - 1;
      }
    }
  }
}
