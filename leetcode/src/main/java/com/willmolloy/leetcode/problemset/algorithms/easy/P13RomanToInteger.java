package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/roman-to-integer>https://leetcode.com/problems/roman-to-integer</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P13RomanToInteger {

  private static final Map<String, Integer> SYMBOLS;

  static {
    Map<String, Integer> m = new HashMap<>();
    m.put("I", 1);
    m.put("V", 5);
    m.put("X", 10);
    m.put("L", 50);
    m.put("C", 100);
    m.put("D", 500);
    m.put("M", 1000);
    // composites
    m.put("IV", 4);
    m.put("IX", 9);
    m.put("XL", 40);
    m.put("XC", 90);
    m.put("CD", 400);
    m.put("CM", 900);
    SYMBOLS = Collections.unmodifiableMap(m);
  }

  public int romanToInt(String s) {
    int sum = 0;
    char[] chars = s.toCharArray();
    int i = 0;
    while (i < chars.length) {
      if (i < chars.length - 1) {
        // not the most optimal to create substrings... but elegant and still O(n)
        String composite = String.copyValueOf(chars, i, 2);
        if (SYMBOLS.containsKey(composite)) {
          sum += SYMBOLS.get(composite);
          i += 2;
          continue;
        }
      }
      String single = String.valueOf(chars[i]);
      sum += SYMBOLS.get(single);
      i += 1;
    }
    return sum;
  }
}
