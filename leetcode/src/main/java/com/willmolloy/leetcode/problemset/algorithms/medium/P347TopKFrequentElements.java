package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/top-k-frequent-elements>https://leetcode.com/problems/top-k-frequent-elements/</a>
 *
 * <p>Runtime: O(n * log(k))
 *
 * <p>Extra memory: O(n + k)
 *
 * <p>Key: Count frequencies then take top k with heap.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P414ThirdMaximumNumber
 * @see P692TopKFrequentWords
 * @see P973KClosestPointsToOrigin
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P347TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Long> freqs =
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparing(freqs::get));
    for (int i : Arrays.stream(nums).distinct().toArray()) {
      heap.add(i);
      if (heap.size() > k) {
        heap.remove();
      }
    }

    return heap.stream().mapToInt(i -> i).toArray();
  }
}
