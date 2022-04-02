package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/iterator-for-combination>https://leetcode.com/problems/iterator-for-combination/</a>
 *
 * <p>Runtime: O(n<sup>k</sup>), n = {@code characters.length()}, k = {@code combinationLength}; DFS
 * depth {@code k}, branch factor {@code n} (ignores short circuit)
 *
 * <p>Extra memory: O((n - k)!) (pre-compute, so hold all combinations in memory) TODO correct?
 *
 * <p>Key: Backtracking, provide starting index to next DFS frame so get next combinations in
 * lexicographical order (otherwise get permutations).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1286IteratorForCombination {

  /** CombinationIterator. */
  static class CombinationIterator {

    private final Iterator<String> iterator;

    CombinationIterator(String characters, int combinationLength) {
      List<String> result = new ArrayList<>();
      dfs(result, characters, combinationLength, new StringBuilder(), 0);
      iterator = result.iterator();
    }

    private void dfs(
        List<String> result,
        String characters,
        int combinationLength,
        StringBuilder temp,
        int startI) {
      if (temp.length() == combinationLength) {
        result.add(temp.toString());
        return;
      }

      for (int i = startI; i < characters.length(); i++) {
        temp.append(characters.charAt(i));
        dfs(result, characters, combinationLength, temp, i + 1);
        temp.deleteCharAt(temp.length() - 1);
      }
    }

    public String next() {
      return iterator.next();
    }

    public boolean hasNext() {
      return iterator.hasNext();
    }
  }
}
