package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

/**
 * <a href=https://leetcode.com/problems/word-ladder>https://leetcode.com/problems/word-ladder</a>
 *
 * <p>Runtime: O(n * n * m) (worst case process all words, branch algorithm used is O(n * m))
 *
 * <p>Space: O(n * m) (queue/set size)
 *
 * <p>Key idea: BFS; in particular how the branching/neighbour traversing works
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P126WordLadder2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P127WordLadder {

  // TODO bidirectional BFS: https://leetcode.com/problems/word-ladder/solution/

  public int ladderLength(String beginWord, String endWord, List<String> words) {
    if (beginWord.equals(endWord)) {
      return 1;
    }

    HashSet<String> seen = new HashSet<>();
    ArrayDeque<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    int depth = 1;

    // BFS with dupe detection
    // Gets all possible words in next level, so once endWord is found, must be shortest path length
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        String word = queue.remove();
        if (word.equals(endWord)) {
          return depth;
        }
        for (String potentialNeighbour : words) {
          // TODO instead of checking canTransform, can generate all transformations and check if
          //  exists in word set O(26 * m) rather than O(n * m), then overall would have O(n * m)
          if (canTransform(word, potentialNeighbour) && seen.add(potentialNeighbour)) {
            queue.add(potentialNeighbour);
          }
        }
      }
      depth++;
    }
    return 0;
  }

  // can transform if at most one character changes
  // O(m)
  private boolean canTransform(String s1, String s2) {
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (diff == 1) {
          return false;
        }
        diff++;
      }
    }
    return true;
  }
}
