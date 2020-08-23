package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/stream-of-characters>https://leetcode.com/problems/stream-of-characters/</a>
 *
 * <p>Runtime: O(sum(w : words)) for {@code StreamChecker} constructor, O(max(w : words)) for {@code
 * query}
 *
 * <p>Extra memory: O(sum(w : words)) + {@code query} calls
 *
 * <p>Key: Insert reversed words into the Trie such that you can search the stream in reverse order
 * (newest to oldest rather than oldest to newest). This makes the search more efficient since it
 * can continue from the previous k.
 *
 * <p>E.g. without reversal searches for {@code stream = abcd} are:
 *
 * <ol>
 *   <li>{@code d}
 *   <li>{@code cd}
 *   <li>{@code bcd}
 *   <li>{@code abcd}
 * </ol>
 *
 * <p>I.e. must restart the search for each k.
 *
 * <p>With reversal searches for {@code stream = abcd} are:
 *
 * <ol>
 *   <li>{@code d}
 *   <li>{@code dc}
 *   <li>{@code dcb}
 *   <li>{@code dcba}
 * </ol>
 *
 * <p>I.e. can just search for any prefix of {@code dcba}.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P208ImplementTrie
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P211AddAndSearchWordDataStructureDesign
 * @see P212WordSearch2
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P676ImplementMagicDictionary
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P720LongestWordInDictionary
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1032StreamOfCharacters {

  /** {@code StreamChecker} class. */
  static class StreamChecker {

    private final Node root;

    // can optimise space by only storing last max_len(w : words) characters (i.e. trie height)
    private String stream = "";

    StreamChecker(String[] words) {
      root = new Node();

      for (String word : words) {
        // insert word into trie
        Node node = root;
        // reverse
        for (int i = word.length() - 1; i >= 0; i--) {
          char c = word.charAt(i);
          Node next = node.child[c - 'a'];
          if (next == null) {
            next = new Node();
            node.child[c - 'a'] = next;
          }
          node = next;
        }
        node.leaf = true;
      }
    }

    public boolean query(char letter) {
      stream += letter;

      Node node = root;
      // reverse
      for (int i = stream.length() - 1; i >= 0; i--) {
        char c = stream.charAt(i);
        Node next = node.child[c - 'a'];
        if (next == null) {
          return false;
        }
        if (next.leaf) {
          return true;
        }
        node = next;
      }
      return false;
    }

    /** Trie Node. */
    static class Node {
      Node[] child = new Node[26];
      boolean leaf;
    }
  }
}
