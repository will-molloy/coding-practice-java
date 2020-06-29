package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/palindrome-partitioning>https://leetcode.com/problems/palindrome-partitioning</a>
 *
 * <p>Runtime: O(n * 2<sup>n</sup>)
 *
 * <p>Extra space: O(n) (maximum recursion depth)
 *
 * <p>Key: optimisation of passing indices as parameters (avoids cost of extra {@code
 * String.substring} calls)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P131PalindromePartitioning {

  public List<List<String>> partition(String s) {
    return partition(s, 0, new ArrayList<>(), new ArrayList<>());
  }

  private List<List<String>> partition(
      String s, int l, List<String> temp, List<List<String>> results) {
    if (l == s.length()) {
      results.add(new ArrayList<>(temp));
      return results;
    }

    // try all partitions O(2^n)
    // (note both l and r are inclusive)
    for (int r = l; r < s.length(); r++) {
      // front of string is already checked (and stored in temp list), check next region
      if (isPalindrome(s, l, r)) {
        temp.add(s.substring(l, r + 1));
        // recursively solve on rest of string
        partition(s, r + 1, temp, results);
        // back track
        temp.remove(temp.size() - 1);
      }
    }
    return results;
  }

  // O(n)
  private boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l++) != s.charAt(r--)) {
        return false;
      }
    }
    return true;
  }
}
