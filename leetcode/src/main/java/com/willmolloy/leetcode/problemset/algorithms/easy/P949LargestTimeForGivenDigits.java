package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/largest-time-for-given-digits>https://leetcode.com/problems/largest-time-for-given-digits/</a>
 *
 * <p>Runtime: O(1) (fixed size input)
 *
 * <p>Extra memory: O(1) (fixed size input)
 *
 * <p>Key: Try all digit permutations. Easier to do this than come up with all the cases.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P949LargestTimeForGivenDigits {

  public String largestTimeFromDigits(int[] a) {
    return dfs(a, new ArrayList<>(), new HashSet<>(), "").stream()
        .filter(s -> s.matches("(2[0-3]|[0-1][0-9])[0-5][0-9]"))
        .max(Comparator.comparing(Integer::parseInt))
        .map(s -> s.substring(0, 2) + ":" + s.substring(2, 4))
        .orElse("");
  }

  private List<String> dfs(int[] a, List<String> result, Set<Integer> used, String temp) {
    if (temp.length() == 4) {
      result.add(temp);
      return result;
    }

    for (int i = 0; i < a.length; i++) {
      if (used.contains(i)) {
        continue;
      }
      used.add(i);
      temp += a[i];
      dfs(a, result, used, temp);
      // back track
      used.remove(i);
      temp = temp.substring(0, temp.length() - 1);
    }
    return result;
  }
}
