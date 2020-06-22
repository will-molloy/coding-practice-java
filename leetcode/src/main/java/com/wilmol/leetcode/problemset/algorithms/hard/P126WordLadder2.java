package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wilmol on 2020-03-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/word-ladder-ii>https://leetcode.com/problems/word-ladder-ii</a>
 *
 * <p>Key: Traverse 'paths' rather than 'nodes'
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P127WordLadder
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P129SumRootToLeafNumbers
 */
public interface P126WordLadder2 {

  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList);

  /**
   * Dfs solution; gets all sequences then filters the non smallest sequences. TLE on leetcode.
   *
   * <p>Runtime: O(n * n * m) (worst case process all words, branch algorithm used is O(n * m))
   *
   * <p>Extra space: O(n) (worst case recursion depth)
   */
  class Dfs implements P126WordLadder2 {

    // TODO maybe if more efficient branching algorithm is used (O(m)), DFS can pass leetcode?

    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      if (beginWord.equals(endWord)) {
        return Collections.singletonList(Collections.singletonList(beginWord));
      }
      List<List<String>> results =
          solve(beginWord, endWord, wordList, new LinkedHashSet<>(), new ArrayList<>());
      int min = results.stream().mapToInt(List::size).min().orElse(0);
      return results.stream().filter(list -> list.size() == min).collect(Collectors.toList());
    }

    // DFS
    private List<List<String>> solve(
        String word,
        String endWord,
        List<String> words,
        LinkedHashSet<String> temp,
        List<List<String>> results) {
      temp.add(word);
      if (word.equals(endWord)) {
        results.add(new ArrayList<>(temp));
        return results;
      }

      for (String w : words) {
        if (!temp.contains(w) && canTransform(w, word)) {
          solve(w, endWord, words, temp, results);
          // backtrack
          temp.remove(w);
        }
      }
      return results;
    }

    // O(m)
    private boolean canTransform(String s1, String s2) {
      int diffs = 0;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          diffs++;
          if (diffs == 2) {
            return false;
          }
        }
      }
      return true;
    }
  }

  /**
   * Bfs solution; builds up paths level by level.
   *
   * <p><b>NOTE</b> uses O(m) find neighbour/branch algorithm.
   *
   * <p>Runtime: O(n * m)
   *
   * <p>Extra space: O(n * n * m) (worst case queue size; could have n * (n * m sized) paths)
   */
  class Bfs implements P126WordLadder2 {

    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      if (beginWord.equals(endWord)) {
        return Collections.singletonList(Collections.singletonList(beginWord));
      }
      // use set for O(1) contains and remove
      HashSet<String> wordSet = new HashSet<>(wordList);

      ArrayList<List<String>> results = new ArrayList<>();

      // init queue of paths
      ArrayDeque<List<String>> queue = new ArrayDeque<>();
      queue.add(Collections.singletonList(beginWord));

      int level = 1;
      int minLevel = Integer.MAX_VALUE;

      Set<String> seen = new HashSet<>();

      while (!queue.isEmpty()) {
        List<String> path = queue.remove();
        if (path.size() > level) {
          // reached a new level (queue is FIFO, so must encounter paths in ascending size order)
          // remove seen words from word set, so they are not used on future levels, avoids cycles
          seen.forEach(wordSet::remove);
          seen.clear();
          if (path.size() > minLevel) {
            // level is not minimal, stop computing sequences
            break;
          } else {
            level = path.size();
          }
        }

        // branch current path
        // NOTE must do this O(26 * m) (i.e. O(m)) algorithm to find neighbours, else get TLE on lc
        // algorithm: one by one, change each character to 'a' through 'z' and check words set
        String last = path.get(path.size() - 1);
        for (int i = 0; i < last.length(); i++) {
          char[] temp = last.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            temp[i] = c;
            String w = String.valueOf(temp);
            if (wordSet.contains(w)) {
              // can extend path with 'w'
              List<String> newPath = new ArrayList<>(path);
              newPath.add(w);
              seen.add(w);
              if (w.equals(endWord)) {
                minLevel = level;
                results.add(newPath);
              } else {
                queue.add(newPath);
              }
            }
          }
        }
      }
      return results;
    }
  }
}
