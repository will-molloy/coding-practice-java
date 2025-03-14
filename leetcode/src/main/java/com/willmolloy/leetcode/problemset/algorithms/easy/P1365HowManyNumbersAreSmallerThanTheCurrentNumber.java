package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * <a
 * href=https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number>https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number</a>
 *
 * <p>Key idea: reading the problem constraints and realising that there are only 101 possible
 * values for {@code nums[i]}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1365HowManyNumbersAreSmallerThanTheCurrentNumber {

  // many ways to solve it
  // 1. compare each number with every other number - O(n^2)
  // 2. sort - O(n log n)
  // 3. counting frequencies - O(n)

  int[] smallerNumbersThanCurrent(int[] nums);

  /**
   * Implementation which uses a sorted map to count frequencies.
   *
   * <p>Runtime: O(n log n)
   *
   * <p>Space: O(n)
   */
  class SortedMap implements P1365HowManyNumbersAreSmallerThanTheCurrentNumber {

    @Override
    public int[] smallerNumbersThanCurrent(int[] nums) {
      TreeMap<Integer, Integer> map = new TreeMap<>();

      // count freq of each number - O(n log n) (TreeMap.put is O(log n))
      // TODO may as well just sort the array lol
      for (int num : nums) {
        map.merge(num, 1, Integer::sum);
      }

      // for each number, sum freqs of all numbers less than it - O(n)
      // (this is why we use a sorted map)
      // then the result for some key will be the value of the first entry less than it
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(key);
        int lowerValue = lowerEntry == null ? 0 : lowerEntry.getValue();
        map.replace(key, value + lowerValue);
      }

      // collect results - O(n)
      int[] results = new int[nums.length];
      for (int i = 0; i < results.length; i++) {
        int num = nums[i];
        Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(num);
        int lowerValue = lowerEntry == null ? 0 : lowerEntry.getValue();
        results[i] = lowerValue;
      }
      return results;
    }
  }

  /**
   * Implementation which uses an array to count frequencies, works well because there are only 101
   * possible values for {@code nums[i]}.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   */
  class Array implements P1365HowManyNumbersAreSmallerThanTheCurrentNumber {

    @Override
    public int[] smallerNumbersThanCurrent(int[] nums) {
      int[] counts = new int[101];

      // count freq of each number - O(n)
      for (int num : nums) {
        counts[num] += 1;
      }

      // for each number, sum freqs of all numbers less than it - O(100)
      // then the result for some key will be the value of the first entry less than it
      for (int i = 1; i < counts.length; i++) {
        counts[i] += counts[i - 1];
      }

      // collect results - O(n)
      int[] results = new int[nums.length];
      for (int i = 0; i < results.length; i++) {
        int num = nums[i];
        int result = num == 0 ? 0 : counts[num - 1];
        results[i] = result;
      }
      return results;
    }
  }
}
