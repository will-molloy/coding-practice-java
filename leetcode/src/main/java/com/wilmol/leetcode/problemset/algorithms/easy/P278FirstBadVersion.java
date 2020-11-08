package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/first-bad-version>https://leetcode.com/problems/first-bad-version/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(log n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Binary search. Essentially have an array partitioned into false (good version) and true
 * (bad version) ([false, false, ..., true, true]) want the first true.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P1283FindTheSmallestDivisorGivenAThreshold
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P1482MinimumNumberOfDaysToMakeMBouquets
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P1552MagneticForceBetweenTwoBalls
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P278FirstBadVersion {

  /** VersionControl class. */
  static class VersionControl {
    private final int firstBadVersion;

    VersionControl(int firstBadVersion) {
      this.firstBadVersion = firstBadVersion;
    }

    final boolean isBadVersion(int version) {
      return version >= firstBadVersion;
    }
  }

  /** Solution class. */
  static class Solution extends VersionControl {

    Solution(int firstBadVersion) {
      super(firstBadVersion);
    }

    public int firstBadVersion(int n) {
      // binary search lol
      // the search range is [1, n]
      int l = 1;
      int r = n;

      int first = -1;
      while (l <= r) {
        int m = l + (r - l) / 2;
        if (isBadVersion(m)) {
          first = m;
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
      return first;
    }
  }
}
