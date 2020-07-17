package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/top-k-frequent-words>https://leetcode.com/problems/top-k-frequent-words/</a>
 *
 * <p>Runtime: O(n + n log(k) + k) = O(n log(k))
 *
 * <p>Extra space: O(n + k) = O(n)
 *
 * <p>Key: Heap (priority queue). Cannot use {@code addAll} with a priority queue it seems.
 *
 * @see P347TopKFrequentElements
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P414ThirdMaximumNumber
 * @see P973KClosestPointsToOrigin
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P692TopKFrequentWords {

  public List<String> topKFrequent(String[] words, int k) {
    // count freqs
    // O(n)
    Map<String, Long> freqs =
        Arrays.stream(words)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // store in min heap
    // sort in reverse order so head of heap is one we want to evict first and exclude from the ans
    // i.e. least frequency and higher alphabet first
    Comparator<String> comparator =
        Comparator.comparingLong((ToLongFunction<String>) freqs::get)
            .thenComparing(Comparator.reverseOrder());
    PriorityQueue<String> heap = new PriorityQueue<>(comparator);

    // maintain heap size as <= k
    // O(n log k)
    for (String word : freqs.keySet()) {
      heap.add(word);
      if (heap.size() > k) {
        heap.remove();
      }
    }

    // return in the desired order (i.e. reverse the heap)
    // O(k)
    List<String> ans = new ArrayList<>();
    // NOTE addAll does not work - see https://stackoverflow.com/q/62016507/6122976
    while (!heap.isEmpty()) {
      ans.add(heap.remove());
    }
    Collections.reverse(ans);
    return ans;
  }
}
