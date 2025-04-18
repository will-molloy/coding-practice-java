package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k>https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/</a>
 *
 * <p>Runtime: O(s * k) TODO rolling hash is O(s)
 *
 * <p>Extra memory: O(2<sup>k</sup> * k)
 *
 * <p>Key idea: Need all binary substrings of length k, which there are 2<sup>k</sup> of. So keep
 * taking unique substrings until we have that many. Set/hashing is perfect for this.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1461CheckIfAStringContainsAllBinaryCodesOfSizeK {

  public boolean hasAllCodes(String s, int k) {
    int requiredSize = 1 << k;

    Set<String> set = new HashSet<>();
    for (int i = 0; i <= s.length() - k; i++) {
      String sub = s.substring(i, i + k);
      if (set.add(sub) && set.size() == requiredSize) {
        return true;
      }
    }
    return false;
  }
}
