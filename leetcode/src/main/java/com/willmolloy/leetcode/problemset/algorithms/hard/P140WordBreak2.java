package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/word-break-ii>https://leetcode.com/problems/word-break-ii</a>
 *
 * <p>Key idea: dynamic programming, memoization (figuring out what is the key)
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P139WordBreak
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P140WordBreak2 {

  List<String> wordBreak(String s, List<String> wordDict);

  /**
   * Obvious DFS implementation. TLE on leetcode.
   *
   * <p>Runtime: O(2<sup>n</sup>) (n = length of 's')
   *
   * <p>Space: O(2<sup>n</sup>)
   */
  class Dfs implements P140WordBreak2 {

    @Override
    public List<String> wordBreak(String s, List<String> words) {
      return wordBreak(s, Collections.unmodifiableSet(new HashSet<>(words)));
    }

    // change to use Set for O(1) contains
    private List<String> wordBreak(String s, Set<String> words) {
      if (s.isEmpty()) {
        return Collections.emptyList();
      }

      List<String> results = new ArrayList<>();
      // try every prefix
      for (int i = 1; i <= s.length(); i++) {
        String prefix = s.substring(0, i);
        if (words.contains(prefix)) {
          // found valid prefix, see if suffix can be built
          String suffix = s.substring(i);
          if (suffix.isEmpty()) {
            // empty suffix is already built
            results.add(prefix);
          }
          List<String> subResults = wordBreak(suffix, words);
          for (String subResult : subResults) {
            // want all results
            String result = prefix + " " + subResult;
            results.add(result);
          }
        }
      }
      return results;
    }
  }

  /**
   * DFS implementation with memoization.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(2<sup>n</sup>)
   */
  class MemoizedDfs implements P140WordBreak2 {

    @Override
    public List<String> wordBreak(String s, List<String> words) {
      return wordBreak(s, Collections.unmodifiableSet(new HashSet<>(words)), new HashMap<>());
    }

    // same as previous, but with memoization cache
    private List<String> wordBreak(String s, Set<String> words, Map<String, List<String>> cache) {
      if (s.isEmpty()) {
        return Collections.emptyList();
      }

      List<String> cached = cache.get(s);
      if (cached != null) {
        return cached;
      }

      List<String> results = new ArrayList<>();
      for (int i = 1; i <= s.length(); i++) {
        String prefix = s.substring(0, i);
        if (words.contains(prefix)) {
          String suffix = s.substring(i);
          if (suffix.isEmpty()) {
            results.add(prefix);
          }
          List<String> subResults = wordBreak(suffix, words, cache);
          for (String subResult : subResults) {
            String result = prefix + " " + subResult;
            results.add(result);
          }
        }
      }
      cache.put(s, results);
      return results;
    }
  }
}
