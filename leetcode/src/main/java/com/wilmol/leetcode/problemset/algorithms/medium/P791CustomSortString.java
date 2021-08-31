package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/custom-sort-string>https://leetcode.com/problems/custom-sort-string/</a>
 *
 * <p>Runtime: O(n * log(n)) where n = {@code str.length}
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Custom comparator by first creating {@code orderMap} from {@code order}.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P791CustomSortString {

  public String customSortString(String order, String str) {
    Map<Character, Integer> orderMap = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      orderMap.put(order.charAt(i), i);
    }

    Map<Character, Integer> strFrequencyMap = new HashMap<>();
    for (char c : str.toCharArray()) {
      strFrequencyMap.merge(c, 1, Integer::sum);
    }

    return strFrequencyMap.entrySet().stream()
        // defaultValue: 26, place at end by default
        .sorted(Comparator.comparing(e -> orderMap.getOrDefault(e.getKey(), 26)))
        .map(e -> ("" + e.getKey()).repeat(e.getValue()))
        .collect(Collectors.joining());
  }
}
