package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/sort-characters-by-frequency>https://leetcode.com/problems/sort-characters-by-frequency/</a>
 *
 * <p>Runtime: O(n log(n))
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Count char freqs.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P451SortCharactersByFrequency {

  // TODO can do O(n) (bucket sort)

  public String frequencySort(String s) {
    Map<Character, Integer> charFreqs = new HashMap<>();
    for (char c : s.toCharArray()) {
      charFreqs.merge(c, 1, Integer::sum);
    }

    return charFreqs.entrySet().stream()
        .sorted(
            Comparator.comparingInt((Map.Entry<Character, Integer> e) -> e.getValue()).reversed())
        .map(
            e -> {
              char[] chars = new char[e.getValue()];
              Arrays.fill(chars, e.getKey());
              return new String(chars);
            })
        .collect(Collectors.joining());
  }
}
