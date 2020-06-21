package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-21. */
class P174DungeonGameTest {

  private final P174DungeonGame p174 = new P174DungeonGame();

  @Test
  void example() {
    assertThat(
            p174.calculateMinimumHP(
                new int[][] {
                  {-2, -3, 3},
                  {-5, -10, 1},
                  {10, 30, -5},
                }))
        .isEqualTo(7);
  }

  @Test
  void rightOnly() {
    assertThat(
            p174.calculateMinimumHP(
                new int[][] {
                  {-3, 5},
                }))
        .isEqualTo(4);
  }

  @Test
  void downOnly() {
    assertThat(
            p174.calculateMinimumHP(
                new int[][] {
                  {-3}, {5},
                }))
        .isEqualTo(4);
  }

  @Test
  void noDemons() {
    assertThat(
            p174.calculateMinimumHP(
                new int[][] {
                  {2, 3, 3},
                  {5, 10, 1},
                  {10, 30, 5},
                }))
        .isEqualTo(1);
  }

  @Test
  void cantUseFutureFutureMagicOrbs() {
    assertThat(
            p174.calculateMinimumHP(
                new int[][] {
                  {-1, -1, -1, -1, -1, 100},
                }))
        .isEqualTo(6);
  }
}
