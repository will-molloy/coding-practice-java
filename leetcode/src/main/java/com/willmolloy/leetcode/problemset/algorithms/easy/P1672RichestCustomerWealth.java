package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/richest-customer-wealth>https://leetcode.com/problems/richest-customer-wealth/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Sum each account and get max.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1672RichestCustomerWealth {

  public int maximumWealth(int[][] accounts) {
    return Arrays.stream(accounts)
        .mapToInt(account -> Arrays.stream(account).sum())
        .max()
        .orElseThrow();
  }
}
