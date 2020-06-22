package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time>https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Count how many meet the condition, the elements don't influence each other.
 */
class P1450NumberOfStudentsDoingHomeworkAtAGivenTime {

  public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int n = startTime.length;

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
        count++;
      }
    }
    return count;
  }
}
