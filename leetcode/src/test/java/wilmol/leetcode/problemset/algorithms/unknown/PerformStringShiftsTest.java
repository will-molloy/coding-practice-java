package wilmol.leetcode.problemset.algorithms.unknown;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-14. */
class PerformStringShiftsTest {

  private final PerformStringShifts fun = new PerformStringShifts();

  @Test
  void example1() {
    assertThat(fun.stringShift("abc", new int[][] {{0, 1}, {1, 2}})).isEqualTo("cab");
  }

  @Test
  void example2() {
    assertThat(fun.stringShift("abcdefg", new int[][] {{1, 1}, {1, 1}, {0, 2}, {1, 3}}))
        .isEqualTo("efgabcd");
  }

  @Test
  void leftShiftBy1() {
    assertThat(fun.stringShift("abcd", new int[][] {{0, 1}})).isEqualTo("bcda");
  }

  @Test
  void rightShiftBy1() {
    assertThat(fun.stringShift("abcd", new int[][] {{1, 1}})).isEqualTo("dabc");
  }

  @Test
  void noShift() {
    assertThat(fun.stringShift("abcd", new int[0][0])).isEqualTo("abcd");
  }

  @Test
  void combinedShiftGreaterThanStringLength() {
    assertThat(
            fun.stringShift(
                "yisxjwry",
                new int[][] {{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}}))
        .isEqualTo("yisxjwry");
  }
}
