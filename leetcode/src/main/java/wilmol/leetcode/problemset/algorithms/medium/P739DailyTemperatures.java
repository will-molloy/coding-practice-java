package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-05-19.
 *
 * <p><a
 * href=https://leetcode.com/problems/daily-temperatures>https://leetcode.com/problems/daily-temperatures/</a>
 *
 * <p>Runtime: O(n) (inner loop is constant since temps are in fixed range [30, 100])
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Iterate in reverse so can store day of each future temperature.
 *
 * @see P901OnlineStockSpan
 */
class P739DailyTemperatures {

  // TODO smarter solution with stack
  //  see https://leetcode.com/problems/daily-temperatures/solution/

  public int[] dailyTemperatures(int[] temps) {
    int n = temps.length;

    int[] result = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);

    // holds earliest day that a temperature occurs (map)
    int[] earliestDayForTemp = new int[71];
    Arrays.fill(earliestDayForTemp, Integer.MAX_VALUE);

    // iterate in reverse because result depends on future days
    for (int day = n - 1; day >= 0; day--) {
      int temp = temps[day];

      // check if future day is recorded for larger temps
      for (int largerTemp = temp + 1; largerTemp <= 100; largerTemp++) {
        if (earliestDayForTemp[largerTemp - 30] == Integer.MAX_VALUE) {
          continue;
        }
        // want the earliest day for a larger temp
        result[day] = Math.min(result[day], earliestDayForTemp[largerTemp - 30] - day);
      }
      result[day] = result[day] == Integer.MAX_VALUE ? 0 : result[day];
      earliestDayForTemp[temp - 30] = day;
    }

    return result;
  }
}
