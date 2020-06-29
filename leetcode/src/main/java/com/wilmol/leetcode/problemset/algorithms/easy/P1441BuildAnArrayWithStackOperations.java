package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/build-an-array-with-stack-operations>https://leetcode.com/problems/build-an-array-with-stack-operations/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: The array is just the list ([1, n]) with gaps, so two pointer approach.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1441BuildAnArrayWithStackOperations {

  public List<String> buildArray(int[] target, int n) {
    List<String> result = new ArrayList<>();

    // pointer over 'target'
    int i = 0;
    // pointer over 'list = [1, n]'
    int curr = 1;
    while (i < target.length) {
      if (target[i] == curr) {
        result.add("Push");
        i++;
      } else {
        result.add("Push");
        result.add("Pop");
      }
      curr++;
    }
    return result;
  }
}
