package wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=19>https://projecteuler.net/problem=19</a>
 *
 * <p>Runtime: O(n)
 */
class P19CountingSundays {

  public int onFirstOfMonth(LocalDateTime from, LocalDateTime to) {
    Preconditions.checkArgument(from.getDayOfMonth() == 1);

    if (from.isAfter(to)) {
      return 0;
    }
    final int count;
    if (from.getDayOfWeek() == DayOfWeek.SUNDAY) {
      count = 1;
    } else {
      count = 0;
    }
    return count + onFirstOfMonth(from.plusMonths(1), to);
  }
}
