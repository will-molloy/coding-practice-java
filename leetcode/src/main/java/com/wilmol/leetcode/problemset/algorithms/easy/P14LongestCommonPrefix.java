package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by Will on 2019-07-20 at 21:33.
 *
 * <p><a
 * href=https://leetcode.com/problems/longest-common-prefix>https://leetcode.com/problems/longest-common-prefix</a>
 *
 * <p>Runtime: O(n) - inner while loop does not run for each n
 *
 * <p>TODO use a trie - apparently best for very large inputs or 'live data' (i.e. new stuff being
 * added)
 */
class P14LongestCommonPrefix {

  String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    // note: inner loop only gets smaller, it never runs completely for each n
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    return prefix;
  }
}
