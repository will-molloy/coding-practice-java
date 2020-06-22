package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * Created by wilmol on 2020-02-19.
 *
 * <p><a
 * href=https://leetcode.com/problems/n-queens-ii>https://leetcode.com/problems/n-queens-ii</a>
 *
 * <p>Key: copy N-Queens-I
 *
 * @see P51NQueens
 */
class P52NQueens2 {

  private final P51NQueens delegate = new P51NQueens();

  public int totalNQueens(int n) {
    return delegate.solveNQueens(n).size();
  }
}
