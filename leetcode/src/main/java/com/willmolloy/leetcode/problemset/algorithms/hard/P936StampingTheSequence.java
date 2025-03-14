package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/stamping-the-sequence>https://leetcode.com/problems/stamping-the-sequence/</a>
 *
 * <p>Runtime: Guaranteed moves < 10 * t, so O(10 * t * t * s) = O(t<sup>2</sup> * s)?
 *
 * <p>Extra memory: O(1) - excluding result and converting {@code String} to {@code char[]}.
 *
 * <p>Key idea: Think of the target as layers of stamps:
 *
 * <ul>
 *   <li>target = ababc, stamp = abc
 *   <li>layer1 = ??abc
 *   <li>layer2 = abc??
 * </ul>
 *
 * <p>So work in reverse, replacing possible stamp substrings with '?', until the entire string is
 * replaced with '???...'.
 *
 * <p>Initially this substring will be the stamp itself, then it will be the stamp with prefixed
 * and/or suffixed '?'.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P936StampingTheSequence {

  public int[] movesToStamp(String stamp, String target) {
    ArrayDeque<Integer> result = new ArrayDeque<>();

    // convert to array for more efficient mutation
    char[] s = stamp.toCharArray();
    char[] t = target.toCharArray();

    int replaced = 0;

    while (true) {
      int prevReplaced = replaced;
      // O(t) outer loop
      for (int i = 0; i <= t.length - s.length; i++) {
        // find a possible stamp substring to replace with '?'s
        if (canReplace(t, s, i)) {
          replaced += doReplace(t, s, i);
          result.addFirst(i);
        }
      }
      if (replaced == t.length) {
        // replaced all in t, can successfully return
        return result.stream().mapToInt(i -> i).toArray();
      }
      if (prevReplaced == replaced) {
        // failed to replace any characters, reaching the target is not possible
        return new int[0];
      }
    }
  }

  // O(s)
  private boolean canReplace(char[] t, char[] s, int offset) {
    for (int i = 0; i < s.length; i++) {
      if (t[i + offset] == '?') {
        continue;
      }
      if (t[i + offset] != s[i]) {
        return false;
      }
    }
    return true;
  }

  // O(s)
  private int doReplace(char[] t, char[] s, int offset) {
    int count = 0;
    for (int i = 0; i < s.length; i++) {
      if (t[i + offset] == '?') {
        continue;
      }
      t[i + offset] = '?';
      count++;
    }
    return count;
  }
}
