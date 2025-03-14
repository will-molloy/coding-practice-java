package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/next-greater-element-iii>https://leetcode.com/problems/next-greater-element-iii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Answer is the next permutation of n.
 *
 * @see P31NextPermutation
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P556NextGreaterElement3 {

  private final P31NextPermutation p31NextPermutation = new P31NextPermutation();

  public int nextGreaterElement(int n) {
    List<Integer> list = new ArrayList<>();
    int copy = n;
    while (copy > 0) {
      list.add(copy % 10);
      copy /= 10;
    }

    int[] a = list.stream().mapToInt(i -> i).toArray();

    reverse(a, 0);
    p31NextPermutation.nextPermutation(a);

    long ans = 0;
    for (int i : a) {
      ans *= 10;
      ans += i;
    }
    return ans <= Integer.MAX_VALUE && ans > n ? (int) ans : -1;
  }

  /** Swaps x[a] with x[b]. */
  private void swap(int[] x, int a, int b) {
    int temp = x[a];
    x[a] = x[b];
    x[b] = temp;
  }

  /** Reverses elements in x[] from fromIndex onwards. */
  private void reverse(int[] x, int fromIndex) {
    int i = x.length - 1;
    int j = fromIndex;
    while (i > j) {
      swap(x, i, j);
      i -= 1;
      j += 1;
    }
  }
}
