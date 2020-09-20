package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/word-search-ii>https://leetcode.com/problems/word-search-ii/</a>
 *
 * <p>Runtime: O(board * words) - i.e. traverse trie for every cell in board
 *
 * <p>Extra memory: O(board + words) - i.e. dfs stack space + trie space
 *
 * <p>Key: Traverse board and trie (built from word set) in sync. This way when we find a word we
 * also find all its prefixes (simply how a Trie (prefix tree) works).
 *
 * @see P37SudokuSolver
 * @see P51NQueens
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P79WordSearch
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P208ImplementTrie
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P211AddAndSearchWordDataStructureDesign
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P676ImplementMagicDictionary
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P720LongestWordInDictionary
 * @see P980UniquePaths3
 * @see P1032StreamOfCharacters
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P212WordSearch2 {

  public List<String> findWords(char[][] board, String[] words) {
    Node trieRoot = buildTrie(words);
    List<String> result = new ArrayList<>();
    // start DFS from every cell
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        dfs(board, trieRoot, row, col, result);
      }
    }
    return result;
  }

  private Node buildTrie(String[] words) {
    Node root = new Node();
    for (String word : words) {
      // insert word
      Node node = root;
      for (char c : word.toCharArray()) {
        Node next = node.children[c - 'a'];
        if (next == null) {
          next = new Node();
          node.children[c - 'a'] = next;
        }
        node = next;
      }
      node.word = word;
    }
    return root;
  }

  // dfs around the board while traversing the trie in sync
  private void dfs(char[][] board, Node node, int row, int col, List<String> result) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      // out of bounds
      return;
    }
    char c = board[row][col];
    if (c == ' ') {
      // already visited
      return;
    }
    Node next = node.children[c - 'a'];
    if (next == null) {
      // reached end of trie
      // i.e. path through the board doesn't represent a word in the word set
      return;
    }

    if (next.word != null) {
      // found a word
      result.add(next.word);
      // clear so don't get duplicates
      next.word = null;
    }

    // mark used
    board[row][col] = ' ';
    // traverse
    dfs(board, next, row + 1, col, result);
    dfs(board, next, row - 1, col, result);
    dfs(board, next, row, col + 1, result);
    dfs(board, next, row, col - 1, result);
    // back track
    board[row][col] = c;
  }

  /** Trie node. */
  private static class Node {
    Node[] children = new Node[26];
    String word;
  }
}
