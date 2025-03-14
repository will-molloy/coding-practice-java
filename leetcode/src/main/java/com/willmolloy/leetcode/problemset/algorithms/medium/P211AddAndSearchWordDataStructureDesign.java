package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/add-and-search-word-data-structure-design>https://leetcode.com/problems/add-and-search-word-data-structure-design/</a>
 *
 * <p>Runtime: O(n) {@code addWord} O(26<sup>n</sup>) {@code search}
 *
 * <p>Extra memory: O(sum(word: {@code addWord} calls)) (i.e. Trie space)
 *
 * <p>Key idea: Trie.
 *
 * @see P208ImplementTrie
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P212WordSearch2
 * @see P676ImplementMagicDictionary
 * @see P720LongestWordInDictionary
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P1032StreamOfCharacters
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P211AddAndSearchWordDataStructureDesign {

  /** Word dictionary. */
  static class WordDictionary {

    private final Node root;

    /** Initialize your data structure here. */
    WordDictionary() {
      root = new Node();
    }

    /**
     * Adds a word into the data structure.
     *
     * @param word the word to add
     */
    public void addWord(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        Node next = node.child[c - 'a'];
        if (next == null) {
          next = new Node();
          node.child[c - 'a'] = next;
        }
        node = next;
      }
      node.isLeaf = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     *
     * @param word the word to search
     * @return if the word is in the data structure
     */
    public boolean search(String word) {
      return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int i, Node node) {
      if (node == null) {
        return false;
      }
      if (i == word.length) {
        return node.isLeaf;
      }
      if (word[i] == '.') {
        return IntStream.range(0, 26).anyMatch(j -> search(word, i + 1, node.child[j]));
      } else {
        return search(word, i + 1, node.child[word[i] - 'a']);
      }
    }

    /** Trie node. */
    private static final class Node {
      final Node[] child = new Node[26];
      boolean isLeaf;
    }
  }
}
