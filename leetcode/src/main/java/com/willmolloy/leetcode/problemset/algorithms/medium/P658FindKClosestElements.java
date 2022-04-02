package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/find-k-closest-elements>https://leetcode.com/problems/find-k-closest-elements/</a>
 *
 * <p>Runtime: O(n * log(k))
 *
 * <p>Extra memory: O(k)
 *
 * <p>Key: Priority queue to hold the 'k' closest elements.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P658FindKClosestElements {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    Comparator<Integer> c =
        Comparator.comparing((Integer i) -> Math.abs(i - x))
            .thenComparing((Integer i) -> i)
            .reversed();
    PriorityQueue<Integer> q = new PriorityQueue<>(c);

    for (int i : arr) {
      q.add(i);
      if (q.size() > k) {
        q.remove();
      }
    }

    return q.stream().sorted().collect(Collectors.toList());
  }
}
