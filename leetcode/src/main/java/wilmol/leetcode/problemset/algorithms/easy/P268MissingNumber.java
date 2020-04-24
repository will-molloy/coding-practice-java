package wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by wilmol on 2020-04-24.
 *
 * <p><a
 * href=https://leetcode.com/problems/missing-number>https://leetcode.com/problems/missing-number/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Summing the numbers.
 */
class P268MissingNumber {

  public int missingNumber(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int wholeSum = IntStream.rangeClosed(1, nums.length).sum();
    // difference must contain the missing number
    // e.g. (0 + 1 + 2 + 3) - (0 + 1 + 3) = 2
    return wholeSum - sum;
  }
}
