package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/word-pattern>https://leetcode.com/problems/word-pattern/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Map tracking [word -> letter] and vice versa (BiMap).
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P290WordPattern {

  public boolean wordPattern(String pattern, String str) {
    char[] letters = pattern.toCharArray();
    String[] words = str.split(" ");

    if (letters.length != words.length) {
      return false;
    }

    Map<Character, String> letterToWord = new HashMap<>();
    Map<String, Character> wordToLetter = new HashMap<>();

    for (int i = 0; i < letters.length; i++) {
      char letter = letters[i];
      String word = words[i];

      String mappedWord = letterToWord.get(letter);
      if (mappedWord == null) {
        letterToWord.put(letter, word);
      } else if (!mappedWord.equals(word)) {
        return false;
      }

      Character mappedLetter = wordToLetter.get(word);
      if (mappedLetter == null) {
        wordToLetter.put(word, letter);
      } else if (!mappedLetter.equals(letter)) {
        return false;
      }
    }

    return true;
  }
}
