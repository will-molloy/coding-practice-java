package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/word-subsets>https://leetcode.com/problems/word-subsets/</a>
 *
 * <p>Runtime: O(a + b)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Combine b freqs into one, using {@code max} count of each letter.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P916WordSubsets {

  public List<String> wordSubsets(String[] as, String[] bs) {
    List<String> result = new ArrayList<>();

    int[] combinedBFreq = new int[26];
    for (String b : bs) {
      int[] bFreq = freq(b);

      for (int i = 0; i < 26; i++) {
        combinedBFreq[i] = Math.max(combinedBFreq[i], bFreq[i]);
      }
    }

    for (String a : as) {
      int[] aFreq = freq(a);

      if (IntStream.range(0, 26).allMatch(i -> aFreq[i] >= combinedBFreq[i])) {
        result.add(a);
      }
    }
    return result;
  }

  private int[] freq(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
      freq[c - 'a']++;
    }
    return freq;
  }
}
