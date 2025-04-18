package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/check-array-formation-through-concatenation>https://leetcode.com/problems/check-array-formation-through-concatenation/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: The elements are distinct so you can remove pieces greedily (won't have situation
 * like arr = [1, 2, 1], pieces = [[1], [1, 2]]).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1640CheckArrayFormationThroughConcatenation {

  public boolean canFormArray(int[] arr, int[][] pieces) {

    // pieces flattened length == arr.length
    // both have distinct elements
    // so check pieces covers every element in arr

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], i);
    }

    // check piece covers some part of arr (a contiguous subarray)
    for (int[] piece : pieces) {
      Integer index = map.get(piece[0]);
      if (index == null) {
        return false;
      }
      map.remove(piece[0]);

      for (int i = 1; i < piece.length; i++) {
        Integer nextIndex = map.get(piece[i]);
        if (nextIndex == null || nextIndex != index + 1) {
          return false;
        }
        map.remove(piece[i]);
        index = nextIndex;
      }
    }
    return true;
  }
}
