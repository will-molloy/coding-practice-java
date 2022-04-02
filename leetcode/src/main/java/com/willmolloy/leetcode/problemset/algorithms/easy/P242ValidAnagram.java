package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/valid-anagram>https://leetcode.com/problems/valid-anagram/</a>
 *
 * <p>Runtime: O(s + t)
 *
 * <p>Extra memory: O(s + t)
 *
 * <p>Key: Anagram if char frequencies are equal.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P242ValidAnagram {

  public boolean isAnagram(String s, String t) {
    return f(s).equals(f(t));
  }

  private Map<Character, Integer> f(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.merge(c, 1, Integer::sum);
    }
    return map;
  }
}
