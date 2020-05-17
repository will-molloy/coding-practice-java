package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-17. */
class P1453MaximumNumberOfDartsInsidesACircularDartboardTest {

  private final P1453MaximumNumberOfDartsInsidesACircularDartboard p1453 =
      new P1453MaximumNumberOfDartsInsidesACircularDartboard();

  @Test
  void example1() {
    assertThat(p1453.numPoints(new int[][] {{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, 4)).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p1453.numPoints(new int[][] {{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}}, 5))
        .isEqualTo(5);
  }

  @Test
  void example3() {
    assertThat(p1453.numPoints(new int[][] {{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, 1)).isEqualTo(1);
  }

  @Test
  void example4() {
    assertThat(p1453.numPoints(new int[][] {{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}}, 2))
        .isEqualTo(4);
  }
}
