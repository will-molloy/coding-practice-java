package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-09. */
class P1360NumberOfDaysBetweenTwoDatesTest {

  private final P1360NumberOfDaysBetweenTwoDates p1360 = new P1360NumberOfDaysBetweenTwoDates();

  @Test
  void example1() {
    assertThat(p1360.daysBetweenDates("2019-06-29", "2019-06-30")).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(p1360.daysBetweenDates("2020-01-15", "2019-12-31")).isEqualTo(15);
  }
}
