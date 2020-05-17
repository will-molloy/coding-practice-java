package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-17. */
class P463IslandPerimeterTest {

  private final P463IslandPerimeter p463 = new P463IslandPerimeter();

  @Test
  void example() {
    assertThat(
            p463.islandPerimeter(
                new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}))
        .isEqualTo(16);
  }
}
