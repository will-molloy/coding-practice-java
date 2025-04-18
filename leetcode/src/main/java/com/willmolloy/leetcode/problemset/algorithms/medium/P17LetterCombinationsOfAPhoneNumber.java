package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/letter-combinations-of-a-phone-number>https://leetcode.com/problems/letter-combinations-of-a-phone-number</a>
 *
 * <p>Runtime: O(3 ^ n * 4 ^ m) - n = num digits mapping to 3 letters, m = num digits mapping to 4
 * letters
 *
 * <p>E.g. "23" -> 9 combinations (3 ^ 2)
 *
 * <p>E.g.2 "27" -> 12 combinations (3 ^ 1 * 4 ^ 1)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P17LetterCombinationsOfAPhoneNumber {

  private static final Map<Character, List<String>> LETTERS;

  static {
    Map<Character, List<String>> m = new HashMap<>();
    m.put('2', Arrays.asList("a", "b", "c"));
    m.put('3', Arrays.asList("d", "e", "f"));
    m.put('4', Arrays.asList("g", "h", "i"));
    m.put('5', Arrays.asList("j", "k", "l"));
    m.put('6', Arrays.asList("m", "n", "o"));
    m.put('7', Arrays.asList("p", "q", "r", "s"));
    m.put('8', Arrays.asList("t", "u", "v"));
    m.put('9', Arrays.asList("w", "x", "y", "z"));

    LETTERS = Collections.unmodifiableMap(m);
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return Collections.emptyList();
    }
    List<String> result = Collections.singletonList("");

    for (char c : digits.toCharArray()) {
      List<String> newResult = new ArrayList<>();
      for (String old : result) {
        for (String s : LETTERS.get(c)) {
          newResult.add(old + s);
        }
      }
      result = newResult;
    }
    return result;
  }
}
