package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/longest-string-chain>https://leetcode.com/problems/longest-string-chain/</a>
 *
 * <p>Runtime: O(n * k<sup>2</sup>) - n = number of words, k = word length
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: DFS from each word, traverse to each word with one character removed. Cache the results
 * (DP).
 *
 * <p>DFS always halts because it moves towards empty string.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P1048LongestStringChain {

  public int longestStrChain(String[] words) {
    dp = new HashMap<>();

    Set<String> wordSet = Arrays.stream(words).collect(Collectors.toUnmodifiableSet());

    int result = 1;
    for (String s : wordSet) {
      result = Math.max(result, dfs(s, wordSet));
    }
    return result;
  }

  private Map<String, Integer> dp;

  // dfs - traverse from 's' to each word with one character removed from 's'
  private int dfs(String s, Set<String> words) {
    if (!words.contains(s)) {
      return 0;
    }
    if (dp.containsKey(s)) {
      return dp.get(s);
    }

    int result = 1;
    for (int i = 0; i < s.length(); i++) {
      // [0, i) + (i, n)
      String newWord = s.substring(0, i) + s.substring(i + 1);
      result = Math.max(result, 1 + dfs(newWord, words));
    }

    dp.put(s, result);
    return result;
  }
}
