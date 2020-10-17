package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/longest-duplicate-substring>https://leetcode.com/problems/longest-duplicate-substring/</a>
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P187RepeatedDnaSequences
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P275HIndex2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P1044LongestDuplicateSubstring {

  String longestDupSubstring(String s);

  /**
   * Runtime: O(n<sup>3</sup>) ({@link String#substring} is O(n))
   *
   * <p>Extra space: O(n<sup>2</sup>)
   *
   * <p>Key: Generate all contiguous substrings.
   */
  class BruteForce implements P1044LongestDuplicateSubstring {

    @Override
    public String longestDupSubstring(String s) {
      int n = s.length();

      // count all contiguous substrings
      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        for (int j = i; j <= n; j++) {
          String substring = s.substring(i, j);
          map.merge(substring, 1, Integer::sum);
        }
      }

      return map.entrySet().stream()
          // filter for duplicate substrings
          .filter(e -> e.getValue() > 1)
          .map(Map.Entry::getKey)
          // get the longest
          .max(Comparator.comparingInt(String::length))
          .orElse("");
    }
  }

  /**
   * Runtime: O(n<sup>2</sup> * log(n))
   *
   * <p>Extra space: O(n)
   *
   * <p>Key: Binary search the substring length. Works because if there is a duplicate substring for
   * a given length, there must be one for all smaller lengths.
   */
  class BinarySearch implements P1044LongestDuplicateSubstring {

    @Override
    public String longestDupSubstring(String s) {
      int n = s.length();

      int l = 0;
      int r = n;
      String best = "";
      while (l <= r) {
        int mid = l + (r - l) / 2;
        String dupSubstring = dupSubstring(s, mid);
        if (!dupSubstring.isEmpty()) {
          // found a dupe substring, search for larger one
          best = dupSubstring;
          l = mid + 1;
        } else {
          // didn't find dupe substring, search for smaller one
          r = mid - 1;
        }
      }
      return best;
    }

    // finds any dupe substring with the given length
    // O(n^2) - String.substring is O(n)
    private String dupSubstring(String s, int length) {
      int n = s.length();

      Set<String> set = new HashSet<>();
      for (int i = 0; i <= n - length; i++) {
        String substring = s.substring(i, i + length);
        if (!set.add(substring)) {
          return substring;
        }
      }
      return "";
    }
  }

  /**
   * Runtime: O(n * log(n))
   *
   * <p>Extra space: O(n)
   *
   * <p>Key: Rolling hash to efficiently find duplicate substring of given length.
   */
  class BinarySearchWithRollingHash implements P1044LongestDuplicateSubstring {

    // credit:
    // https://leetcode.com/problems/longest-duplicate-substring/discuss/695149/Python-rolling-hash-%2B-binary-search
    // https://leetcode.com/problems/longest-duplicate-substring/discuss/695214/JAVA-or-Binary-search-O(n-log-n)-average-with-Rabin-Karp-Algorithm

    // TODO why does mod have to be this? Why `1e9 + 7` doesn't work?
    private static final long MOD = (long) Math.pow(2, 32);
    private static final int BUCKETS = 26;

    @Override
    public String longestDupSubstring(String s) {
      int n = s.length();

      int l = 0;
      int r = n;

      int resultStart = 0;
      int resultEnd = 0;

      while (l < r) {
        int mid = l + (r - l) / 2;
        int[] dupSubstring = dupSubstring(s, mid);
        if (dupSubstring.length != 0) {
          // found a dupe substring, search for larger one
          resultStart = dupSubstring[0];
          resultEnd = dupSubstring[1];
          l = mid + 1;
        } else {
          // didn't find dupe substring, search for smaller one
          // TODO why `r = mid - 1` doesn't work?
          r = mid;
        }
      }
      return s.substring(resultStart, resultEnd);
    }

    // finds any dupe substring with the given length
    // O(n)
    private int[] dupSubstring(String s, int length) {
      int n = s.length();

      Set<Long> set = new HashSet<>();
      // hash will be computed based on character values and character positions
      // this is what is necessary to consider two sequences as equal
      // character values, i.e. get using s.charAt
      // character position, using place value, i.e. multiple of 26
      long rollingHash = 0;
      long maxPlaceValue = 1;

      // initial window
      for (int i = 0; i < length; i++) {
        rollingHash = (rollingHash * BUCKETS + (s.charAt(i) - BUCKETS)) % MOD;
        maxPlaceValue = (maxPlaceValue * BUCKETS) % MOD;
      }
      set.add(rollingHash);

      // sliding window
      for (int i = length; i < n; i++) {
        // first shift everything left by 26
        rollingHash = (rollingHash * BUCKETS) % MOD;
        // add end of new window
        rollingHash = (rollingHash + (s.charAt(i) - BUCKETS)) % MOD;
        // remove start of old window
        rollingHash =
            (rollingHash - (s.charAt(i - length) - BUCKETS) * maxPlaceValue % MOD + MOD) % MOD;
        if (!set.add(rollingHash)) {
          return new int[] {i - length + 1, i + 1};
        }
      }
      return new int[0];
    }
  }
}
