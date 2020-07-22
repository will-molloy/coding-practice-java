package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/daily-temperatures>https://leetcode.com/problems/daily-temperatures/</a>
 *
 * <p>Key: Iterate in reverse so can store day of each future temp.
 *
 * @see P901OnlineStockSpan
 * @see P1019NextGreaterNodeInLinkedList
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P739DailyTemperatures {

  int[] dailyTemperatures(int[] temps);

  /**
   * Solution which uses a map to track earliest day of warmer temp.
   *
   * <p>Runtime: O(n) (inner loop is O(1) since temps are in fixed range [30, 100])
   *
   * <p>Extra space: O(1) (fixed sized array/map)
   */
  class Map implements P739DailyTemperatures {

    @Override
    public int[] dailyTemperatures(int[] temps) {
      int n = temps.length;

      int[] result = new int[n];
      Arrays.fill(result, Integer.MAX_VALUE);

      // holds earliest day that a temp occurs (map)
      int[] earliestDayForTemp = new int[71];
      Arrays.fill(earliestDayForTemp, Integer.MAX_VALUE);

      // iterate in reverse because result depends on future days
      for (int day = n - 1; day >= 0; day--) {
        int temp = temps[day];

        // check if future day is recorded for warmer temps
        for (int warmerTemp = temp + 1; warmerTemp <= 100; warmerTemp++) {
          if (earliestDayForTemp[warmerTemp - 30] == Integer.MAX_VALUE) {
            continue;
          }
          // want the earliest day for a warmer temp
          result[day] = Math.min(result[day], earliestDayForTemp[warmerTemp - 30] - day);
        }
        result[day] = result[day] == Integer.MAX_VALUE ? 0 : result[day];
        earliestDayForTemp[temp - 30] = day;
      }

      return result;
    }
  }

  /**
   * Solution which uses a stack to track day of warmer temp.
   *
   * <p>Runtime: O(n) (amortised analysis; only pop an element at most once, so inner loop is O(1))
   *
   * <p>Extra space: O(n)
   */
  class Stack implements P739DailyTemperatures {

    @Override
    public int[] dailyTemperatures(int[] temps) {
      int n = temps.length;

      int[] result = new int[n];

      // store index of warmer temp
      Deque<Integer> stack = new ArrayDeque<>();

      // iterate in reverse because result depends on future days
      for (int day = n - 1; day >= 0; day--) {
        while (!stack.isEmpty() && temps[day] >= temps[stack.peek()]) {
          // remove smaller temps as earlier days won't depend on them
          // (avoids need to scan the list each iteration)
          stack.pop();
        }
        result[day] = stack.isEmpty() ? 0 : stack.peek() - day;
        stack.push(day);
      }

      return result;
    }
  }
}
