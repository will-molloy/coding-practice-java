package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-cost-for-tickets>https://leetcode.com/problems/minimum-cost-for-tickets/</a>
 *
 * <p>Runtime: O(n) (search range is constant)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Recurrence is comparing how we can cover the current day; day ticket vs. week ticket
 * (ending today) vs. month ticket (ending today).
 *
 * <p>Tricky part is figuring out what the result was 'x' days ago since the array can be sparse. So
 * need a search routine.
 *
 * <p>Search routine can be optimised to constant time since in the worst case its 30 elements back.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P983MinimumCostForTickets {

  public int mincostTickets(int[] days, int[] costs) {
    int n = days.length;

    // dp[i] = total cost considering days[0, i)
    // (need to lead with 0 so don't get IOOB)
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      // dp[] is ahead of days[] by 1 (dp[i] ~ days[i - 1])
      // so the search result will implicitly be 1 index back
      // want 1 index back since the exact index already includes a ticket to cover that day
      // e.g. picking ticket for days [1, 7] would want to add to total from day 0 not day 1

      // day covers (day-1, day] = [day, day]
      int day = dp[i - 1] + costs[0];
      // week covers (day-7, day] = [day-6, day]
      int week = dp[search(days, days[i - 1] - 6, Math.max(0, i - 7), i)] + costs[1];
      // month covers (day-30, day] = [day-29, day]
      int month = dp[search(days, days[i - 1] - 29, Math.max(0, i - 30), i)] + costs[2];
      dp[i] = min(day, week, month);
    }

    return dp[n];
  }

  private int search(int[] days, int target, int from, int to) {
    int i = Arrays.binarySearch(days, from, to, target);
    return i >= 0 ? i : ~i;
  }

  private int min(int... ints) {
    return Arrays.stream(ints).min().getAsInt();
  }
}
