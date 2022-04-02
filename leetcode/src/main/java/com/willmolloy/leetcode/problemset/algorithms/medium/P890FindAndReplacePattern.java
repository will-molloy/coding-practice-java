package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/find-and-replace-pattern>https://leetcode.com/problems/find-and-replace-pattern/</a>
 *
 * <p>Runtime: O(n * k) - n = number of words, k = word size
 *
 * <p>Extra memory: O(k)
 *
 * <p>Key: Normalise the words - map first character to 'a', second to 'b' and so on.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P890FindAndReplacePattern {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    String normalisedPattern = normalise(pattern);

    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (normalise(word).equals(normalisedPattern)) {
        result.add(word);
      }
    }
    return result;
  }

  // normalise the string by mapping the first character to 'a', the second to 'b' and so on
  // e.g. "wxyxyz" becomes "abcbcd"
  private String normalise(String s) {
    StringBuilder result = new StringBuilder();
    char current = 'a';
    Map<Character, Character> mapping = new HashMap<>();

    for (char c : s.toCharArray()) {
      if (!mapping.containsKey(c)) {
        mapping.put(c, current);
        current++;
      }
      result.append(mapping.get(c));
    }
    return result.toString();
  }
}
