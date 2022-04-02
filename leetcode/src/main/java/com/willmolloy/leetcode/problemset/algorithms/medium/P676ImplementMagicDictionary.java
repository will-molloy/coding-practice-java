package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/implement-magic-dictionary>https://leetcode.com/problems/implement-magic-dictionary/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: {@link #insert}: O(sum(w : words)), {@link #search}: O(w<sup>2</sup>) (only change
 * one character at a time, so it's not exponentially branching)
 *
 * <p>Space: O(sum(w : words)) (i.e. space of trie)
 *
 * <p>Key: Having separate method ({@link #continueSearch}) to continue the search once a character
 * had been changed.
 *
 * @see P208ImplementTrie
 * @see P211AddAndSearchWordDataStructureDesign
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P212WordSearch2
 * @see P720LongestWordInDictionary
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P1032StreamOfCharacters
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P676ImplementMagicDictionary {

  private Node root;

  /**
   * Build a dictionary through a list of words.
   *
   * @param dict list of words
   */
  public void buildDict(String[] dict) {
    this.root = new Node();
    for (String word : dict) {
      insert(word);
    }
  }

  private void insert(String word) {
    Node node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new Node();
      }
      node = node.children[c - 'a'];
    }
    node.isLeaf = true;
  }

  /**
   * Returns if there is any word in the trie that equals to the given word after modifying exactly
   * one character.
   *
   * @param the given word
   * @return {@code true} if there is any word in the trie that equals to the given word after
   *     modifying exactly one character
   */
  public boolean search(String word) {
    // try replacing each character
    for (int i = 0; i < word.length(); i++) {
      Node node = root;
      for (int j = 0; j < word.length(); j++) {
        if (i == j) {
          // replacing character at i
          for (char c = 'a'; c <= 'z'; c++) {
            if (c == word.charAt(i)) {
              continue;
            }
            Node next = node.children[c - 'a'];
            if (next != null) {
              if (continueSearch(word, i + 1, next)) {
                return true;
              }
            }
          }
        } else {
          // standard trie traversal
          Node next = node.children[word.charAt(j) - 'a'];
          if (next == null) {
            break;
          }
          node = next;
        }
      }
    }
    return false;
  }

  private boolean continueSearch(String word, int startI, Node node) {
    // standard trie traversal
    for (int i = startI; i < word.length(); i++) {
      Node next = node.children[word.charAt(i) - 'a'];
      if (next == null) {
        return false;
      }
      node = next;
    }
    return node.isLeaf;
  }

  // trie node
  private static class Node {
    private final Node[] children = new Node[26];

    private boolean isLeaf;
  }
}
