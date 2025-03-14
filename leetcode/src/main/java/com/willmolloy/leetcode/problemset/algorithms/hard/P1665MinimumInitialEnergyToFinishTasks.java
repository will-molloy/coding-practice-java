package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks>https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Greedy. Complete tasks with highest 'savings' (minimum - actual) first.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1665MinimumInitialEnergyToFinishTasks {

  // tasks = array of {actual, minimum} energy
  public int minimumEffort(int[][] tasks) {

    // answer is in [sum(task[0]), sum(task[1])]
    // want to meet all tasks with minimum extra amount left at the end

    // think of (minimum - actual) as energy saved - i.e. energy we needed but didn't use
    // want to do tasks with highest savings first as it means more is left for remaining tasks

    // sort by energy savings (ascending)
    // we will build up the result (i.e. start with last task), determining how much energy needed
    Arrays.sort(tasks, Comparator.comparingInt(a -> a[1] - a[0]));

    int energyNeeded = 0;
    for (int[] task : tasks) {
      // floor by task[1] - either we already have enough with task[0] + existing energy or we need
      // an extra amount to meet task[1]
      energyNeeded = Math.max(energyNeeded + task[0], task[1]);
    }
    return energyNeeded;
  }
}
