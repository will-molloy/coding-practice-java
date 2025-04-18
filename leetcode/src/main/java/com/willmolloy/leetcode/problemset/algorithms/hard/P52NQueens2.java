package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a href=https://leetcode.com/problems/n-queens-ii>https://leetcode.com/problems/n-queens-ii</a>
 *
 * <p>Key idea: copy N-Queens-I
 *
 * @see P51NQueens
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P52NQueens2 {

  private final P51NQueens delegate = new P51NQueens();

  public int totalNQueens(int n) {
    return delegate.solveNQueens(n).size();
  }
}
