package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/string-compression>https://leetcode.com/problems/string-compression/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Two pointers, one for writing the result, one for traversing the array. Can write
 * in-place because the traversal pointer will always be ahead or even (1 or 2 chars - even, >2
 * chars - ahead).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P443StringCompression {

  public int compress(char[] chars) {
    int n = chars.length;

    // write pointer
    int i = 0;
    // traversal pointer
    int j = 0;

    while (j < n) {
      if (j == n - 1 || chars[j] != chars[j + 1]) {
        // single char, no number needed
        chars[i++] = chars[j++];
      } else {
        j++;
        // count = 1 cause we moved j forward already
        int count = 1;
        while (j < n && chars[j] == chars[j - 1]) {
          j++;
          count++;
        }
        // write letter
        chars[i++] = chars[j - 1];
        // write number
        for (char c : String.valueOf(count).toCharArray()) {
          chars[i++] = c;
        }
      }
    }
    return i;
  }
}
