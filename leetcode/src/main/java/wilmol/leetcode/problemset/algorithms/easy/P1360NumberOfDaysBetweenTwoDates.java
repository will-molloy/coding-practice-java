package wilmol.leetcode.problemset.algorithms.easy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by wilmol on 2020-05-09.
 *
 * <p><a
 * href=https://leetcode.com/problems/number-of-days-between-two-dates>https://leetcode.com/problems/number-of-days-between-two-dates/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: {@link java.time} API.
 */
class P1360NumberOfDaysBetweenTwoDates {

  public int daysBetweenDates(String date1, String date2) {
    // it converts to epoch and back so O(1)
    return (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
  }
}
