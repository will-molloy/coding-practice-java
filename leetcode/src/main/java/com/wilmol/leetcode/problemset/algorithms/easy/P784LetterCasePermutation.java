package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2020-05-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/letter-case-permutation>https://leetcode.com/problems/letter-case-permutation/</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Extra space: O(n) (recursion stack size)
 *
 * <p>Key: String can be represented by a binary tree.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P494TargetSum
 */
class P784LetterCasePermutation {

  public List<String> letterCasePermutation(String s) {
    List<String> result = new ArrayList<>();
    dfs(result, 0, s.toCharArray());
    return result;
  }

  // perform a DFS over the string (it forms a binary tree)
  // single child if digit, two children if letter (lower and upper case)
  private void dfs(List<String> result, int i, char[] s) {
    if (i == s.length) {
      result.add(new String(s));
      return;
    }

    if (isDigit(s[i])) {
      dfs(result, i + 1, s);
    } else {
      // branch both lower and upper case
      s[i] = toLower(s[i]);
      dfs(result, i + 1, s);
      s[i] = toUpper(s[i]);
      dfs(result, i + 1, s);
    }
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  private char toLower(char c) {
    return (char) (c + (c >= 'a' && c <= 'z' ? 0 : -'A' + 'a'));
  }

  private char toUpper(char c) {
    return (char) (c + (c >= 'A' && c <= 'Z' ? 0 : -'a' + 'A'));
  }
}
