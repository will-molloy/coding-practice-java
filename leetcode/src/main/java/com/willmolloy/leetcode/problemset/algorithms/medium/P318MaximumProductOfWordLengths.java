package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-product-of-word-lengths>https://leetcode.com/problems/maximum-product-of-word-lengths/</a>
 *
 * <p>Runtime: O(n<sup>2</sup> + s) - n = number of words, s = word length
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Preprocess words into set/bit mask to make the comparison O(1), reducing overall
 * runtime from O(n<sup>2</sup> * s) (or even O(n<sup>2</sup> * s<sup>2</sup>)) to O(n<sup>2</sup>).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P318MaximumProductOfWordLengths {

  int maxProduct(String[] words);

  /** Solution which preprocesses words into a {@code Set<Character>}. */
  final class LetterSet implements P318MaximumProductOfWordLengths {

    @Override
    public int maxProduct(String[] words) {
      Map<String, Set<Character>> map = new HashMap<>();
      for (String word : words) {
        map.put(word, letterSet(word));
      }

      int max = 0;
      for (String w1 : words) {
        for (String w2 : words) {
          if (Collections.disjoint(map.get(w1), map.get(w2))) {
            max = Math.max(max, w1.length() * w2.length());
          }
        }
      }
      return max;
    }

    private Set<Character> letterSet(String word) {
      Set<Character> set = new HashSet<>();
      for (char c : word.toCharArray()) {
        set.add(c);
      }
      return set;
    }
  }

  /** Solution which preprocesses words into a bit mask. */
  final class LetterBitMask implements P318MaximumProductOfWordLengths {

    @Override
    public int maxProduct(String[] words) {
      int n = words.length;

      int[] masks = new int[n];
      for (int i = 0; i < n; i++) {
        masks[i] = letterMask(words[i]);
      }

      int max = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if ((masks[i] & masks[j]) == 0) {
            max = Math.max(max, words[i].length() * words[j].length());
          }
        }
      }
      return max;
    }

    private int letterMask(String word) {
      int mask = 0;
      for (char c : word.toCharArray()) {
        mask |= 1 << (c - 'a');
      }
      return mask;
    }
  }
}
