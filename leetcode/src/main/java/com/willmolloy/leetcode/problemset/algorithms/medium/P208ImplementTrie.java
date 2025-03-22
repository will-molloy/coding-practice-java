package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <a
 * href=https://leetcode.com/problems/implement-trie-prefix-tree>https://leetcode.com/problems/implement-trie-prefix-tree/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Key idea: Trie behaves like an n-ary tree. All traversals are DFS. {@code isLeaf} field is
 * crucial.
 *
 * @see P211AddAndSearchWordDataStructureDesign
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P212WordSearch2
 * @see P676ImplementMagicDictionary
 * @see P720LongestWordInDictionary
 * @see P820ShortEncodingOfWords
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P1032StreamOfCharacters
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P208ImplementTrie {

  /** Trie node. */
  private static class Node {
    // can use Node[26] array too
    private final Map<Character, Node> children = new HashMap<>();

    // true if this node is a leaf
    // needed because may have words as prefixes of other words e.g. fire and firetruck
    private boolean isLeaf;
  }

  /** Trie (prefix tree) data structure. */
  static class Trie {
    private final Node root = new Node();

    /**
     * Inserts a word into the trie.
     *
     * @param word word to insert
     */
    // O(word)
    public void insert(String word) {
      Node node = root;

      // create path for each letter in "word" from the root
      for (char c : word.toCharArray()) {
        node = node.children.computeIfAbsent(c, k -> new Node());
      }

      // mark final node as leaf even if it has children
      // needed because may have words as prefixes of other words e.g. fire and firetruck
      node.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     *
     * @param word the word
     * @return {@code true} if the word is in the trie
     */
    // O(word)
    public boolean search(String word) {
      // check there is a path for "word" that ends with a leaf node
      return traverse(word).map(node -> node.isLeaf).orElse(false);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     *
     * @param prefix the given prefix
     * @return {@code true} if there is any word in the trie that starts with the given prefix
     */
    // O(prefix)
    public boolean startsWith(String prefix) {
      // check there is a path for "word" doesn't necessarily have to end with a leaf
      return traverse(prefix).isPresent();
    }

    // O(path)
    private Optional<Node> traverse(String path) {
      Node node = root;
      for (char c : path.toCharArray()) {
        Node child = node.children.get(c);
        if (child == null) {
          return Optional.empty();
        }
        node = child;
      }
      return Optional.of(node);
    }
  }
}
