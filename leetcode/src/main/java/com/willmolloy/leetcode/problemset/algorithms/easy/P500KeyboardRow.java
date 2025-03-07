package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/keyboard-row>https://leetcode.com/problems/keyboard-row/</a>
 *
 * <p>Runtime: O(w)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Precompute keyboard letter row numbers.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P500KeyboardRow {

  private static final Map<Character, Integer> MAP;

  static {
    MAP = new HashMap<>();
    for (char c : Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')) {
      MAP.put(c, 1);
    }
    for (char c : Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')) {
      MAP.put(c, 2);
    }
    for (char c : Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm')) {
      MAP.put(c, 3);
    }
  }

  public String[] findWords(String[] words) {
    return Arrays.stream(words).filter(this::isValid).toArray(String[]::new);
  }

  private boolean isValid(String word) {
    int row = -1;
    for (char c : word.toCharArray()) {
      c = Character.toLowerCase(c);
      if (row == -1) {
        row = MAP.get(c);
      } else if (row != MAP.get(c)) {
        return false;
      }
    }
    return true;
  }
}
