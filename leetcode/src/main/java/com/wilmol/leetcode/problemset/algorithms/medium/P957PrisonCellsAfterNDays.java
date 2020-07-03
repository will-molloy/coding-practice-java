package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/prison-cells-after-n-days>https://leetcode.com/problems/prison-cells-after-n-days/</a>
 *
 * <p>Runtime: O(1) apparently max size of {@code states} is 14. I.e. it repeats after at most 14
 * state transitions. So doesn't scale with n.
 *
 * <p>Extra memory: O(1) for same reasons
 *
 * <p>Key: Max n is 1e9 but number of possible states is 2<sup>6</sup> (64) so the state must repeat
 * for large enough n.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P957PrisonCellsAfterNDays {

  public int[] prisonAfterNDays(int[] cells, int n) {
    List<int[]> states = new ArrayList<>();

    for (int day = 0; day < n; day++) {
      int[] next = next(cells);
      // edge case, can't compare with day 0 as that may not repeat (since cell 0 and cell 7 will
      // never be occupied again)
      // therefore only start the cycle check after day 1
      if (!states.isEmpty() && Arrays.equals(states.get(0), next)) {
        // repeats every 'states.size()' days, so dayN = N % states.size()
        // (subtract 1 cause day 0 is excluded)
        return states.get((n - 1) % states.size());
      } else {
        states.add(next);
        cells = next;
      }
    }
    return cells;
  }

  private int[] next(int[] cells) {
    int[] next = new int[8];
    for (int i = 1; i <= 6; i++) {
      next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
    }
    return next;
  }
}
