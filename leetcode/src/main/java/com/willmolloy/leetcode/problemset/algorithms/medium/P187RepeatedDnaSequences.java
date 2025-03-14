package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/repeated-dna-sequences>https://leetcode.com/problems/repeated-dna-sequences/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Hashset.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P1044LongestDuplicateSubstring
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P187RepeatedDnaSequences {

  // TODO rolling hash/rabin karp

  public List<String> findRepeatedDnaSequences(String s) {
    int n = s.length();

    Set<String> set = new HashSet<>();
    Set<String> result = new HashSet<>();
    for (int i = 0; i <= n - 10; i++) {
      String sub = s.substring(i, i + 10);
      if (!set.add(sub)) {
        result.add(sub);
      }
    }
    return List.copyOf(result);
  }
}
