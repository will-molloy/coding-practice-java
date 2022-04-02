package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/make-the-string-great>https://leetcode.com/problems/make-the-string-great/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>), worst case delete 2 characters each time until all n deleted (n/2
 * iterations each costing O(n)) TODO O(n) is possible
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Bruteforce the simulation; keep going until string stops changing.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1544MakeTheStringGreat {

  public String makeGood(String s) {
    List<String> pairs = new ArrayList<>();
    for (char c = 'a'; c <= 'z'; c++) {
      pairs.add("" + c + Character.toUpperCase(c));
      pairs.add("" + Character.toUpperCase(c) + c);
    }
    String regex = "(" + String.join("|", pairs) + ")";

    boolean change = true;
    while (change) {
      String next = s.replaceAll(regex, "");
      change = next.length() != s.length();
      s = next;
    }
    return s;
  }
}
