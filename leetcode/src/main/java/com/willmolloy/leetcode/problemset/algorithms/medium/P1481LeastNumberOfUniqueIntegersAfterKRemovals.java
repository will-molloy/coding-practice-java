package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals>https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/</a>
 *
 * <p>Runtime: O(n log(n))
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Greedily remove those with least frequency first.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1481LeastNumberOfUniqueIntegersAfterKRemovals {

  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    // remove those with least freq first, so save as much k as possible to remove more numbers

    Map<Integer, Long> freqs =
        Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    List<Map.Entry<Integer, Long>> sortedFreqs =
        freqs.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();

    int count = 0;
    for (Map.Entry<Integer, Long> e : sortedFreqs) {
      if (e.getValue() <= k) {
        k -= e.getValue();
      } else {
        count++;
      }
    }
    return count;
  }
}
