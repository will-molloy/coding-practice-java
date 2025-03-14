package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique>https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: If frequencies are unique then expect them to be in strictly increasing/decreasing
 * order once sorted. Greedily delete each freq down (potentially to 0) such that there is no more
 * duplication - order of processing a char doesn't matter cause you can only delete.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1647MinimumDeletionsToMakeCharacterFrequenciesUnique {

  public int minDeletions(String s) {
    // count freqs
    int[] freqs = new int[26];
    for (char c : s.toCharArray()) {
      freqs[c - 'a']++;
    }
    Arrays.sort(freqs);

    // if frequencies are unique then expect them to be in strictly decreasing order (when iterating
    // in reverse)

    int deletes = 0;
    int expect = freqs[25];
    for (int i = 25; i >= 0; i--) {
      if (freqs[i] == 0) {
        break;
      }
      if (freqs[i] > expect) {
        // expected to be lower, have a dupe
        // delete down as little as possible (to expected value)
        deletes += freqs[i] - expect;
        expect = Math.max(expect - 1, 0);
      } else {
        // can only delete (i.e can't add characters) so update expect to current freq - 1 for next
        // iteration
        expect = Math.max(freqs[i] - 1, 0);
      }
    }
    return deletes;
  }
}
