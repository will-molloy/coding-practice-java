package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/global-and-local-inversions>https://leetcode.com/problems/global-and-local-inversions/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: All local inversions are global inversions, so if any inversion is global but not
 * local, return {@code false}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P775GlobalAndLocalInversions {

  public boolean isIdealPermutation(int[] a) {
    // original array is [0, n)

    // global inversion: element moved from its original position
    // local inversion: element moved from its original position at most 1 position

    // all local inversions are global inversions

    // so for equal number of local inversions and global inversions there can't be any global
    // inversions which are not also local inversions

    // in other words, an element a[i] can't be moved more than 1 position

    return IntStream.range(0, a.length)
        .map(i -> a[i] - i)
        .allMatch(moved -> moved >= -1 && moved <= 1);
  }
}
