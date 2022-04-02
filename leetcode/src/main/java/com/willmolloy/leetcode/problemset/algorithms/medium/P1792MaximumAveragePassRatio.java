package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-average-pass-ratio>https://leetcode.com/problems/maximum-average-pass-ratio/</a>
 *
 * <p>Runtime: O({@code extraStudents} * log({@code classes}))
 *
 * <p>Extra memory: O({@code classes})
 *
 * <p>Key: Add extra student to the class that'll have the largest increase in pass ratio. Use
 * priority queue to get that class.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1792MaximumAveragePassRatio {

  public double maxAverageRatio(int[][] classes, int extraStudents) {
    // make top of priority queue the class that'll have the largest increase in pass ratio
    Comparator<int[]> comparator =
        Comparator.comparingDouble(
                (int[] c) -> {
                  double now = ratio(c);
                  double next = ratio(addStudent(c));
                  return next - now;
                })
            .reversed();
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);

    for (int[] c : classes) {
      priorityQueue.add(c);
    }

    while (extraStudents-- > 0) {
      int[] c = priorityQueue.remove();
      priorityQueue.add(addStudent(c));
    }

    return priorityQueue.stream().mapToDouble(this::ratio).average().orElseThrow();
  }

  private double ratio(int[] c) {
    return (double) c[0] / c[1];
  }

  private int[] addStudent(int[] c) {
    return new int[] {c[0] + 1, c[1] + 1};
  }
}
