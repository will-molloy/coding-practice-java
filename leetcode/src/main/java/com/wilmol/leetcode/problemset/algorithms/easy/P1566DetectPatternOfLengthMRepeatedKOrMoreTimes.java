package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times>https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: First gather all patterns, then check if any pattern repeats {@code k} times
 * contiguously.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1566DetectPatternOfLengthMRepeatedKOrMoreTimes {

  // TODO O(n) time O(1) space is possible

  public boolean containsPattern(int[] arr, int m, int k) {
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    // get all patterns
    Set<List<Integer>> patterns = new HashSet<>();
    for (int i = 0; i <= list.size() - m; i++) {
      patterns.add(list.subList(i, i + m));
    }

    for (List<Integer> pattern : patterns) {
      int count = 0;
      for (int i = 0; i <= list.size() - m; ) {
        if (list.subList(i, i + m).equals(pattern)) {
          count++;
          if (count == k) {
            return true;
          }
          i += m;
        } else {
          count = 0;
          i++;
        }
      }
    }
    return false;
  }
}
