package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/task-scheduler>https://leetcode.com/problems/task-scheduler/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1) (store at most 26 in the queue/temp list)
 *
 * <p>Key idea: Make each loop iteration one cooldown period. Keep unique tasks in queue such that
 * remove at most once in each loop iteration such that cooldown period is not violated; also allows
 * adding back to queue to retrigger heapify after freqs updated.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P621TaskScheduler {

  public int leastInterval(char[] tasks, int n) {
    int time = 0;

    // count freqs
    int[] freqs = new int[26];
    for (char task : tasks) {
      freqs[task - 'A']++;
    }

    // favour execution of tasks with highest freq first, so can execute other tasks during their
    // cooldown periods (greedy)
    Comparator<Character> comparator = Comparator.comparingInt(c -> -freqs[c - 'A']);
    PriorityQueue<Character> priorityQueue = new PriorityQueue<>(comparator);

    // add unique tasks
    for (char task = 'A'; task <= 'Z'; task++) {
      if (freqs[task - 'A'] > 0) {
        priorityQueue.add(task);
      }
    }

    while (!priorityQueue.isEmpty()) {
      // (add 1 to include current execution)
      int cooldown = n + 1;

      // since we execute task with highest freq first its guaranteed that tasks executed towards
      // the end of the cooldown period would have the same number of tasks before them in the next
      // cooldown period, such that they dont violate the cooldown period

      // to add back to queue
      List<Character> temp = new ArrayList<>();

      // execute as many tasks as possible in time
      while (cooldown > 0 && !priorityQueue.isEmpty()) {
        char task = priorityQueue.remove();
        freqs[task - 'A']--;
        if (freqs[task - 'A'] > 0) {
          temp.add(task);
        }
        cooldown--;
        time++;
      }

      priorityQueue.addAll(temp);

      if (!priorityQueue.isEmpty()) {
        // run out remaining cooldown
        time += cooldown;
      }
    }
    return time;
  }
}
