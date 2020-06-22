package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2020-04-27.
 *
 * <p><a
 * href=https://leetcode.com/problems/diagonal-traverse-ii>https://leetcode.com/problems/diagonal-traverse-ii/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(nums) (i.e. total number of elements in nums)
 *
 * <p>Space: O(nums) (i.e. total number of elements in nums)
 *
 * <p>Key: Adding {@code row} and {@code col} produces the diagonal index:
 *
 * <p><img src="https://i.imgur.com/MRDn9hS.png" />
 *
 * <p>Simulating the walk (i.e. how {@link P498DiagonalTraverse.SimulateWalk} works) produces TLE
 * due to iterating over 'holes' in the matrix, so need to use this transformation solution.
 *
 * @see P498DiagonalTraverse
 */
class P1424DiagonalTraverse2 {

  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    int size = 0;

    // build list of diagonals
    // use array list because size is unknown due to holes in grid
    List<List<Integer>> diagonals = new ArrayList<>();

    // diagonal index of some element at (row, col) is row + col

    for (int row = 0; row < nums.size(); row++) {
      for (int col = 0; col < nums.get(row).size(); col++) {
        int diagonalIndex = row + col;
        if (diagonalIndex >= diagonals.size()) {
          diagonals.add(new ArrayList<>());
        }
        // we are iterating rows in ascending order
        // therefore see end of diagonal first
        // therefore need to reverse the diagonal, doing this implicitly by adding to front of list
        diagonals.get(diagonalIndex).add(0, nums.get(row).get(col));
        size++;
      }
    }

    // flatten into result array
    int[] result = new int[size];
    int i = 0;
    for (List<Integer> list : diagonals) {
      for (int e : list) {
        result[i++] = e;
      }
    }
    return result;
  }
}
