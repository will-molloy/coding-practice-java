package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/longest-palindrome>https://leetcode.com/problems/longest-palindrome/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Palindrome can have at most one odd frequency since letters need to be distributed evenly
 * on either side of the centre.
 *
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.medium.P1457PseudoPalindromicPathsInABinaryTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P409LongestPalindrome {

  public int longestPalindrome(String s) {
    // count letter freqs
    Map<String, Long> freqs =
        Arrays.stream(s.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // take as many letters as possible (greedy)

    int ans = 0;
    boolean hasOdd = false;
    for (long i : freqs.values()) {
      if (i % 2 == 0) {
        // include all with even freq (can be distributed evenly on either side of centre)
        ans += i;
      } else {
        // those with odd freq become even freq by subtract 1
        hasOdd = true;
        ans += i - 1;
      }
    }

    // can include ONE complete odd freq (centre of palindrome)
    if (hasOdd) {
      ans += 1;
    }

    return ans;
  }
}
