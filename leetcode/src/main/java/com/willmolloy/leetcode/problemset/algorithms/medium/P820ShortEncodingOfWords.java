package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * <a
 * href=https://leetcode.com/problems/short-encoding-of-words>https://leetcode.com/problems/short-encoding-of-words/</a>
 *
 * <p>Runtime: O(sum(word : words)) - i.e. total number of characters in words array
 *
 * <p>Extra memory: O(sum(word : words))
 *
 * <p>Key idea: Want to exclude words which are (proper) suffixes of other words. Trie is efficient
 * data structure for this.
 *
 * @see P208ImplementTrie
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P820ShortEncodingOfWords {

  public int minimumLengthEncoding(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;
      // trie removes words which are proper prefixes of other words
      // so inserting reversed word so trie removes words which are suffixes of other words
      for (int i = word.length() - 1; i >= 0; i--) {
        node = node.children.computeIfAbsent(word.charAt(i), k -> new TrieNode());
      }
    }

    // answer is size of all words in trie + number of words in trie
    int answer = 0;
    Queue<TrieNode> queue = new ArrayDeque<>();
    queue.add(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TrieNode node = queue.remove();
        if (node.children.isEmpty()) {
          answer += depth + 1;
        }
        queue.addAll(node.children.values());
      }
      depth++;
    }
    return answer;
  }

  private static final class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
  }
}
