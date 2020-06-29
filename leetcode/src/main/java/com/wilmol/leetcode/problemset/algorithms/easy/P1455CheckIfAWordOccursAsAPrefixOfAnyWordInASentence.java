package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence>https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: {@link String#startsWith} method.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1455CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

  public int isPrefixOfWord(String sentence, String searchWord) {

    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (words[i].startsWith(searchWord)) {
        return i + 1;
      }
    }
    return -1;
  }
}
