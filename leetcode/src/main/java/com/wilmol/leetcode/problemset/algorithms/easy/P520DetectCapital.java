package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/detect-capital>https://leetcode.com/problems/detect-capital/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1) TODO don't think regex allocates memory proportional to input?
 *
 * <p>Key: Regex.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P520DetectCapital {

  public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]+") || word.matches("[a-z]+") || word.matches("[A-Z][a-z]+");
  }
}
