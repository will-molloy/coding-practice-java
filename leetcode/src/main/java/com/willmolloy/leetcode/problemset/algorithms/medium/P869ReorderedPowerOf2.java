package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/reordered-power-of-2>https://leetcode.com/problems/reordered-power-of-2/</a>
 *
 * <p>Runtime: O(log(n)! * log(n)) - log(n) is number of digits in {@code n} - we try all
 * permutations (O(log(n)!)) and the isPowerOfTwo test is O(log(n))
 *
 * <p>Extra memory: O(log(n)) - recursion depth
 *
 * <p>Key idea: Try all permutations of the digits in {@code n} (convert to string first).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P869ReorderedPowerOf2 {

  public boolean reorderedPowerOf2(int n) {
    String s = String.valueOf(n);
    return dfs(s, "", new boolean[s.length()]);
  }

  private boolean dfs(String s, String temp, boolean[] used) {
    if (temp.length() == s.length()) {
      // leading zero can't be considered
      return temp.charAt(0) != '0' && isPowerOf2(Integer.parseInt(temp));
    }

    for (int i = 0; i < s.length(); i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      if (dfs(s, temp + s.charAt(i), used)) {
        return true;
      }
      used[i] = false;
    }
    return false;
  }

  private boolean isPowerOf2(int n) {
    while (n > 1) {
      if (n % 2 != 0) {
        return false;
      }
      n /= 2;
    }
    return true;
  }
}
