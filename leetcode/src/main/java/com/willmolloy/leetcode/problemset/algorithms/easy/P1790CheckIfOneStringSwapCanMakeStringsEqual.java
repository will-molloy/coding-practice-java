package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal>https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n) - O(1) if exit when maps grow beyond size 2
 *
 * <p>Key: String is a map where each index maps to a character. Track mismatching mappings. Check
 * if 0 mismatched mappings (strings are equal) or if 2 mismatched mappings and mapped values are
 * equal (can resolve with single swap).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1790CheckIfOneStringSwapCanMakeStringsEqual {

  public boolean areAlmostEqual(String s1, String s2) {
    Map<Integer, Character> map1 = new HashMap<>();
    Map<Integer, Character> map2 = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        map1.put(i, s1.charAt(i));
        map2.put(i, s2.charAt(i));
      }
    }

    return map1.isEmpty()
        || map1.size() == 2 && Set.copyOf(map1.values()).equals(Set.copyOf(map2.values()));
  }
}
