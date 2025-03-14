package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/reformat-the-string>https://leetcode.com/problems/reformat-the-string/</a>
 *
 * <p><a
 * href=https://leetcode.com/contest/weekly-contest-185/problems/reformat-the-string>https://leetcode.com/contest/weekly-contest-185/problems/reformat-the-string/</a>
 *
 * <p>Difficulty: Easy (3)
 *
 * <p>Time: 0:11:21
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: Build the string rather than generate permutations.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1417ReformatTheString {

  public String reformat(String s) {
    List<Character> letters = new ArrayList<>();
    List<Character> numbers = new ArrayList<>();

    for (char c : s.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        letters.add(c);
      } else {
        numbers.add(c);
      }
    }

    StringBuilder result = new StringBuilder();
    if (letters.size() - numbers.size() == 1) {
      // extra letter
      // e.g. a1b
      for (int i = 0; i < numbers.size(); i++) {
        result.append(letters.get(i));
        result.append(numbers.get(i));
      }
      result.append(letters.get(letters.size() - 1));
    } else if (numbers.size() - letters.size() == 1) {
      // extra num
      // e.g. 1a2
      for (int i = 0; i < letters.size(); i++) {
        result.append(numbers.get(i));
        result.append(letters.get(i));
      }
      result.append(numbers.get(numbers.size() - 1));
    } else if (numbers.size() == letters.size()) {
      // same
      for (int i = 0; i < letters.size(); i++) {
        result.append(numbers.get(i));
        result.append(letters.get(i));
      }
    }
    return result.toString();
  }
}
