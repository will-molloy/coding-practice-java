package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/ambiguous-coordinates>https://leetcode.com/problems/ambiguous-coordinates/</a>
 *
 * <p>Runtime: O(n<sup>4</sup>) - O(n<sup>3</sup>) loops and Java {@code substring} call is O(n)
 *
 * <p>Extra memory: O(n<sup>2</sup>) - storing {@code prefix}/{@code suffix} is O(n), storing all
 * {@code dottedPrefix}/{@code dottedSuffix} is O(n<sup>2</sup>), {@code result} is
 * O(n<sup>3</sup>).
 *
 * <p>Key: Split string into two {@code prefix}/{@code suffix} with comma in between. Split those
 * {@code prefix}/{@code suffix} into two with dot in between. Result is all ordered combinations of
 * such substrings (cartesian product). Also need to filter cases where extranneous zeroes are
 * invalid.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P816AmbiguousCoordinates {

  public List<String> ambiguousCoordinates(String s) {
    // s = (123)
    // 123
    // 1 23
    // 1 2.3
    // 12 3
    // 1.2 3

    // cartesian product: comma positions X dot positions

    List<String> result = new ArrayList<>();

    String digits = s.substring(1, s.length() - 1);

    // split for all comma positions
    // loop such that both prefix/suffix are non empty - i in range [0, n - 1]
    for (int i = 1; i <= digits.length() - 1; i++) {
      String prefix = digits.substring(0, i);
      String suffix = digits.substring(i);
      for (String dottedPrefix : allDots(prefix)) {
        for (String dottedSuffix : allDots(suffix)) {
          result.add(String.format("(%s, %s)", dottedPrefix, dottedSuffix));
        }
      }
    }
    return result;
  }

  private List<String> allDots(String s) {
    List<String> result = new ArrayList<>();
    if (s.equals("0") || !s.startsWith("0")) {
      // no dots
      result.add(s);
    }

    // split for all dot positions
    // loop such that both prefix/suffix are non empty - i in range [0, n - 1]
    for (int i = 1; i <= s.length() - 1; i++) {
      String prefix = s.substring(0, i);
      if (prefix.equals("0") || !prefix.startsWith("0")) {
        String suffix = s.substring(i);
        if (!suffix.endsWith("0")) {
          result.add(String.format("%s.%s", prefix, suffix));
        }
      }
    }
    return result;
  }
}
