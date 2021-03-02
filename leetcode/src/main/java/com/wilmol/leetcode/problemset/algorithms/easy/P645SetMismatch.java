package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/set-mismatch>https://leetcode.com/problems/set-mismatch/</a>
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P442FindAllDuplicatesInAnArray
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P645SetMismatch {

  int[] findErrorNums(int[] nums);

  /**
   * O(n) space solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra memory: O(n)
   *
   * <p>Key: Duplicate has frequency of 2. Missing is num in range [1, n] that is missing.
   */
  class LinearSpace implements P645SetMismatch {

    @Override
    public int[] findErrorNums(int[] nums) {
      Map<Integer, Long> freqs =
          Arrays.stream(nums)
              .boxed()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      int duplicate =
          freqs.entrySet().stream()
              .filter(e -> e.getValue() == 2)
              .map(Map.Entry::getKey)
              .findFirst()
              .get();

      int missing =
          IntStream.rangeClosed(1, nums.length)
              .boxed()
              .filter(Predicate.not(freqs::containsKey))
              .findFirst()
              .get();

      return new int[] {duplicate, missing};
    }
  }

  /**
   * O(1) space solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra memory: O(1)
   *
   * <p>Key: Mark {@code num} seen by making {@code nums[num]} negative. Works since {@code num} is
   * in [1, n], so each has a bucket. (Same idea as {@link
   * com.wilmol.leetcode.problemset.algorithms.medium.P442FindAllDuplicatesInAnArray}.)
   */
  class ConstantSpace implements P645SetMismatch {

    @Override
    public int[] findErrorNums(int[] nums) {
      int duplicate = -1;
      int missing = -1;

      for (int i = 0; i < nums.length; i++) {
        // abs since other num may have made it negative
        int num = Math.abs(nums[i]);
        // num is in [1, n] so need 1-indexed
        int index = num - 1;

        if (nums[index] < 0) {
          // if already negative, must be dupe
          duplicate = num;
          // don't break, want to mark all present elements as seen so can find missing element
        } else {
          // make negative to mark as seen
          nums[index] = -nums[index];
        }
      }

      for (int num = 1; num <= nums.length; num++) {
        // num is in [1, n] so need 1-indexed
        int index = num - 1;
        if (nums[index] > 0) {
          missing = num;
          break;
        }
      }

      return new int[] {duplicate, missing};
    }
  }
}
