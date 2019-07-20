package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by Will on 2019-07-20 at 21:33.
 *
 * <p><a
 * href=https://leetcode.com/problems/longest-common-prefix>https://leetcode.com/problems/longest-common-prefix</a>
 *
 * <p>Runtime: O(n * m) - n = number of strings, m = length of smallest string in strings
 *
 * <p>TODO check ? If all strings are equal, inner loop never runs. If no strings are equal, inner
 * loop exits on first iteration!
 *
 * <p>TODO use a trie - apparently best for very large inputs or 'live data' (i.e. new stuff being
 * added)
 */
class P14LongestCommonPrefix {

  String longestCommonPrefix(String[] strings) {
    if (strings == null || strings.length == 0) {
      return "";
    }
    if (strings.length == 1) {
      return strings[0];
    }

    // discover length of the smallest string (i.e. maximum size of prefix)
    int minLength = strings[0].length();
    for (int i = 1; i < strings.length; i++) {
      minLength = Math.min(strings[i].length(), minLength);
      if (minLength == 0) {
        return "";
      }
    }

    // move this length inwards until common prefix is found
    // note how outer loop is over each string
    // the prefix is moved inward for each string individually
    // e.g. strings = [flower, flow, flight] -> minlength = 4 -> 4 -> 2
    // therefore, never run full 'minLength' for each n, as each iteration reduces it
    for (int i = 1; i < strings.length; i++) {
      while (!strings[i].substring(0, minLength).equals(strings[0].substring(0, minLength))) {
        minLength--;
      }
      if (minLength == 0) {
        return "";
      }
    }
    return strings[0].substring(0, minLength);
  }
}
