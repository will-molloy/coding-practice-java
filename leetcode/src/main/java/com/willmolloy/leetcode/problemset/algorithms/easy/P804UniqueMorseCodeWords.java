package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/unique-morse-code-words>https://leetcode.com/problems/unique-morse-code-words/</a>
 *
 * <p>Runtime: O(sum(s: words))
 *
 * <p>Extra memory: O(sum(s: words))
 *
 * <p>Key idea: Convert to morse and get unique count (hashset).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P804UniqueMorseCodeWords {

  public int uniqueMorseRepresentations(String[] words) {
    return (int) Arrays.stream(words).map(this::toMorse).distinct().count();
  }

  private String toMorse(String s) {
    String[] table = {
      ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    StringBuilder morse = new StringBuilder();
    for (char c : s.toCharArray()) {
      morse.append(table[c - 'a']);
    }
    return morse.toString();
  }
}
