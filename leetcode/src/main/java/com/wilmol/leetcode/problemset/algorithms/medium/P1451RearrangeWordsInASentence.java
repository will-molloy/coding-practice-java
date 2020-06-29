package com.wilmol.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/rearrange-words-in-a-sentence>https://leetcode.com/problems/rearrange-words-in-a-sentence/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Custom comparator to sort the words.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@SuppressFBWarnings("DM_CONVERT_CASE")
class P1451RearrangeWordsInASentence {

  public String arrangeWords(String text) {
    String[] words = text.split(" ");
    Arrays.sort(words, Comparator.comparingInt(s -> s.length()));
    String collect =
        Arrays.stream(words).map(s -> s.toLowerCase()).collect(Collectors.joining(" "));
    return Character.toUpperCase(collect.charAt(0)) + collect.substring(1);
  }
}
